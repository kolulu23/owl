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

    public static final String ARITHMETIC = "string str = \"hello world of warcraft\";\n" +
            "int a = 1 + 1;\n" +
            "double b = 2 * 6.7;\n" +
            "double c = b - a;\n" +
            "double d = a / (a + 1);\n" +
            "list arr = [a,b,c,d];\n";
    public static final String ARITHMETIC_3_DIV_ZERO = "return 3.01 / 0;";
    public static final String ARITHMETIC_4_COMPARE = "string m=\"mysql\";" +
            "list a = [m]; " +
            "list b = [\"oracle\"];" +
            "return a != b;";
    public static final String ARITHMETIC_5_LOGIC= "return true or false;";
    public static final String FUN_1 = ARITHMETIC +
            "return #trim(#concat(\" My\", \"SQL  \", \" \"));";
}
