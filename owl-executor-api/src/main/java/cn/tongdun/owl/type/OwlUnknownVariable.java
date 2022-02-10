package cn.tongdun.owl.type;

import java.io.Serializable;

/**
 * Base class for other typed variables.
 * Unknown variables are normally undefined global variables.
 *
 * @author liutianlu
 * <br/>Created 2022/2/10 6:27 PM
 */
public class OwlUnknownVariable extends OwlVariable implements Serializable {

    private static final long serialVersionUID = 261171854254277961L;

    public OwlUnknownVariable(String id) {
        this.id = id;
        this.type = OwlType.UNKNOWN;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public OwlType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "OwlUnknownVariable{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
