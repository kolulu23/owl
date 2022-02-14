package cn.tongdun.owl.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Base class for other typed variables.
 * Unknown variables are normally undefined global variables.
 *
 * @author liutianlu
 * <br/>Created 2022/2/10 6:27 PM
 */
public class OwlUnknownVariable<T> extends OwlVariable implements Serializable {

    private static final long serialVersionUID = 261171854254277961L;

    protected T value;

    public OwlUnknownVariable() {
        // Literal variable that has not been assigned to anything
        this.id = "<literal>";
    }

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
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setType(OwlType type) {
        this.type = type;
    }

    /**
     * If you already know the type of inner value, you can call this function to get you
     * the value. Use this function only if you are calling through subclasses.
     *
     * @return typed value
     */
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /**
     * This function tries to get an integer from this variable.
     * If this variable is not a {@link OwlIntVariable} or value is null, then null will be returned.
     *
     * @return integer value, could be null
     */
    public Integer getIntValue() {
        if (OwlType.INT.equals(this.getType())) {
            return value == null ? null : (Integer) value;
        }
        return null;
    }

    public BigDecimal getDoubleValue() {
        if (OwlType.DOUBLE.equals(this.getType())) {
            return value == null ? null : (BigDecimal) value;
        }
        return null;
    }

    public String getStringValue() {
        if (OwlType.STRING.equals(this.getType())) {
            return value == null ? null : (String) value;
        }
        return null;
    }

    public Boolean getBoolValue() {
        if (OwlType.BOOLEAN.equals(this.getType())) {
            return value == null ? null : (Boolean) value;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<OwlVariable> getListValue() {
        if (OwlType.LIST.equals(this.getType())) {
            return value == null ? null : (List<OwlVariable>) value;
        }
        return null;
    }

    @Override
    public String toString() {
        return "OwlUnknownVariable{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OwlUnknownVariable)) {
            return false;
        }
        OwlUnknownVariable<?> that = (OwlUnknownVariable<?>) o;
        if (this.value == null && that.value == null) {
            return true;
        } else if (this.value != null && that.value != null) {
            return value.equals(that.value);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value == null ? -1 : value.hashCode();
    }
}
