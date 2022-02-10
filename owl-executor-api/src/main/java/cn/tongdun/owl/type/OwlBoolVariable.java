package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:55 PM
 */
public class OwlBoolVariable extends OwlUnknownVariable {
    private static final long serialVersionUID = 2231998931012550231L;
    private Boolean value;

    public OwlBoolVariable(String id, OwlType type) {
        super(id);
        this.id = id;
        this.type = type;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OwlBoolVariable{" +
                "value=" + value +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
