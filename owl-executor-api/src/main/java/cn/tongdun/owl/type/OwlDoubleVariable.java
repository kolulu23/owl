package cn.tongdun.owl.type;

import java.math.BigDecimal;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:54 PM
 */
public class OwlDoubleVariable extends OwlUnknownVariable {
    private static final long serialVersionUID = 9110309677935297177L;

    private BigDecimal value;

    public OwlDoubleVariable(String id, OwlType type) {
        super(id);
        this.id = id;
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
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
