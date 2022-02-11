package cn.tongdun.owl.type;

import java.util.List;

/**
 * Variable for storing 1-d array.
 * Item must be a {@link OwlVariable} subclass except {@link OwlListVariable} itself.
 * But we don't limit ourselves here since there's no parser rule for nested list.
 *
 * @author liutianlu
 * <br/>Created 2022/2/10 5:56 PM
 */
public class OwlListVariable extends OwlUnknownVariable<List<? extends OwlVariable>> {
    private static final long serialVersionUID = 938435808718940169L;

    public OwlListVariable() {
        this.type = OwlType.LIST;
    }

    public OwlListVariable(String id) {
        super(id);
        this.type = OwlType.LIST;
    }

    @Override
    public String toString() {
        return "OwlListVariable{" +
                "valueList=" + value +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
