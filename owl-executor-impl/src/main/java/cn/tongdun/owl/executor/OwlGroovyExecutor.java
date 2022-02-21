package cn.tongdun.owl.executor;

import cn.tongdun.owl.context.OwlGroovyContext;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.runtime.IOGroovyMethods;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

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
    public OwlExecutionResult execute(OwlExecutionUnit executionUnit, Charset charset) {
        OwlGroovyExecutionResult groovyExecutionResult = new OwlGroovyExecutionResult();
        groovyExecutionResult.setSuccess(false);
        Object outputParam = null;
        String invokedMethodName = groovyContext.getInvokedMethodName();
        Object inputParam = groovyContext.getInputParam();
        GroovyObject groovyObject = (GroovyObject) this.compile(executionUnit, charset);
        System.out.println("开始执行groovy脚本，调用的方法为：【" + invokedMethodName + "】");
        System.out.println("输入参数为：" + inputParam);
        try {
            outputParam = groovyObject.invokeMethod(invokedMethodName, inputParam);
        } catch (Exception e) {
            System.err.println("groovy脚本运行时出现异常：" + e);
            groovyContext.addSemanticErrorFromException(e);
            e.printStackTrace();
        }
        System.out.println("执行完成，结果为：" + outputParam);

        if (groovyContext.listAllSemanticErrors().isEmpty()) {
            groovyExecutionResult.setSuccess(true);
            groovyExecutionResult.setResult(outputParam);
        } else {
            groovyExecutionResult.setErrorList(new ArrayList<>(groovyContext.listAllSemanticErrors()));
        }
        groovyContext.reset();

        return groovyExecutionResult;
    }

    @Override
    public Object compile(OwlExecutionUnit executionUnit, Charset charset) {
        InputStream inputStream = executionUnit.getSource();
        Object groovyInstance = null;
        try (GroovyClassLoader groovyClassLoader = new GroovyClassLoader()) {
            String groovyText = IOGroovyMethods.getText(new InputStreamReader(inputStream, charset));
            Class groovyClass = groovyClassLoader.parseClass(groovyText);
            groovyInstance = groovyClass.newInstance();
        } catch (IOException e) {
            System.err.println("输入流操作异常：" + e);
            groovyContext.addSemanticErrorFromException(e);
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("无法为该class创建实例：" + e);
            groovyContext.addSemanticErrorFromException(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("groovy脚本编译时出现异常：" + e);
            groovyContext.addSemanticErrorFromException(e);
            e.printStackTrace();
        }

        return groovyInstance;
    }
}
