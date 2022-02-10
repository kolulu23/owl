package cn.tongdun.owl.type;

import java.util.List;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 5:56 PM
 */
public class OwlListVariable extends OwlUnknownVariable {
    private static final long serialVersionUID = 938435808718940169L;

    /**
     * Item must be a {@link OwlVariable} subclass except {@link OwlListVariable} itself.
     * But we don't limit ourselves here since there's no parser rule for nested list.
     */
    private List<? extends OwlVariable> valueList;

    public OwlListVariable(String id, OwlType type) {
        super(id);
        this.id = id;
        this.type = type;
    }

    public List<? extends OwlVariable> getValueList() {
        return valueList;
    }

    public void setValueList(List<? extends OwlVariable> valueList) {
        this.valueList = valueList;
    }

    @Override
    public String toString() {
        return "OwlListVariable{" +
                "valueList=" + valueList +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
