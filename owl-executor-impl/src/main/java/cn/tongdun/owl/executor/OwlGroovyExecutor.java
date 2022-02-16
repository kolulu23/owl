package cn.tongdun.owl.executor;

import cn.tongdun.owl.context.OwlGroovyContext;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.runtime.IOGroovyMethods;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

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
        Map<String, Object> outputParamMap = null;
        String invokeMethodName = groovyContext.getInvokeMethodName();
        Map<String, Object> inputParamMap = groovyContext.getInputParamMap();
        GroovyObject groovyObject = (GroovyObject) this.compile(inputStream, charset);
        System.out.println("开始执行groovy脚本，调用的方法为：【" + invokeMethodName + "】");
        System.out.println("输入参数为：" + inputParamMap);
        try {
            outputParamMap = (Map<String, Object>) groovyObject.invokeMethod(invokeMethodName, inputParamMap);
        } catch (Exception e) {
            System.err.println("groovy脚本运行时出现异常：" + e);
            e.printStackTrace();
        }
        System.out.println("执行完成，结果为：" + outputParamMap);

        return outputParamMap;
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
