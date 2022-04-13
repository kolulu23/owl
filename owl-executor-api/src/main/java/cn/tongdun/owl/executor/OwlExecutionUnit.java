package cn.tongdun.owl.executor;

import java.io.InputStream;

/**
 * Execution unit of Owl DSL.
 *
 * @author liutianlu
 * <br/>Created 2022/2/17 11:20 AM
 */
public class OwlExecutionUnit {

    /**
     * The name of this execution unit.
     * Name should be unique if sources are coming from different system.
     */
    private String name;

    /**
     * Source code of Owl DSL.
     */
    private InputStream source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getSource() {
        return source;
    }

    public void setSource(InputStream source) {
        this.source = source;
    }
}
