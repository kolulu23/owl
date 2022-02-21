package cn.tongdun.owl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ao.li
 * @date 2022/2/16 1:59 下午
 */
public class GroovyTest {

    @Test
    public void simpleTest() {
        File file = new File("src/test/java/cn/tongdun/owl/example/demo.groovy");
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        try {
            Class demoClass = groovyClassLoader.parseClass(file);
            GroovyObject o = (GroovyObject) demoClass.newInstance();
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("param1", "A001");
            Map<String, String> resMap = (Map<String, String>) o.invokeMethod("run", paramMap);
            System.out.println(resMap);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
