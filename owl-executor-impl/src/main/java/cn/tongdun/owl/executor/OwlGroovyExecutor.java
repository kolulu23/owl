package cn.tongdun.owl.executor;

import cn.tongdun.owl.context.OwlGroovyContext;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.apache.commons.collections4.CollectionUtils;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.codehaus.groovy.runtime.IOGroovyMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private Logger logger = LoggerFactory.getLogger(OwlGroovyExecutor.class);

    private OwlGroovyContext groovyContext;

    public OwlGroovyExecutor() {
        this.groovyContext = new OwlGroovyContext();
    }

    public OwlGroovyExecutor(OwlGroovyContext groovyContext) {
        this.groovyContext = groovyContext;
    }

    @Override
    public OwlExecutionResult execute(OwlExecutionUnit executionUnit, Charset charset) {
        Object groovyInstance = this.compile(executionUnit, charset);
        // 编译时出现错误
        if (CollectionUtils.isNotEmpty(groovyContext.listAllSemanticErrors())) {
            OwlGroovyExecutionResult groovyExecutionResult = new OwlGroovyExecutionResult();
            groovyExecutionResult.setSuccess(false);
            groovyExecutionResult.setErrorList(new ArrayList<>(groovyContext.listAllSemanticErrors()));

            return groovyExecutionResult;
        }

        return this.executeFromInstance(groovyInstance);
    }

    public OwlExecutionResult executeFromInstance(Object groovyInstance) {
        OwlGroovyExecutionResult groovyExecutionResult = new OwlGroovyExecutionResult();
        groovyExecutionResult.setSuccess(false);
        Object outputParam = null;
        assert groovyContext != null : "groovyContext is null!";
        String invokedMethodName = groovyContext.getInvokedMethodName();
        Object inputParam = groovyContext.getInputParam();
        logger.info("开始执行groovy脚本，调用的方法为：【{}】", invokedMethodName);
        logger.info("输入参数为：{}", inputParam);
        try {
            GroovyObject groovyObject = (GroovyObject) groovyInstance;
            outputParam = groovyObject.invokeMethod(invokedMethodName, inputParam);
        } catch (Exception e) {
            logger.error("groovy脚本运行时出现异常：", e);
            groovyContext.addSemanticErrorFromException(e);
        }
        logger.info("执行完成，结果为：{}", outputParam);

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
            logger.error("输入流操作异常：", e);
            groovyContext.addSemanticErrorFromException(e);
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("无法为该class创建实例：", e);
            groovyContext.addSemanticErrorFromException(e);
        } catch (MultipleCompilationErrorsException e) {
            logger.error("Groovy脚本出现语法错误：", e);
            groovyContext.addSemanticErrorFromCompilationErrors(e);
        } catch (Exception e) {
            logger.error("groovy脚本编译时出现异常：", e);
            groovyContext.addSemanticErrorFromException(e);
        }

        return groovyInstance;
    }

    public void setGroovyContext(OwlGroovyContext groovyContext) {
        this.groovyContext = groovyContext;
    }
}
