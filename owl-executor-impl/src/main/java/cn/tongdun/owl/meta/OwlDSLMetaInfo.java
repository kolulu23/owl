package cn.tongdun.owl.meta;

import cn.tongdun.owl.type.OwlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Some hardcoded info for Owl DSL.
 * TODO Hardcoded ?
 * @author liutianlu
 * <br/>Created 2022/2/22 2:18 PM
 */
public class OwlDSLMetaInfo {

    public static List<FuncInfo> getFunctionList() {
        List<FuncInfo> funcInfoList = new ArrayList<>();
        funcInfoList.add(absInfo());
        funcInfoList.add(avgInfo());
        funcInfoList.add(appendInfo());
        funcInfoList.add(ceilInfo());
        funcInfoList.add(concatInfo());
        funcInfoList.add(containsInfo());
        funcInfoList.add(dedupInfo());
        funcInfoList.add(eqInfo());
        funcInfoList.add(floorInfo());
        funcInfoList.add(intersectInfo());
        funcInfoList.add(isNullInfo());
        funcInfoList.add(isNotNullInfo());
        funcInfoList.add(lenInfo());
        funcInfoList.add(maxInfo());
        funcInfoList.add(minInfo());
        funcInfoList.add(neqInfo());
        funcInfoList.add(notContainsInfo());
        funcInfoList.add(nvlInfo());
        funcInfoList.add(randInfo());
        funcInfoList.add(roundInfo());
        funcInfoList.add(sortInfo());
        funcInfoList.add(stdInfo());
        funcInfoList.add(sumInfo());
        funcInfoList.add(substringInfo());
        funcInfoList.add(toNumberInfo());
        funcInfoList.add(toStringInfo());
        funcInfoList.add(trimInfo());
        funcInfoList.add(unionInfo());
        funcInfoList.add(varianceInfo());
        return funcInfoList;
    }

    public static FuncInfo absInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo maxInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo minInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo ceilInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo floorInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo roundInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo avgInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo randInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo sumInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo stdInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo varianceInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo trimInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo concatInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo lenInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo unionInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo intersectInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo appendInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo dedupInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo sortInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo substringInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo containsInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo notContainsInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo eqInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo neqInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo nvlInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo isNullInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo isNotNullInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo toStringInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static FuncInfo toNumberInfo(){
        FuncInfo f = new FuncInfo();
        return f;
    }

    public static DSLInfo getDSLInfo() {
        DSLInfo dslInfo = new DSLInfo();
        dslInfo.setName("Owl");
        dslInfo.addKeyWord(OwlDSLKeywords.IF);
        dslInfo.addKeyWord(OwlDSLKeywords.ELSE);
        dslInfo.addKeyWord(OwlDSLKeywords.RETURN);
        dslInfo.addTypeName(OwlType.INT.getKey());
        dslInfo.addTypeName(OwlType.DOUBLE.getKey());
        dslInfo.addTypeName(OwlType.BOOLEAN.getKey());
        dslInfo.addTypeName(OwlType.STRING.getKey());
        dslInfo.addTypeName(OwlType.LIST.getKey());
        return dslInfo;
    }
}
