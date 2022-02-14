package cn.tongdun.owl.parse;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.generated.OwlBaseVisitor;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.type.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
     * Scale for divide operation. <br/>
     * Affects dividing and statistics calculating functions.
     */
    private int divideScale;

    /**
     * Scale for rounding.<br/>
     * Affects ceiling and flooring.
     */
    private int roundingScale;

    public OwlEvalVisitor(OwlContext owlContext) {
        this.owlContext = owlContext;
        this.divideScale = 4;
        this.roundingScale = 1;
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

    private boolean requiresSameType(ParserRuleContext context, OwlVariable var1, OwlVariable var2) {
        boolean var1isKnown = var1 != null && !OwlType.UNKNOWN.equals(var1.getType());
        boolean var2isKnown = var2 != null && !OwlType.UNKNOWN.equals(var2.getType());
        if (var1isKnown && var2isKnown) {
            return var1.getType().equals(var2.getType());
        } else {
            return false;
        }
    }

    //********************** Program Execution and Evaluation **************

    @Override
    public OwlVariable visitStat_Return(OwlParser.Stat_ReturnContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public OwlVariable visitProg(OwlParser.ProgContext ctx) {
        List<OwlParser.StatementContext> statementContexts = ctx.statement();
        for (int i = 0; i < statementContexts.size() - 1; i++) {
            visit(statementContexts.get(i));
        }
        OwlParser.StatementContext lastStatement = statementContexts.get(statementContexts.size() - 1);
        // Evaluate last statement only if it is a 'return expr'
        if (lastStatement instanceof OwlParser.Stat_ReturnContext) {
            return visitStat_Return((OwlParser.Stat_ReturnContext) lastStatement);
        } else {
            OwlSemanticError semanticError = OwlSemanticErrorFactory.semanticErrorOf(lastStatement);
            semanticError.setMessage(OwlSemanticErrorEnum.DSL_DOES_NOT_RETURN.getErrorMsg());
            owlContext.addSemanticError(semanticError);
            return null;
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
        Integer val = Integer.valueOf(str);
        return new OwlIntVariable(val);
    }

    @Override
    public OwlVariable visitLit_Neg_Int(OwlParser.Lit_Neg_IntContext ctx) {
        String str = ctx.INT().getText();
        int val = Integer.parseInt(str);
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
        List<? extends OwlVariable> arr = new ArrayList<>();
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
        if (typeCheckOk) {
            owlContext.addVariable(assigneeVar, false);
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
        OwlVariable variable = visit(ctx.arr());
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
            result.setValue(leftValue.divide(rightValue, divideScale, RoundingMode.HALF_UP));
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
            Integer leftValue = leftVar.getInner().getIntValue();
            Integer rightValue = rightVar.getInner().getIntValue();
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
            boolean sameType = requiresSameType(ctx, leftVar, rightVar);
            if (sameType) {
                result.setValue(leftVar.getInner().equals(rightVar.getInner()));
            }
        } else if (OwlParser.NEQ == type) {
            boolean sameType = requiresSameType(ctx, leftVar, rightVar);
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
    public OwlVariable visitFn_Max(OwlParser.Fn_MaxContext ctx) {
        OwlDoubleVariable maximum = new OwlDoubleVariable(new BigDecimal(Double.MIN_VALUE));
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
                }
            }
        }
        return maximum;
    }

    @Override
    public OwlVariable visitFn_Nvl(OwlParser.Fn_NvlContext ctx) {
        return super.visitFn_Nvl(ctx);
    }

    @Override
    public OwlVariable visitFn_Append(OwlParser.Fn_AppendContext ctx) {
        return super.visitFn_Append(ctx);
    }

    @Override
    public OwlVariable visitFn_Std(OwlParser.Fn_StdContext ctx) {
        return super.visitFn_Std(ctx);
    }

    @Override
    public OwlVariable visitFn_Round(OwlParser.Fn_RoundContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        boolean isNumberVar = requiresNumberType(ctx, variable);
        if (isNumberVar) {
            if (OwlType.INT.equals(variable.getType())) {
                return variable;
            } else {
                int roundingScale = ctx.INT() == null ? this.roundingScale : Integer.parseInt(ctx.INT().getText());
                BigDecimal value = variable.getInner().getDoubleValue();
                if (value != null) {
                    OwlDoubleVariable roundingNumber = new OwlDoubleVariable();
                    roundingNumber.setValue(value.round(new MathContext(roundingScale, RoundingMode.HALF_UP)));
                    return roundingNumber;
                }
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_ToNumber(OwlParser.Fn_ToNumberContext ctx) {
        return super.visitFn_ToNumber(ctx);
    }

    @Override
    public OwlVariable visitFn_Eq(OwlParser.Fn_EqContext ctx) {
        return super.visitFn_Eq(ctx);
    }

    @Override
    public OwlVariable visitFn_Variance(OwlParser.Fn_VarianceContext ctx) {
        return super.visitFn_Variance(ctx);
    }

    @Override
    public OwlVariable visitFn_Abs(OwlParser.Fn_AbsContext ctx) {
        OwlVariable variable = visit(ctx.expr());
        if (!requiresNumberType(ctx, variable) || variable.getInner().getValue() == null) {
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
    public OwlVariable visitFn_IsNull(OwlParser.Fn_IsNullContext ctx) {
        return super.visitFn_IsNull(ctx);
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
                    ceilingNumber.setValue(value.round(new MathContext(this.roundingScale, RoundingMode.CEILING)));
                    return ceilingNumber;
                }
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Substr(OwlParser.Fn_SubstrContext ctx) {
        return super.visitFn_Substr(ctx);
    }

    @Override
    public OwlVariable visitFn_IsNotNull(OwlParser.Fn_IsNotNullContext ctx) {
        return super.visitFn_IsNotNull(ctx);
    }

    @Override
    public OwlVariable visitFn_Union(OwlParser.Fn_UnionContext ctx) {
        return super.visitFn_Union(ctx);
    }

    @Override
    public OwlVariable visitFn_Concat(OwlParser.Fn_ConcatContext ctx) {
        return super.visitFn_Concat(ctx);
    }

    @Override
    public OwlVariable visitFn_NEq(OwlParser.Fn_NEqContext ctx) {
        return super.visitFn_NEq(ctx);
    }

    @Override
    public OwlVariable visitFn_Dedup(OwlParser.Fn_DedupContext ctx) {
        return super.visitFn_Dedup(ctx);
    }

    @Override
    public OwlVariable visitFn_ToString(OwlParser.Fn_ToStringContext ctx) {
        return super.visitFn_ToString(ctx);
    }

    @Override
    public OwlVariable visitFn_Trim(OwlParser.Fn_TrimContext ctx) {
        return super.visitFn_Trim(ctx);
    }

    @Override
    public OwlVariable visitFn_Contains(OwlParser.Fn_ContainsContext ctx) {
        return super.visitFn_Contains(ctx);
    }

    @Override
    public OwlVariable visitFn_Len(OwlParser.Fn_LenContext ctx) {
        return super.visitFn_Len(ctx);
    }

    @Override
    public OwlVariable visitFn_Intersection(OwlParser.Fn_IntersectionContext ctx) {
        return super.visitFn_Intersection(ctx);
    }

    @Override
    public OwlVariable visitFn_NotContains(OwlParser.Fn_NotContainsContext ctx) {
        return super.visitFn_NotContains(ctx);
    }

    @Override
    public OwlVariable visitFn_Rand(OwlParser.Fn_RandContext ctx) {
        OwlDoubleVariable variable = new OwlDoubleVariable();
        variable.setValue(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble()));
        return variable;
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
            result.setValue(sum.divide(size, this.divideScale, RoundingMode.HALF_UP));
            return result;
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Min(OwlParser.Fn_MinContext ctx) {
        OwlDoubleVariable minimum = new OwlDoubleVariable(new BigDecimal(Double.MAX_VALUE));
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
                }
            }
        }
        return minimum;
    }

    @Override
    public OwlVariable visitFn_Sum(OwlParser.Fn_SumContext ctx) {
        return super.visitFn_Sum(ctx);
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
                    floorNumber.setValue(value.round(new MathContext(this.roundingScale, RoundingMode.FLOOR)));
                    return floorNumber;
                }
            }
        }
        return null;
    }

    @Override
    public OwlVariable visitFn_Sort(OwlParser.Fn_SortContext ctx) {
        return super.visitFn_Sort(ctx);
    }

    public OwlContext getOwlContext() {
        return owlContext;
    }

    public void setOwlContext(OwlContext owlContext) {
        this.owlContext = owlContext;
    }

    public int getDivideScale() {
        return divideScale;
    }

    public void setDivideScale(int divideScale) {
        this.divideScale = divideScale;
    }

    public int getRoundingScale() {
        return roundingScale;
    }

    public void setRoundingScale(int roundingScale) {
        this.roundingScale = roundingScale;
    }
}
