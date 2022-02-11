package cn.tongdun.owl.parse;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.generated.OwlBaseVisitor;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.type.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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
     * Scale for divide operation
     */
    private int divideScale;

    public OwlEvalVisitor() {
        this.divideScale = 4;
    }

    public OwlEvalVisitor(OwlContext owlContext) {
        this.owlContext = owlContext;
        this.divideScale = 4;
    }

    public OwlEvalVisitor(OwlContext owlContext, int divideScale) {
        this.owlContext = owlContext;
        this.divideScale = divideScale;
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
        return new OwlStringVariable(str);
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
            BigDecimal leftValue = leftVar.getInner().getDoubleValue();
            BigDecimal rightValue = rightVar.getInner().getDoubleValue();
            if (leftValue == null || rightValue == null) {
                return null;
            }
            if (ctx.op.getType() == OwlParser.ADD) {
                result.setValue(leftValue.add(rightValue));
            } else {
                result.setValue(leftValue.subtract(rightValue));
            }
            return result;
        }
    }

    @Override
    public OwlVariable visitCompareNum(OwlParser.CompareNumContext ctx) {
        return super.visitCompareNum(ctx);
    }

    @Override
    public OwlVariable visitBoolExpr(OwlParser.BoolExprContext ctx) {
        return super.visitBoolExpr(ctx);
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
}
