package cn.tongdun.owl.meta;

import cn.tongdun.owl.type.OwlType;

import java.io.Serializable;
import java.util.List;

/**
 * @author liutianlu
 * <br/>Created 2022/2/22 2:06 PM
 */
public class FuncInfo implements Serializable {
    private static final long serialVersionUID = 7091415729638345733L;
    /**
     * Function name
     */
    private String funcName;

    /**
     * Argument type list
     */
    private List<String> argTypeList;

    /**
     * Whether this function use a fixed number of arguments.
     * This is equivalent to something like {@code void foo(Object... args)} in java when it is false.
     */
    private boolean fixedArgs = true;

    /**
     * Return type
     */
    private String returnType;

    /**
     * Excerpt from documentation of this function
     */
    private String tips;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public List<String> getArgTypeList() {
        return argTypeList;
    }

    public void setArgTypeList(List<String> argTypeList) {
        this.argTypeList = argTypeList;
    }

    public boolean isFixedArgs() {
        return fixedArgs;
    }

    public void setFixedArgs(boolean fixedArgs) {
        this.fixedArgs = fixedArgs;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
