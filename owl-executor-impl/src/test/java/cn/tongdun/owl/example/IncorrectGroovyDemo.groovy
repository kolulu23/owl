package cn.tongdun.owl.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误的groovy脚本演示
 *
 * @author ao.li
 * @date 2022/2/16 8:02 下午
 */
public class IncorrectGroovyDemo {

    public Map<String, String> run(Map<String, String> inputMap) {
        Map<String, String> outputMap = new HashMap<String, String>();
        // TODO 请在此处补充需要实现的业务逻辑，结果值put入outputMap中。
        def param1 = inputMap.get("param1")
        int i = 1 / 0
        if (param1 == "A001") {
            outputMap.put("res", "2021");
        } else {
            outputMap.put("res", "2022");
        }
        return outputMap;
    }
}
