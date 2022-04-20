package cn.tongdun.owl.benchmark;

import cn.tongdun.owl.context.OwlDSLContext;
import cn.tongdun.owl.executor.OwlDSLExecutionResult;
import cn.tongdun.owl.executor.OwlDSLExecutor;
import cn.tongdun.owl.type.OwlIntVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.RandomUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author kolulu
 * <br/>Created at 2022/4/19 23:26
 */
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@State(value = Scope.Benchmark)
public class OwlExecutorBenchmark {

    public static final String SIMPLE = "double x = 0.09; double y = 1.02; return x - y;";

    public static final String FUNC_WITH_GLOBAL_VAR = "int activeDays = #nvl(@zvq9ofignk,0) + #nvl(@eqcdc1s2ej, 0);" +
            "if (activeDays == 0) {return 0;}" +
            "int totalCount = #nvl(@d63sgztcj9, 0) + #nvl(@yh5vih98ah,0);" +
            "return totalCount / activeDays;";

    protected static final List<ParseTree> parseTreeList = new ArrayList<>();

    @Benchmark
    public void testSimpleDSL(Blackhole blackhole) {
        OwlDSLExecutor executorSimple = new OwlDSLExecutor();
        OwlDSLExecutionResult result = executorSimple.executeFromParseTree(parseTreeList.get(0), new OwlDSLContext(), "_");
        blackhole.consume(result);
    }

    @Benchmark
    public void testFunctionDSL(Blackhole blackhole) {
        OwlDSLExecutor executorSimple = new OwlDSLExecutor();
        OwlDSLContext context = new OwlDSLContext();
        context.addVariable(new OwlIntVariable("@zvq9ofignk", RandomUtils.nextLong()), true);
        context.addVariable(new OwlIntVariable("@eqcdc1s2ej", RandomUtils.nextLong()), true);
        context.addVariable(new OwlIntVariable("@d63sgztcj9", RandomUtils.nextLong()), true);
        context.addVariable(new OwlIntVariable("@yh5vih98ah", RandomUtils.nextLong()), true);
        OwlDSLExecutionResult result = executorSimple.executeFromParseTree(parseTreeList.get(1), context, "_");
        blackhole.consume(result);
    }

    @Setup(Level.Trial)
    public void initParseTree() {
        OwlDSLExecutor executor = new OwlDSLExecutor();
        parseTreeList.add((ParseTree) executor.compileFromString("simple", SIMPLE));
        parseTreeList.add((ParseTree) executor.compileFromString("func", FUNC_WITH_GLOBAL_VAR));
    }
}
