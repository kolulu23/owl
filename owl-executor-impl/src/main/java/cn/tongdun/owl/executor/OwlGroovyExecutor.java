package cn.tongdun.owl.executor;

import cn.tongdun.owl.context.OwlGroovyContext;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.runtime.IOGroovyMethods;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * groovy脚本执行器
 *
 * @author ao.li
 * @date 2022/2/16 3:44 下午
 */
public class OwlGroovyExecutor implements OwlExecutor {

    private OwlGroovyContext groovyContext;

    public OwlGroovyExecutor(OwlGroovyContext groovyContext) {
        this.groovyContext = groovyContext;
    }

    @Override
    public Object execute(InputStream inputStream, Charset charset) {
        Object outputParam = null;
        String invokedMethodName = groovyContext.getInvokedMethodName();
        Object inputParam = groovyContext.getInputParam();
        GroovyObject groovyObject = (GroovyObject) this.compile(inputStream, charset);
        System.out.println("开始执行groovy脚本，调用的方法为：【" + invokedMethodName + "】");
        System.out.println("输入参数为：" + inputParam);
        try {
            outputParam = groovyObject.invokeMethod(invokedMethodName, inputParam);
        } catch (Exception e) {
            System.err.println("groovy脚本运行时出现异常：" + e);
            e.printStackTrace();
        }
        System.out.println("执行完成，结果为：" + outputParam);
        groovyContext.reset();

        return outputParam;
    }

    @Override
    public Object compile(InputStream inputStream, Charset charset) {
        GroovyObject groovyObject = null;
        try (GroovyClassLoader groovyClassLoader = new GroovyClassLoader();) {
            String groovyText = IOGroovyMethods.getText(new InputStreamReader(inputStream, charset));
            Class groovyClass = groovyClassLoader.parseClass(groovyText);
            groovyObject = (GroovyObject) groovyClass.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("groovy脚本编译时出现异常：" + e);
            e.printStackTrace();
        }

        return groovyObject;
    }
}
