package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:54 PM
 */
public class OwlStringVariable extends OwlUnknownVariable {
    private static final long serialVersionUID = 7495261780014021403L;

    private String value;

    public OwlStringVariable(String id, OwlType type) {
        super(id);
        this.id = id;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OwlStringVariable{" +
                "value='" + value + '\'' +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
