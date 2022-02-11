package cn.tongdun.owl.type;

import java.math.BigDecimal;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:54 PM
 */
public class OwlDoubleVariable extends OwlUnknownVariable<BigDecimal> {
    private static final long serialVersionUID = 9110309677935297177L;

    public OwlDoubleVariable() {
        super();
        this.type = OwlType.DOUBLE;
    }

    public OwlDoubleVariable(String id) {
        super(id);
        this.type = OwlType.DOUBLE;
    }

    public OwlDoubleVariable(BigDecimal value) {
        this.type = OwlType.DOUBLE;
        this.value = value;
    }

    @Override
    public String toString() {
        return "OwlDoubleVariable{" +
                "value=" + value +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
