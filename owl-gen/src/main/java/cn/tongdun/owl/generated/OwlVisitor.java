package cn.tongdun.owl.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OwlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface OwlVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link OwlParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProg(OwlParser.ProgContext ctx);

    /**
     * Visit a parse tree produced by {@link OwlParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlock(OwlParser.BlockContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_Expr}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_Expr(OwlParser.Stat_ExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_Def}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_Def(OwlParser.Stat_DefContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_Assign}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_Assign(OwlParser.Stat_AssignContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_If}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_If(OwlParser.Stat_IfContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_If_Else}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_If_Else(OwlParser.Stat_If_ElseContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_Return}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_Return(OwlParser.Stat_ReturnContext ctx);

    /**
     * Visit a parse tree produced by the {@code Stat_Blank}
     * labeled alternative in {@link OwlParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat_Blank(OwlParser.Stat_BlankContext ctx);

    /**
     * Visit a parse tree produced by the {@code Def_Int}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDef_Int(OwlParser.Def_IntContext ctx);

    /**
     * Visit a parse tree produced by the {@code Def_Double}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDef_Double(OwlParser.Def_DoubleContext ctx);

    /**
     * Visit a parse tree produced by the {@code Def_Boolean}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDef_Boolean(OwlParser.Def_BooleanContext ctx);

    /**
     * Visit a parse tree produced by the {@code Def_String}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDef_String(OwlParser.Def_StringContext ctx);

    /**
     * Visit a parse tree produced by the {@code Def_List}
     * labeled alternative in {@link OwlParser#vardef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDef_List(OwlParser.Def_ListContext ctx);

    /**
     * Visit a parse tree produced by the {@code VarRef}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarRef(OwlParser.VarRefContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Max}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Max(OwlParser.Fn_MaxContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Nvl}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Nvl(OwlParser.Fn_NvlContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Append}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Append(OwlParser.Fn_AppendContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Std}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Std(OwlParser.Fn_StdContext ctx);

    /**
     * Visit a parse tree produced by the {@code BoolExpr}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExpr(OwlParser.BoolExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Round}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Round(OwlParser.Fn_RoundContext ctx);

    /**
     * Visit a parse tree produced by the {@code MulDiv}
     * labeled alternative in {@link OwlParser#expr()()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMulDiv(OwlParser.MulDivContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_ToNumber}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_ToNumber(OwlParser.Fn_ToNumberContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Eq}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Eq(OwlParser.Fn_EqContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Variance}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Variance(OwlParser.Fn_VarianceContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Abs}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Abs(OwlParser.Fn_AbsContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_IsNull}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_IsNull(OwlParser.Fn_IsNullContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Ceil}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Ceil(OwlParser.Fn_CeilContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Substr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Substr(OwlParser.Fn_SubstrContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_IsNotNull}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_IsNotNull(OwlParser.Fn_IsNotNullContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Union}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Union(OwlParser.Fn_UnionContext ctx);

    /**
     * Visit a parse tree produced by the {@code AddSub}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddSub(OwlParser.AddSubContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Concat}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Concat(OwlParser.Fn_ConcatContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_NEq}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_NEq(OwlParser.Fn_NEqContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Dedup}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Dedup(OwlParser.Fn_DedupContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_ToString}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_ToString(OwlParser.Fn_ToStringContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Trim}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Trim(OwlParser.Fn_TrimContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Contains}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Contains(OwlParser.Fn_ContainsContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Len}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Len(OwlParser.Fn_LenContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Intersection}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Intersection(OwlParser.Fn_IntersectionContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_NotContains}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_NotContains(OwlParser.Fn_NotContainsContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Rand}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Rand(OwlParser.Fn_RandContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Avg}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Avg(OwlParser.Fn_AvgContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Min}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Min(OwlParser.Fn_MinContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Sum}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Sum(OwlParser.Fn_SumContext ctx);

    /**
     * Visit a parse tree produced by the {@code CompareNum}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCompareNum(OwlParser.CompareNumContext ctx);

    /**
     * Visit a parse tree produced by the {@code ParenExpr}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenExpr(OwlParser.ParenExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Floor}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Floor(OwlParser.Fn_FloorContext ctx);

    /**
     * Visit a parse tree produced by the {@code Fn_Sort}
     * labeled alternative in {@link OwlParser#expr()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFn_Sort(OwlParser.Fn_SortContext ctx);

    /**
     * Visit a parse tree produced by the {@code Var_Identifier}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVar_Identifier(OwlParser.Var_IdentifierContext ctx);

    /**
     * Visit a parse tree produced by the {@code Var_GlobalVar}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVar_GlobalVar(OwlParser.Var_GlobalVarContext ctx);

    /**
     * Visit a parse tree produced by the {@code Var_Literal}
     * labeled alternative in {@link OwlParser#var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVar_Literal(OwlParser.Var_LiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link OwlParser#arr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArr(OwlParser.ArrContext ctx);

    /**
     * Visit a parse tree produced by {@link OwlParser#literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLiteral(OwlParser.LiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link OwlParser#glbvar}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGlbvar(OwlParser.GlbvarContext ctx);
}