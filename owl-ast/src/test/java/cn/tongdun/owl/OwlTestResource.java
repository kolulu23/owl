package cn.tongdun.owl;

/**
 * @author liutianlu
 * <br/>Created 2022/2/11 10:02 AM
 */
public class OwlTestResource {
    public static final String INIT = "int a = 0;\n" +
            "double b = 2.0;\n" +
            "boolean c = false;\n" +
            "string d = \"kek\";\n" +
            "list e = [a, b, d, true, false];\n" +
            "int m = @metric_1 + 3;\n" +
            "return m;";

    public static final String INIT_ERROR = ";ino a = 0";

    public static final String PATH_TO_IFELSE = "/Users/liutianlu/Projects/JavaProjects/owl/owl-ast/src/test/java/cn/tongdun/owl/example/ifelse.txt";

    public static final String ARITHMETIC = "string str = \"hello world of warcraft\";" +
            "int maxIndex = #len(str) - 1;" +
            "return maxIndex";
    public static final String ARITHMETIC_2 = "int a = 1 + 1;" +
            "double b = 2 * 6.7;" +
            "double c = b - a;" +
            "double d = a / a + 1;" +
            "list arr = [a,b,c,d];" +
            "return arr";
}
