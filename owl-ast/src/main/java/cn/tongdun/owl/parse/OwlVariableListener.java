package cn.tongdun.owl.parse;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.error.OwlSemanticError;
import cn.tongdun.owl.generated.OwlBaseListener;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.type.*;

/**
 * This listener is used to find global variable references and local variable declarations.
 * It does not do any expression evaluation, so it can not give you too much semantic info.
 *
 * @author liutianlu
 * <br/>Created 2022/2/10 3:22 PM
 */
public class OwlVariableListener extends OwlBaseListener {

    private OwlContext owlContext;

    @Override
    public void enterDef_Int(OwlParser.Def_IntContext ctx) {
        String id = ctx.ID().getText();
        OwlIntVariable var = new OwlIntVariable(id, OwlType.INT);
        owlContext.addVariable(var, false);
    }

    @Override
    public void enterDef_Double(OwlParser.Def_DoubleContext ctx) {
        String id = ctx.ID().getText();
        OwlDoubleVariable var = new OwlDoubleVariable(id, OwlType.DOUBLE);
        owlContext.addVariable(var, false);
    }

    @Override
    public void enterDef_Boolean(OwlParser.Def_BooleanContext ctx) {
        String id = ctx.ID().getText();
        OwlBoolVariable var = new OwlBoolVariable(id, OwlType.BOOLEAN);
        owlContext.addVariable(var, false);
    }

    @Override
    public void enterDef_String(OwlParser.Def_StringContext ctx) {
        String id = ctx.ID().getText();
        OwlStringVariable var = new OwlStringVariable(id, OwlType.STRING);
        owlContext.addVariable(var, false);
    }

    @Override
    public void enterDef_List(OwlParser.Def_ListContext ctx) {
        String id = ctx.ID().getText();
        OwlListVariable var = new OwlListVariable(id, OwlType.LIST);
        owlContext.addVariable(var, false);
    }

    @Override
    public void enterVar_GlobalVar(OwlParser.Var_GlobalVarContext ctx) {
        String globalId = ctx.getText();
        OwlUnknownVariable var = new OwlUnknownVariable(globalId);
        owlContext.addVariable(var, true);
    }

    // TODO move to visitor
    @Override
    public void enterStat_Assign(OwlParser.Stat_AssignContext ctx) {
        String id = ctx.ID().getText();
        if (!owlContext.isVariableDeclared(id)) {
            OwlSemanticError semanticError = new OwlSemanticError();
            semanticError.setMessage("Variable " + id + " not declared");
            semanticError.setLine(ctx.getStart().getLine());
            semanticError.setCodeSegment(ctx.getRuleContext().getText());
            owlContext.addSemanticError(semanticError);
        }
    }

    public OwlContext getOwlContext() {
        return owlContext;
    }

    public void setOwlContext(OwlContext owlContext) {
        this.owlContext = owlContext;
    }
}
