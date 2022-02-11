package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:55 PM
 */
public class OwlBoolVariable extends OwlUnknownVariable<Boolean> {
    private static final long serialVersionUID = 2231998931012550231L;

    public OwlBoolVariable() {
        super();
        this.type = OwlType.BOOLEAN;
    }

    public OwlBoolVariable(Boolean value) {
        this.type = OwlType.BOOLEAN;
        this.value = value;
    }

    public OwlBoolVariable(String id) {
        super(id);
        this.type = OwlType.BOOLEAN;
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
