package cn.tongdun.owl.type;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:54 PM
 */
public class OwlStringVariable extends OwlUnknownVariable<String> {
    private static final long serialVersionUID = 7495261780014021403L;

    public OwlStringVariable() {
        super();
        this.type = OwlType.STRING;
    }

    public OwlStringVariable(String value) {
        super();
        this.type = OwlType.STRING;
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
