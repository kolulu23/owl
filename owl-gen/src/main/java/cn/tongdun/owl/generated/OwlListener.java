package cn.tongdun.owl.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OwlParser}.
 */
public interface OwlListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link OwlParser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(OwlParser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link OwlParser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(OwlParser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link OwlParser#block}.
     *
     * @param ctx the parse tree
     */
    void enterBlock(OwlParser.BlockContext ctx);

    /**
     * Exit a parse tree produced by {@link OwlParser#block}.
     *
     * @param ctx the parse tree
     */
    void exitBlock(OwlParser.BlockContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_Expr}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_Expr(OwlParser.Stat_ExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_Expr}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_Expr(OwlParser.Stat_ExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_Def}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_Def(OwlParser.Stat_DefContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_Def}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_Def(OwlParser.Stat_DefContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_Assign}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_Assign(OwlParser.Stat_AssignContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_Assign}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_Assign(OwlParser.Stat_AssignContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_If}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_If(OwlParser.Stat_IfContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_If}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_If(OwlParser.Stat_IfContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_If_Else}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_If_Else(OwlParser.Stat_If_ElseContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_If_Else}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_If_Else(OwlParser.Stat_If_ElseContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_Return}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_Return(OwlParser.Stat_ReturnContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_Return}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_Return(OwlParser.Stat_ReturnContext ctx);

    /**
     * Enter a parse tree produced by the {@code Stat_Blank}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStat_Blank(OwlParser.Stat_BlankContext ctx);

    /**
     * Exit a parse tree produced by the {@code Stat_Blank}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStat_Blank(OwlParser.Stat_BlankContext ctx);

    /**
     * Enter a parse tree produced by the {@code Def_Int}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void enterDef_Int(OwlParser.Def_IntContext ctx);

    /**
     * Exit a parse tree produced by the {@code Def_Int}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void exitDef_Int(OwlParser.Def_IntContext ctx);

    /**
     * Enter a parse tree produced by the {@code Def_Double}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void enterDef_Double(OwlParser.Def_DoubleContext ctx);

    /**
     * Exit a parse tree produced by the {@code Def_Double}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void exitDef_Double(OwlParser.Def_DoubleContext ctx);

    /**
     * Enter a parse tree produced by the {@code Def_Boolean}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void enterDef_Boolean(OwlParser.Def_BooleanContext ctx);

    /**
     * Exit a parse tree produced by the {@code Def_Boolean}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void exitDef_Boolean(OwlParser.Def_BooleanContext ctx);

    /**
     * Enter a parse tree produced by the {@code Def_String}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void enterDef_String(OwlParser.Def_StringContext ctx);

    /**
     * Exit a parse tree produced by the {@code Def_String}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void exitDef_String(OwlParser.Def_StringContext ctx);

    /**
     * Enter a parse tree produced by the {@code Def_List}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void enterDef_List(OwlParser.Def_ListContext ctx);

    /**
     * Exit a parse tree produced by the {@code Def_List}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     */
    void exitDef_List(OwlParser.Def_ListContext ctx);

    /**
     * Enter a parse tree produced by the {@code VarRef}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterVarRef(OwlParser.VarRefContext ctx);

    /**
     * Exit a parse tree produced by the {@code VarRef}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitVarRef(OwlParser.VarRefContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Max}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Max(OwlParser.Fn_MaxContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Max}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Max(OwlParser.Fn_MaxContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Nvl}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Nvl(OwlParser.Fn_NvlContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Nvl}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Nvl(OwlParser.Fn_NvlContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Append}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Append(OwlParser.Fn_AppendContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Append}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Append(OwlParser.Fn_AppendContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Std}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Std(OwlParser.Fn_StdContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Std}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Std(OwlParser.Fn_StdContext ctx);

    /**
     * Enter a parse tree produced by the {@code BoolExpr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterBoolExpr(OwlParser.BoolExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code BoolExpr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitBoolExpr(OwlParser.BoolExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Round}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Round(OwlParser.Fn_RoundContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Round}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Round(OwlParser.Fn_RoundContext ctx);

    /**
     * Enter a parse tree produced by the {@code MulDiv}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterMulDiv(OwlParser.MulDivContext ctx);

    /**
     * Exit a parse tree produced by the {@code MulDiv}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitMulDiv(OwlParser.MulDivContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_ToNumber}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_ToNumber(OwlParser.Fn_ToNumberContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_ToNumber}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_ToNumber(OwlParser.Fn_ToNumberContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Eq}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Eq(OwlParser.Fn_EqContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Eq}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Eq(OwlParser.Fn_EqContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Variance}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Variance(OwlParser.Fn_VarianceContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Variance}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Variance(OwlParser.Fn_VarianceContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Abs}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Abs(OwlParser.Fn_AbsContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Abs}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Abs(OwlParser.Fn_AbsContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_IsNull}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_IsNull(OwlParser.Fn_IsNullContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_IsNull}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_IsNull(OwlParser.Fn_IsNullContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Ceil}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Ceil(OwlParser.Fn_CeilContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Ceil}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Ceil(OwlParser.Fn_CeilContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Substr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Substr(OwlParser.Fn_SubstrContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Substr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Substr(OwlParser.Fn_SubstrContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_IsNotNull}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_IsNotNull(OwlParser.Fn_IsNotNullContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_IsNotNull}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_IsNotNull(OwlParser.Fn_IsNotNullContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Union}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Union(OwlParser.Fn_UnionContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Union}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Union(OwlParser.Fn_UnionContext ctx);

    /**
     * Enter a parse tree produced by the {@code AddSub}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterAddSub(OwlParser.AddSubContext ctx);

    /**
     * Exit a parse tree produced by the {@code AddSub}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitAddSub(OwlParser.AddSubContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Concat}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Concat(OwlParser.Fn_ConcatContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Concat}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Concat(OwlParser.Fn_ConcatContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_NEq}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_NEq(OwlParser.Fn_NEqContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_NEq}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_NEq(OwlParser.Fn_NEqContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Dedup}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Dedup(OwlParser.Fn_DedupContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Dedup}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Dedup(OwlParser.Fn_DedupContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_ToString}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_ToString(OwlParser.Fn_ToStringContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_ToString}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_ToString(OwlParser.Fn_ToStringContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Trim}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Trim(OwlParser.Fn_TrimContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Trim}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Trim(OwlParser.Fn_TrimContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Contains}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Contains(OwlParser.Fn_ContainsContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Contains}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Contains(OwlParser.Fn_ContainsContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Len}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Len(OwlParser.Fn_LenContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Len}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Len(OwlParser.Fn_LenContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Intersection}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Intersection(OwlParser.Fn_IntersectionContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Intersection}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Intersection(OwlParser.Fn_IntersectionContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_NotContains}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_NotContains(OwlParser.Fn_NotContainsContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_NotContains}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_NotContains(OwlParser.Fn_NotContainsContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Rand}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Rand(OwlParser.Fn_RandContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Rand}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Rand(OwlParser.Fn_RandContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Avg}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Avg(OwlParser.Fn_AvgContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Avg}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Avg(OwlParser.Fn_AvgContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Min}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Min(OwlParser.Fn_MinContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Min}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Min(OwlParser.Fn_MinContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Sum}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Sum(OwlParser.Fn_SumContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Sum}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Sum(OwlParser.Fn_SumContext ctx);

    /**
     * Enter a parse tree produced by the {@code CompareNum}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterCompareNum(OwlParser.CompareNumContext ctx);

    /**
     * Exit a parse tree produced by the {@code CompareNum}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitCompareNum(OwlParser.CompareNumContext ctx);

    /**
     * Enter a parse tree produced by the {@code ParenExpr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterParenExpr(OwlParser.ParenExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code ParenExpr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitParenExpr(OwlParser.ParenExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Floor}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Floor(OwlParser.Fn_FloorContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Floor}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Floor(OwlParser.Fn_FloorContext ctx);

    /**
     * Enter a parse tree produced by the {@code Fn_Sort}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void enterFn_Sort(OwlParser.Fn_SortContext ctx);

    /**
     * Exit a parse tree produced by the {@code Fn_Sort}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     */
    void exitFn_Sort(OwlParser.Fn_SortContext ctx);

    /**
     * Enter a parse tree produced by the {@code Var_Identifier}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     */
    void enterVar_Identifier(OwlParser.Var_IdentifierContext ctx);

    /**
     * Exit a parse tree produced by the {@code Var_Identifier}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     */
    void exitVar_Identifier(OwlParser.Var_IdentifierContext ctx);

    /**
     * Enter a parse tree produced by the {@code Var_GlobalVar}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     */
    void enterVar_GlobalVar(OwlParser.Var_GlobalVarContext ctx);

    /**
     * Exit a parse tree produced by the {@code Var_GlobalVar}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     */
    void exitVar_GlobalVar(OwlParser.Var_GlobalVarContext ctx);

    /**
     * Enter a parse tree produced by the {@code Var_Literal}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     */
    void enterVar_Literal(OwlParser.Var_LiteralContext ctx);

    /**
     * Exit a parse tree produced by the {@code Var_Literal}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     */
    void exitVar_Literal(OwlParser.Var_LiteralContext ctx);

    /**
     * Enter a parse tree produced by {@link OwlParser#arr}.
     *
     * @param ctx the parse tree
     */
    void enterArr(OwlParser.ArrContext ctx);

    /**
     * Exit a parse tree produced by {@link OwlParser#arr}.
     *
     * @param ctx the parse tree
     */
    void exitArr(OwlParser.ArrContext ctx);

    /**
     * Enter a parse tree produced by {@link OwlParser#literal}.
     *
     * @param ctx the parse tree
     */
    void enterLiteral(OwlParser.LiteralContext ctx);

    /**
     * Exit a parse tree produced by {@link OwlParser#literal}.
     *
     * @param ctx the parse tree
     */
    void exitLiteral(OwlParser.LiteralContext ctx);

    /**
     * Enter a parse tree produced by {@link OwlParser#glbvar}.
     *
     * @param ctx the parse tree
     */
    void enterGlbvar(OwlParser.GlbvarContext ctx);

    /**
     * Exit a parse tree produced by {@link OwlParser#glbvar}.
     *
     * @param ctx the parse tree
     */
    void exitGlbvar(OwlParser.GlbvarContext ctx);
}