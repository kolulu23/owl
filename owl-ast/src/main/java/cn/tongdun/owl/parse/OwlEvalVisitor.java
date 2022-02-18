package cn.tongdun.owl.parse;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.generated.OwlBaseVisitor;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.type.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static cn.tongdun.owl.parse.OwlSemanticErrorEnum.GLOBAL_VAR_NOT_INIT;
import static cn.tongdun.owl.parse.OwlSemanticErrorEnum.VARIABLE_NOT_DEFINED;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 7:02 PM
 */
public class OwlEvalVisitor extends OwlBaseVisitor<OwlVariable> {
    /**
     * DSL context
     */
    private OwlContext owlContext;

    /**
     * Scale for divide operation and rounding. <br/>
     * Affects dividing and statistics calculating functions.
     * Scale indicates that how many digit behind a float point should be.
     */
    private int defaultScale;

    /**
     * Scale for ceiling and flooring.<br/>
     */
    private int ceilFloorScale;

    /**
     * For Variance and Standard deviation
     */
    private static final Variance VARIANCE = new Variance(false);

    private static final String NULL_LITERAL = "null";

    public OwlEvalVisitor(OwlContext owlContext) {
        this.owlContext = owlContext;
        this.defaultScale = 6;
        this.ceilFloorScale = 0;
    }

    //************************ Helper Methods ******************************

    /**
     * Assign statements need to be checked.
     * Assigner type must match assignee's type definition.
     *
     * @param context     Parsing context
     * @param id          Assignee identifier
     * @param assignerVar Assigner variable
     * @param type        required type
     * @return true if type matches
     */
    private boolean requiresType(ParserRuleContext context, String id, OwlVariable assignerVar, OwlType type) {
        if ((assignerVar != null) && type.equals(assignerVar.getType())) {
            return true;
        } else {
            String providedType = assignerVar == null ? "NULL" : assignerVar.getType().name();
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(context);
            String msg = String.format(OwlSemanticErrorEnum.VARIABLE_ASSIGN_TO_WRONG_TYPE.getErrorMsg(),
                    id,
                    type.name(),
                    providedType);
            semanticError.setMessage(msg);
            owlContext.addSemanticError(semanticError);
            return false;
        }
    }

    private boolean requiresKnownType(ParserRuleContext context, OwlVariable variable) {
        if (variable == null || OwlType.UNKNOWN.equals(variable.getType())) {
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(context);
            semanticError.setMessage(OwlSemanticErrorEnum.VARIABLE_TYPE_UNKNOWN.getErrorMsg());
            owlContext.addSemanticError(semanticError);
            return false;
        }
        return true;
    }

    private boolean requiresNumberType(ParserRuleContext context, OwlVariable variable) {
        if (requiresKnownType(context, variable)) {
            if (OwlType.INT.equals(variable.getType()) || OwlType.DOUBLE.equals(variable.getType())) {
                return true;
            } else {
                OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(context);
                String msg = String.format(OwlSemanticErrorEnum.NUMBER_TYPE_REQUIRED.getErrorMsg(), variable.getType());
                semanticError.setMessage(msg);
                owlContext.addSemanticError(semanticError);
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean requiresNumberTypeAndNonNullValue(ParserRuleContext context, OwlVariable variable) {
        return requiresNumberType(context, variable) && variable.getInner().getValue() != null;
    }

    private boolean requiresNonNullVariable(OwlVariable variable) {
        return variable != null && variable.getInner().getValue() != null;
    }

    private boolean requiresSameType(OwlVariable var1, OwlVariable var2) {
        boolean var1isKnown = var1 != null && !OwlType.UNKNOWN.equals(var1.getType());
        boolean var2isKnown = var2 != null && !OwlType.UNKNOWN.equals(var2.getType());
        if (var1isKnown && var2isKnown) {
            return var1.getType().equals(var2.getType());
        } else {
            return false;
        }
    }

    /**
     * If src contains target, returns true.
     * This function only returns true if: <br/>
     * src and target are strings and src contains target.<br/>
     * src is a list in which target's value can be found.
     *
     * @param src    source variable
     * @param target target variable
     * @return true if src contains target
     */
    private boolean variableContains(OwlVariable src, OwlVariable target) {
        boolean srcNotNull = requiresNonNullVariable(src);
        boolean targetNotNull = requiresNonNullVariable(target);
        boolean srcIsString = OwlType.STRING.equals(src.getType());
        boolean srcIsList = OwlType.LIST.equals(src.getType());
        boolean targetIsString = OwlType.STRING.equals(target.getType());
        if (srcNotNull) {
            // A string can not contain null
            if (srcIsString && targetNotNull && targetIsString) {
                String srcString = src.getInner().getStringValue();
                String targetString = target.getInner().getStringValue();
                return srcString.contains(targetString);
            } else if (srcIsList) {
                return src.getInner().getListValue().contains(target);
            }
        }
        return false;
    }

    //********************** Program Execution and Evaluation **************

    @Override
    public OwlVariable visitStat_Return(OwlParser.Stat_ReturnContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public OwlVariable visitProg(OwlParser.ProgContext ctx) {
        List<OwlParser.StatementContext> statementContexts = ctx.statement();
        OwlVariable result = null;
        for (OwlParser.StatementContext statementContext : statementContexts) {
            // variable is not null only if there's a "return xxx;" statement before or right at the last statement.
            result = visit(statementContext);
        }
        if (result == null) {
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(ctx);
            semanticError.setMessage(OwlSemanticErrorEnum.DSL_DOES_NOT_RETURN.getErrorMsg());
            owlContext.addSemanticError(semanticError);
            return null;
        }
        return result;
    }

    @Override
    public OwlVariable visitBlock(OwlParser.BlockContext ctx) {
        for (OwlParser.StatementContext statementContext : ctx.statement()) {
            // Same as what we do in visitProg. For example, "if" block returns early.
            OwlVariable variable = visit(statementContext);
            if (variable != null) {
                return variable;
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitStat_If(OwlParser.Stat_IfContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isBoolean = requiresType(ctx, ctx.expr().getText(), variable, OwlType.BOOLEAN);
        if (!isBoolean) {
            return null;
        }
        Boolean condition = variable.getInner().getBoolValue();
        if (Boolean.TRUE.equals(condition)) {
            return visit(ctx.block());
        }
        return null;
    }

    @Override
    public OwlVariable visitStat_If_Else(OwlParser.Stat_If_ElseContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isBoolean = requiresType(ctx, ctx.expr().getText(), variable, OwlType.BOOLEAN);
        if (!isBoolean) {
            return null;
        }
        Boolean condition = variable.getInner().getBoolValue();
        if (Boolean.TRUE.equals(condition)) {
            return visit(ctx.block(0));
        } else {
            return visit(ctx.block(1));
        }
    }

    //************************ Visit Basic variables ****************************

    @Override
    public OwlVariable visitVar_Identifier(OwlParser.Var_IdentifierContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable variable = owlContext.getVariable(id);
        if (variable == null) {
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(ctx);
            semanticError.setMessage(VARIABLE_NOT_DEFINED.getErrorMsg() + id);
            owlContext.addSemanticError(semanticError);
        }
        return variable;
    }

    @Override
    public OwlVariable visitVar_GlobalVar(OwlParser.Var_GlobalVarContext ctx) {
        String id = ctx.getRuleContext().getText();
        OwlVariable variable = owlContext.getVariable(id);
        if (variable == null) {
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(ctx);
            semanticError.setMessage(GLOBAL_VAR_NOT_INIT.getErrorMsg() + id);
            owlContext.addSemanticError(semanticError);
        }
        return variable;
    }

    @Override
    public OwlVariable visitLit_Int(OwlParser.Lit_IntContext ctx) {
        String str = ctx.INT().getText();
        Long val = Long.parseLong(str);
        return new OwlIntVariable(val);
    }

    @Override
    public OwlVariable visitLit_Neg_Int(OwlParser.Lit_Neg_IntContext ctx) {
        String str = ctx.INT().getText();
        long val = Long.parseLong(str);
        return new OwlIntVariable(-val);
    }

    @Override
    public OwlVariable visitLit_Double(OwlParser.Lit_DoubleContext ctx) {
        String str = ctx.DOUBLE().getText();
        BigDecimal val = BigDecimal.valueOf(Double.parseDouble(str));
        return new OwlDoubleVariable(val);
    }

    @Override
    public OwlVariable visitLit_Neg_Double(OwlParser.Lit_Neg_DoubleContext ctx) {
        String str = ctx.DOUBLE().getText();
        BigDecimal val = BigDecimal.valueOf(Double.parseDouble(str));
        return new OwlDoubleVariable(val.negate());
    }

    @Override
    public OwlVariable visitLit_String(OwlParser.Lit_StringContext ctx) {
        String str = ctx.STRING().getText();
        return new OwlStringVariable(str.substring(1, str.length() - 1));
    }

    @Override
    public OwlVariable visitLit_Boolean(OwlParser.Lit_BooleanContext ctx) {
        String str = ctx.BOOLEAN().getText();
        Boolean val = Boolean.parseBoolean(str);
        return new OwlBoolVariable(val);
    }

    @Override
    public OwlVariable visitArr_Sized(OwlParser.Arr_SizedContext ctx) {
        List<OwlVariable> arr = new ArrayList<>();
        for (OwlParser.VarContext varContext : ctx.var()) {
            OwlVariable item = visit(varContext);
            arr.add(item);
        }
        OwlListVariable variable = new OwlListVariable();
        variable.setValue(arr);
        return variable;
    }

    @Override
    public OwlVariable visitArr_Empty(OwlParser.Arr_EmptyContext ctx) {
        List<OwlVariable> arr = new ArrayList<>();
        OwlListVariable variable = new OwlListVariable();
        variable.setValue(arr);
        return variable;
    }

    //************************ Assign Variables ****************************

    @Override
    public OwlVariable visitStat_Def(OwlParser.Stat_DefContext ctx) {
        visit(ctx.vardef());
        return null;
    }

    /**
     * Assigner takes assignee's id rather than assignee takes assigner's value
     * so references to assignee are still untouched by assign. <br/>
     * For example, after executing this unit {@code int a = 2; list x = [a]; a = 3; return x;}<br/>
     * variable {@code a} will be {@code 3} and variable {@code x} will be {@code [2]}.
     *
     * @param ctx parsing assign context
     * @return statements returns nothing but null
     */
    @Override
    public OwlVariable visitStat_Assign(OwlParser.Stat_AssignContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable assigneeVar = owlContext.getVariable(id);
        OwlVariable assignerVar = visit(ctx.expr());
        if (assigneeVar == null || assigneeVar.getType() == OwlType.UNKNOWN) {
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(ctx);
            String msg = String.format(OwlSemanticErrorEnum.ASSIGN_TO_UNKNOWN_VARIABLE.getErrorMsg(), id);
            semanticError.setMessage(msg);
            owlContext.addSemanticError(semanticError);
            return null;
        }
        boolean typeCheckOk = requiresType(ctx, id, assignerVar, assigneeVar.getType());
        assignerVar.setId(assigneeVar.getId());
        if (typeCheckOk) {
            owlContext.addVariable(assignerVar, false);
        }
        return null;
    }

    @Override
    public OwlVariable visitDef_Int(OwlParser.Def_IntContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable variable = visit(ctx.expr());
        boolean typeCheckOk = requiresType(ctx, id, variable, OwlType.INT);
        if (typeCheckOk) {
            variable.setId(id);
            owlContext.addVariable(variable, false);
        }
        // Statements do not return anything
        return null;
    }

    @Override
    public OwlVariable visitDef_Double(OwlParser.Def_DoubleContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable variable = visit(ctx.expr());
        boolean typeCheckOk = requiresType(ctx, id, variable, OwlType.DOUBLE);
        if (typeCheckOk) {
            variable.setId(id);
            owlContext.addVariable(variable, false);
        }
        return null;
    }

    @Override
    public OwlVariable visitDef_Boolean(OwlParser.Def_BooleanContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable variable = visit(ctx.expr());
        boolean typeCheckOk = requiresType(ctx, id, variable, OwlType.BOOLEAN);
        if (typeCheckOk) {
            variable.setId(id);
            owlContext.addVariable(variable, false);
        }
        return null;
    }

    @Override
    public OwlVariable visitDef_String(OwlParser.Def_StringContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable variable = visit(ctx.expr());
        boolean typeCheckOk = requiresType(ctx, id, variable, OwlType.STRING);
        if (typeCheckOk) {
            variable.setId(id);
            owlContext.addVariable(variable, false);
        }
        return null;
    }

    @Override
    public OwlVariable visitDef_List(OwlParser.Def_ListContext ctx) {
        String id = ctx.ID().getText();
        OwlVariable variable = visit(ctx.expr());
        boolean typeCheckOk = requiresType(ctx, id, variable, OwlType.LIST);
        if (typeCheckOk) {
            variable.setId(id);
            owlContext.addVariable(variable, false);
        }
        return null;
    }

    //************************ Basic Expression *************************

    @Override
    public OwlVariable visitMulDiv(OwlParser.MulDivContext ctx) {
        OwlVariable leftVar = visit(ctx.expr(0));
        OwlVariable rightVar = visit(ctx.expr(1));
        boolean typeCheckOk = this.requiresNumberType(ctx, leftVar) && this.requiresNumberType(ctx, rightVar);
        if (!typeCheckOk) {
            return null;
        }
        BigDecimal leftValue = new BigDecimal(leftVar.getInner().getValue().toString());
        BigDecimal rightValue = new BigDecimal(rightVar.getInner().getValue().toString());
        OwlDoubleVariable result = new OwlDoubleVariable();
        if (ctx.op.getType() == OwlParser.MUL) {
            result.setValue(leftValue.multiply(rightValue));
        } else {
            // Avoid this runtime error
            if (rightValue.equals(BigDecimal.ZERO)) {
                OwlSemanticError error = OwlSemanticErrorFactory.semanticErrorOf(ctx);
                error.setMessage(OwlSemanticErrorEnum.DIVIDE_ZERO.getErrorMsg());
                owlContext.addSemanticError(error);
                return null;
            }
            result.setValue(leftValue.divide(rightValue, defaultScale, RoundingMode.HALF_UP));
        }
        return result;
    }

    @Override
    public OwlVariable visitAddSub(OwlParser.AddSubContext ctx) {
        OwlVariable leftVar = visit(ctx.expr(0));
        OwlVariable rightVar = visit(ctx.expr(1));
        boolean typeCheckOk = this.requiresNumberType(ctx, leftVar) && this.requiresNumberType(ctx, rightVar);
        if (!typeCheckOk) {
            return null;
        }
        if (OwlType.INT.equals(leftVar.getType()) && OwlType.INT.equals(rightVar.getType())) {
            OwlIntVariable result = new OwlIntVariable();
            Long leftValue = leftVar.getInner().getIntValue();
            Long rightValue = rightVar.getInner().getIntValue();
            // Yes, 'null + <any> = null'
            if (leftValue == null || rightValue == null) {
                return null;
            }
            if (ctx.op.getType() == OwlParser.ADD) {
                result.setValue(leftValue + rightValue);
            } else {
                result.setValue(leftValue - rightValue);
            }
            return result;
        } else {
            OwlDoubleVariable result = new OwlDoubleVariable();
            Object leftValue = leftVar.getInner().getValue();
            Object rightValue = rightVar.getInner().getValue();
            if (leftValue == null || rightValue == null) {
                return null;
            }
            BigDecimal leftDecimal = new BigDecimal(leftValue.toString());
            BigDecimal rightDecimal = new BigDecimal(rightValue.toString());
            if (ctx.op.getType() == OwlParser.ADD) {
                result.setValue(leftDecimal.add(rightDecimal));
            } else {
                result.setValue(leftDecimal.subtract(rightDecimal));
            }
            return result;
        }
    }

    /**
     * Comparing numbers, bools, strings and lists.
     * Strings and lists only implement {@code EQ} and {@code NEQ}. <br/>
     * For example, {@code "x" == "x"} evaluates to true, {@code [1, 2] == [1]} evaluates to false.
     *
     * @param ctx compare num context
     * @return bool variable {@link OwlBoolVariable}
     */
    @Override
    public OwlVariable visitCompareNum(OwlParser.CompareNumContext ctx) {
        int type = ctx.op.getType();
        OwlVariable leftVar = visit(ctx.expr(0));
        OwlVariable rightVar = visit(ctx.expr(1));
        OwlBoolVariable result = new OwlBoolVariable(false);
        if (OwlParser.EQ == type) {
            boolean sameType = requiresSameType(leftVar, rightVar);
            if (sameType) {
                result.setValue(leftVar.getInner().equals(rightVar.getInner()));
            }
        } else if (OwlParser.NEQ == type) {
            boolean sameType = requiresSameType(leftVar, rightVar);
            if (sameType) {
                result.setValue(!leftVar.getInner().equals(rightVar.getInner()));
            } else {
                result.setValue(true);
            }
        } else {
            boolean isNumberVar = requiresNumberType(ctx, leftVar) && requiresNumberType(ctx, rightVar);
            if (isNumberVar) {
                BigDecimal leftValue = new BigDecimal(leftVar.getInner().getValue().toString());
                BigDecimal rightValue = new BigDecimal(rightVar.getInner().getValue().toString());
                int compareResult = leftValue.compareTo(rightValue);
                if (OwlParser.LT == type) {
                    result.setValue(compareResult < 0);
                } else if (OwlParser.LTEQ == type) {
                    result.setValue(compareResult <= 0);
                } else if (OwlParser.GT == type) {
                    result.setValue(compareResult > 0);
                } else if (OwlParser.GTEQ == type) {
                    result.setValue(compareResult >= 0);
                }
            }
        }
        return result;
    }

    @Override
    public OwlVariable visitBoolExpr(OwlParser.BoolExprContext ctx) {
        int type = ctx.op.getType();
        OwlVariable leftVar = visit(ctx.expr(0));
        OwlVariable rightVar = visit(ctx.expr(1));
        OwlBoolVariable result = new OwlBoolVariable(false);
        // If one of them is not a bool, just returns false. I don't think we should add an extra semantic error for it.
        if (OwlType.BOOLEAN.equals(leftVar.getType()) && OwlType.BOOLEAN.equals(rightVar.getType())) {
            Boolean leftValue = leftVar.getInner().getBoolValue();
            Boolean rightValue = rightVar.getInner().getBoolValue();
            if (leftValue != null && rightValue != null) {
                if (OwlParser.AND == type) {
                    result.setValue(leftValue && rightValue);
                } else if (OwlParser.OR == type) {
                    result.setValue(leftValue || rightValue);
                }
            }
        }
        return result;
    }

    @Override
    public OwlVariable visitVarRef(OwlParser.VarRefContext ctx) {
        return visit(ctx.var());
    }

    @Override
    public OwlVariable visitParenExpr(OwlParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    //************************ Functions *************************

    @Override
    public OwlVariable visitFn_Nvl(OwlParser.Fn_NvlContext ctx) {
        OwlVariable left = visit(ctx.expr(0));
        OwlVariable right = visit(ctx.expr(1));
        boolean leftIsNonNull = requiresNonNullVariable(left);
        boolean rightIsNonNull = requiresNonNullVariable(right);
        if (leftIsNonNull && rightIsNonNull) {
            return left;
        } else if (leftIsNonNull) {
            return left;
        } else if (rightIsNonNull) {
            return right;
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Append(OwlParser.Fn_AppendContext ctx) {
        OwlVariable listVariable = visit(ctx.expr(0));
        OwlVariable variable = visit(ctx.expr(1));
        boolean isList = requiresType(ctx, ctx.expr(0).getText(), listVariable, OwlType.LIST);
        if (isList && requiresNonNullVariable(listVariable)) {
            listVariable.getInner().getListValue().add(variable);
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Union(OwlParser.Fn_UnionContext ctx) {
        OwlVariable left = visit(ctx.expr(0));
        OwlVariable right = visit(ctx.expr(1));
        boolean bothAreList = requiresType(ctx, ctx.expr(0).getText(), left, OwlType.LIST)
                && requiresType(ctx, ctx.expr(1).getText(), right, OwlType.LIST);
        if (!bothAreList) {
            return null;
        }
        OwlListVariable unionVar = new OwlListVariable();
        List<OwlVariable> union = new ArrayList<>(CollectionUtils.union(left.getInner().getListValue(),
                right.getInner().getListValue()));
        unionVar.setValue(union);
        return unionVar;
    }

    @Override
    public OwlVariable visitFn_Intersection(OwlParser.Fn_IntersectionContext ctx) {
        OwlVariable left = visit(ctx.expr(0));
        OwlVariable right = visit(ctx.expr(1));
        boolean bothAreList = requiresType(ctx, ctx.expr(0).getText(), left, OwlType.LIST)
                && requiresType(ctx, ctx.expr(1).getText(), right, OwlType.LIST);
        if (!bothAreList) {
            return null;
        }
        OwlListVariable intersectVar = new OwlListVariable();
        List<OwlVariable> intersection = new ArrayList<>(CollectionUtils.intersection(left.getInner().getListValue(),
                right.getInner().getListValue()));
        intersectVar.setValue(intersection);
        return intersectVar;
    }

    @Override
    public OwlVariable visitFn_Dedup(OwlParser.Fn_DedupContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isListVat = requiresType(ctx, ctx.expr().getText(), variable, OwlType.LIST);
        if (!isListVat) {
            return null;
        }
        OwlListVariable deduplicated = new OwlListVariable();
        deduplicated.setValue(new ArrayList<>(new HashSet<>(variable.getInner().getListValue())));
        return deduplicated;
    }

    @Override
    public OwlVariable visitFn_Sort(OwlParser.Fn_SortContext ctx) {
        OwlVariable variable = visit(ctx.expr(0));
        OwlVariable ascending = ctx.asc == null ? new OwlBoolVariable(true) : visit(ctx.asc);
        boolean isListVar = requiresType(ctx, ctx.expr(0).getText(), variable, OwlType.LIST);
        if (!isListVar) {
            return null;
        }
        Comparator<OwlVariable> comparator = Boolean.TRUE.equals(ascending.getInner().getBoolValue())
                ? new OwlAscendingComparator()
                : new OwlDescendingComparator();
        List<OwlVariable> copied = new ArrayList<>(variable.getInner().getListValue());
        OwlListVariable result = new OwlListVariable(copied);
        result.getInner().getListValue().sort(comparator);
        return result;
    }

    @Override
    public OwlVariable visitFn_ToNumber(OwlParser.Fn_ToNumberContext ctx) {
        OwlVariable variable = visit(ctx.expr(0));
        int scale = this.defaultScale;
        if (ctx.scale != null) {
            Long scaleVar = visit(ctx.scale).getInner().getIntValue();
            scale = scaleVar == null ? this.defaultScale : scaleVar.intValue();
        }
        if (requiresNonNullVariable(variable)) {
            OwlDoubleVariable result = new OwlDoubleVariable();
            if (OwlType.INT.equals(variable.getType())) {
                return variable;
            } else if (OwlType.DOUBLE.equals(variable.getType())) {
                BigDecimal scaledValue = variable.getInner().getDoubleValue();
                result.setValue(scaledValue.round(new MathContext(scale, RoundingMode.HALF_UP)));
                return result;
            } else if (OwlType.STRING.equals(variable.getType())) {
                BigDecimal convertedValue = new BigDecimal(variable.getInner().getStringValue());
                result.setValue(convertedValue.round(new MathContext(scale, RoundingMode.HALF_UP)));
                return result;
            } else {
                OwlSemanticError semanticError = OwlSemanticErrorFactory
                        .wrongTypeForFunc(ctx, ctx.FN_TONUMBER().getText(), variable.getType());
                owlContext.addSemanticError(semanticError);
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Eq(OwlParser.Fn_EqContext ctx) {
        OwlVariable left = visit(ctx.expr(0));
        OwlVariable right = visit(ctx.expr(1));
        OwlBoolVariable result = new OwlBoolVariable(false);
        boolean leftNonNull = requiresNonNullVariable(left);
        boolean rightNonNull = requiresNonNullVariable(right);
        // null equals to null
        if (!leftNonNull && !rightNonNull) {
            result.setValue(true);
        } else if (leftNonNull && rightNonNull) {
            result.setValue(left.getInner().equals(right.getInner()));
        }
        return result;
    }

    @Override
    public OwlVariable visitFn_NEq(OwlParser.Fn_NEqContext ctx) {
        OwlVariable left = visit(ctx.expr(0));
        OwlVariable right = visit(ctx.expr(1));
        OwlBoolVariable result = new OwlBoolVariable(false);
        boolean leftNonNull = requiresNonNullVariable(left);
        boolean rightNonNull = requiresNonNullVariable(right);
        if (leftNonNull && rightNonNull) {
            result.setValue(!left.getInner().equals(right.getInner()));
        } else if (leftNonNull || rightNonNull) {
            result.setValue(true);
        }
        return result;
    }

    @Override
    public OwlVariable visitFn_Round(OwlParser.Fn_RoundContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isNumberVar = requiresNumberType(ctx, variable);
        if (isNumberVar) {
            if (OwlType.INT.equals(variable.getType())) {
                return variable;
            } else {
                int roundingScale = ctx.INT() == null ? this.defaultScale : Integer.parseInt(ctx.INT().getText());
                BigDecimal value = variable.getInner().getDoubleValue();
                if (value != null) {
                    OwlDoubleVariable roundingNumber = new OwlDoubleVariable();
                    roundingNumber.setValue(value.setScale(roundingScale, RoundingMode.HALF_UP));
                    return roundingNumber;
                }
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Ceil(OwlParser.Fn_CeilContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isNumberVar = requiresNumberType(ctx, variable);
        if (isNumberVar) {
            if (OwlType.INT.equals(variable.getType())) {
                return variable;
            } else {
                BigDecimal value = variable.getInner().getDoubleValue();
                if (value != null) {
                    OwlDoubleVariable ceilingNumber = new OwlDoubleVariable();
                    ceilingNumber.setValue(value.setScale(this.ceilFloorScale, RoundingMode.CEILING));
                    return ceilingNumber;
                }
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Floor(OwlParser.Fn_FloorContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isNumberVar = requiresNumberType(ctx, variable);
        if (isNumberVar) {
            if (OwlType.INT.equals(variable.getType())) {
                return variable;
            } else {
                BigDecimal value = variable.getInner().getDoubleValue();
                if (value != null) {
                    OwlDoubleVariable floorNumber = new OwlDoubleVariable();
                    floorNumber.setValue(value.setScale(this.ceilFloorScale, RoundingMode.FLOOR));
                    return floorNumber;
                }
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_IsNull(OwlParser.Fn_IsNullContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        OwlBoolVariable result = new OwlBoolVariable();
        result.setValue(variable == null || variable.getInner().getValue() == null);
        return result;
    }

    @Override
    public OwlVariable visitFn_IsNotNull(OwlParser.Fn_IsNotNullContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        OwlBoolVariable result = new OwlBoolVariable();
        result.setValue(variable != null && variable.getInner().getValue() != null);
        return result;
    }

    @Override
    public OwlVariable visitFn_Substr(OwlParser.Fn_SubstrContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isString = requiresType(ctx, ctx.expr().getText(), variable, OwlType.STRING);
        if (!isString || variable.getInner().getValue() == null) {
            return null;
        }
        String src = variable.getInner().getStringValue();
        // TODO Support optional args in Owl's grammar
        int start = ctx.start == null ? 0 : Integer.parseInt(ctx.start.getText());
        int end = ctx.end == null ? src.length() : Integer.parseInt(ctx.end.getText());
        if (start < 0) {
            start = 0;
        }
        if (end > src.length()) {
            end = src.length();
        }
        if (start > end) {
            start = end;
        }
        OwlStringVariable result = new OwlStringVariable();
        String truncated = src.substring(start, end);
        result.setValue(truncated);
        return result;
    }

    @Override
    public OwlVariable visitFn_Concat(OwlParser.Fn_ConcatContext ctx) {
        OwlVariable strA = visit(ctx.expr(0));
        OwlVariable strB = visit(ctx.expr(1));
        boolean isString = requiresType(ctx, ctx.expr(0).getText(), strA, OwlType.STRING)
                && requiresType(ctx, ctx.expr(1).getText(), strB, OwlType.STRING);
        if (!isString) {
            return null;
        }
        String separator = "";
        if (ctx.sep != null) {
            OwlVariable sepVar = visit(ctx.sep);
            if (requiresNonNullVariable(sepVar)) {
                separator = sepVar.getInner().getStringValue();
            }
        }
        OwlStringVariable result = new OwlStringVariable();
        // null strings will be joined as "null"
        result.setValue(String.join(separator, strA.getInner().getStringValue(), strB.getInner().getStringValue()));
        return result;
    }

    @Override
    public OwlVariable visitFn_Trim(OwlParser.Fn_TrimContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isString = requiresType(ctx, ctx.expr().getText(), variable, OwlType.STRING);
        if (!isString || variable.getInner().getValue() == null) {
            return null;
        }
        OwlStringVariable result = new OwlStringVariable();
        result.setValue(variable.getInner().getStringValue().trim());
        return result;
    }

    @Override
    public OwlVariable visitFn_Contains(OwlParser.Fn_ContainsContext ctx) {
        OwlVariable src = visit(ctx.expr(0));
        OwlVariable target = visit(ctx.expr(1));
        OwlBoolVariable result = new OwlBoolVariable(false);
        result.setValue(variableContains(src, target));
        return result;
    }

    @Override
    public OwlVariable visitFn_NotContains(OwlParser.Fn_NotContainsContext ctx) {
        OwlVariable src = visit(ctx.expr(0));
        OwlVariable target = visit(ctx.expr(1));
        OwlBoolVariable result = new OwlBoolVariable(false);
        result.setValue(!variableContains(src, target));
        return result;
    }

    @Override
    public OwlVariable visitFn_ToString(OwlParser.Fn_ToStringContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        OwlStringVariable result = new OwlStringVariable();
        if (variable == null || variable.getInner().getValue() == null) {
            // Literal null
            result.setValue(NULL_LITERAL);
        } else if (OwlType.LIST.equals(variable.getType())) {
            List<String> items = variable.getInner().getListValue().stream().map(var -> {
                if (var == null || var.getInner().getValue() == null) {
                    return NULL_LITERAL;
                } else {
                    return var.getInner().getValue().toString();
                }
            }).collect(Collectors.toList());
            result.setValue("[" + StringUtils.join(items, ',') + "]");
        } else {
            result.setValue(variable.getInner().getValue().toString());
        }
        return result;
    }

    @Override
    public OwlVariable visitFn_Len(OwlParser.Fn_LenContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean validVar = requiresKnownType(ctx, variable) && variable.getInner().getValue() != null;
        if (validVar) {
            OwlIntVariable result = new OwlIntVariable();
            if (OwlType.LIST.equals(variable.getType())) {
                result.setValue((long) variable.getInner().getListValue().size());
            } else if (OwlType.BOOLEAN.equals(variable.getType())) {
                result.setValue(1L);
            } else {
                result.setValue((long) variable.getInner().getValue().toString().length());
            }
            return result;
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Rand(OwlParser.Fn_RandContext ctx) {
        OwlDoubleVariable variable = new OwlDoubleVariable();
        variable.setValue(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble()));
        return variable;
    }

    @Override
    public OwlVariable visitFn_Abs(OwlParser.Fn_AbsContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        if (!requiresNumberTypeAndNonNullValue(ctx, variable)) {
            return null;
        }
        // Does not consume the original value but create a new instance of variable
        if (OwlType.DOUBLE.equals(variable.getType())) {
            OwlDoubleVariable abs = new OwlDoubleVariable();
            abs.setValue(variable.getInner().getDoubleValue().abs());
            return abs;
        } else {
            OwlIntVariable abs = new OwlIntVariable();
            abs.setValue(Math.abs(variable.getInner().getIntValue()));
            return abs;
        }
    }

    @Override
    public OwlVariable visitFn_Avg(OwlParser.Fn_AvgContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isListType = requiresType(ctx, ctx.expr().getText(), variable, OwlType.LIST);
        OwlDoubleVariable result = new OwlDoubleVariable();
        if (isListType) {
            List<? extends OwlVariable> list = variable.getInner().getListValue();
            if (list == null) {
                return null;
            }
            BigDecimal sum = BigDecimal.ZERO;
            BigDecimal size = new BigDecimal(list.size());
            for (OwlVariable owlVariable : list) {
                if (owlVariable != null && owlVariable.getInner().getValue() != null) {
                    if (OwlType.INT.equals(owlVariable.getType())) {
                        sum = sum.add(new BigDecimal(owlVariable.getInner().getIntValue()));
                    } else if (OwlType.DOUBLE.equals(owlVariable.getType())) {
                        sum = sum.add(owlVariable.getInner().getDoubleValue());
                    }
                }
            }
            result.setValue(sum.divide(size, this.defaultScale, RoundingMode.HALF_UP));
            return result;
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Max(OwlParser.Fn_MaxContext ctx) {
        // We can not compare int and double directly, so we need unify types first.
        OwlDoubleVariable maximum = new OwlDoubleVariable(new BigDecimal(Double.MIN_VALUE));
        int nonOperableExprCount = 0;
        for (OwlParser.ExprContext exprContext : ctx.expr()) {
            OwlVariable variable = visit(exprContext);
            if (variable != null) {
                BigDecimal comparedValue;
                if (OwlType.INT.equals(variable.getType())) {
                    comparedValue = new BigDecimal(variable.getInner().getIntValue());
                    maximum.setValue(maximum.getDoubleValue().max(comparedValue));
                } else if (OwlType.DOUBLE.equals(variable.getType())) {
                    comparedValue = variable.getInner().getDoubleValue();
                    maximum.setValue(maximum.getDoubleValue().max(comparedValue));
                } else {
                    nonOperableExprCount += 1;
                }
            } else {
                nonOperableExprCount += 1;
            }
        }
        if (nonOperableExprCount == ctx.expr().size()) {
            owlContext.addSemanticError(OwlSemanticErrorFactory.noOperableArgForFunc(ctx, ctx.FN_MAX().getText()));
            return null;
        } else {
            return maximum;
        }
    }

    @Override
    public OwlVariable visitFn_Min(OwlParser.Fn_MinContext ctx) {
        OwlDoubleVariable minimum = new OwlDoubleVariable(new BigDecimal(Double.MAX_VALUE));
        int nonOperableExprCount = 0;
        for (OwlParser.ExprContext exprContext : ctx.expr()) {
            OwlVariable variable = visit(exprContext);
            if (variable != null) {
                BigDecimal comparedValue;
                if (OwlType.INT.equals(variable.getType())) {
                    comparedValue = new BigDecimal(variable.getInner().getIntValue());
                    minimum.setValue(minimum.getDoubleValue().min(comparedValue));
                } else if (OwlType.DOUBLE.equals(variable.getType())) {
                    comparedValue = variable.getInner().getDoubleValue();
                    minimum.setValue(minimum.getDoubleValue().min(comparedValue));
                } else {
                    nonOperableExprCount += 1;
                }
            } else {
                nonOperableExprCount += 1;
            }
        }
        if (nonOperableExprCount == ctx.expr().size()) {
            owlContext.addSemanticError(OwlSemanticErrorFactory.noOperableArgForFunc(ctx, ctx.FN_MIN().getText()));
            return null;
        } else {
            return minimum;
        }
    }

    @Override
    public OwlVariable visitFn_Sum(OwlParser.Fn_SumContext ctx) {
        OwlDoubleVariable sum = new OwlDoubleVariable(BigDecimal.ZERO);
        int nonOperableExprCount = 0;
        for (OwlParser.ExprContext exprContext : ctx.expr()) {
            OwlVariable variable = visit(exprContext);
            if (variable != null) {
                if (OwlType.INT.equals(variable.getType())) {
                    sum.setValue(sum.getDoubleValue().add(new BigDecimal(variable.getInner().getIntValue())));
                } else if (OwlType.DOUBLE.equals(variable.getType())) {
                    sum.setValue(sum.getDoubleValue().add(variable.getInner().getDoubleValue()));
                } else {
                    nonOperableExprCount += 1;
                }
            } else {
                nonOperableExprCount += 1;
            }
        }
        if (nonOperableExprCount == ctx.expr().size()) {
            owlContext.addSemanticError(OwlSemanticErrorFactory.noOperableArgForFunc(ctx, ctx.FN_SUM().getText()));
            return null;
        } else {
            return sum;
        }
    }

    @Override
    public OwlVariable visitFn_Std(OwlParser.Fn_StdContext ctx) {
        OwlDoubleVariable result = new OwlDoubleVariable();
        List<OwlParser.ExprContext> exprList = ctx.expr();
        double[] samples = new double[exprList.size()];
        int sampleIndex = 0;
        for (OwlParser.ExprContext exprContext : exprList) {
            OwlVariable variable = visit(exprContext);
            if (requiresNumberTypeAndNonNullValue(ctx, variable)) {
                samples[sampleIndex] = new Double(variable.getInner().getValue().toString());
                sampleIndex++;
            }
        }
        result.setValue(BigDecimal.valueOf(Math.sqrt(VARIANCE.evaluate(samples))));
        return result;
    }

    @Override
    public OwlVariable visitFn_Variance(OwlParser.Fn_VarianceContext ctx) {
        OwlDoubleVariable result = new OwlDoubleVariable();
        List<OwlParser.ExprContext> exprList = ctx.expr();
        double[] samples = new double[exprList.size()];
        int sampleIndex = 0;
        for (OwlParser.ExprContext exprContext : exprList) {
            OwlVariable variable = visit(exprContext);
            if (requiresNumberTypeAndNonNullValue(ctx, variable)) {
                samples[sampleIndex] = new Double(variable.getInner().getValue().toString());
                sampleIndex++;
            }
        }
        result.setValue(BigDecimal.valueOf(VARIANCE.evaluate(samples)));
        return result;
    }

    public OwlContext getOwlContext() {
        return owlContext;
    }

    public void setOwlContext(OwlContext owlContext) {
        this.owlContext = owlContext;
    }

    public int getDefaultScale() {
        return defaultScale;
    }

    public void setDefaultScale(int defaultScale) {
        this.defaultScale = defaultScale;
    }

    public int getCeilFloorScale() {
        return ceilFloorScale;
    }

    public void setCeilFloorScale(int ceilFloorScale) {
        this.ceilFloorScale = ceilFloorScale;
    }
}
