package cn.tongdun.owl.executor;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Execution unit of Owl DSL.
 *
 * @author liutianlu
 * <br/>Created 2022/2/17 11:20 AM
 */
public class OwlExecutionUnit implements Serializable {

    private static final long serialVersionUID = -9020036321945325178L;

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
