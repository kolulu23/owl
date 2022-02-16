package cn.tongdun.owl.example

/**
 * @author ao.li
 * @date 2022/2/16 2:18 下午
 */
class CorrectGroovyDemo {
    public Map<String, String> run(Map<String, String> inputMap) {
        Map<String, String> outputMap = new HashMap<String, String>();
        // TODO 请在此处补充需要实现的业务逻辑，结果值put入outputMap中。
        def param1 = inputMap.get("param1")
        if (param1 == "A001") {
            outputMap.put("res", "2021");
        } else {
            outputMap.put("res", "2022");
        }
        return outputMap;
    }
}
