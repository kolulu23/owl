package cn.tongdun.owl.error;

/**
 * Error occurred during executing a DSL unit.
 *
 * @author liutianlu
 * <br/>Created 2022/2/17 12:51 PM
 */
public class OwlExecutionError extends OwlError {
    private static final long serialVersionUID = 7394443442594573263L;

    /**
     * Name of execution unit
     */
    private String name;

    @Override
    public String toString() {
        return "OwlExecutionError{" +
                "message='" + message + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
