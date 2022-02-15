package cn.tongdun.owl.type;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 4:04 PM
 */
public class OwlDescendingComparator implements Comparator<OwlVariable> {
    @Override
    public int compare(OwlVariable a, OwlVariable b) {
        boolean aNotNull = a != null && a.getInner().getValue() != null;
        boolean bNotNull = b != null && b.getInner().getValue() != null;
        if (aNotNull && bNotNull) {
            boolean aIsInt = OwlType.INT.equals(a.getType());
            boolean aIsDouble = OwlType.DOUBLE.equals(a.getType());
            boolean bIsInt = OwlType.INT.equals(b.getType());
            boolean bIsDouble = OwlType.DOUBLE.equals(b.getType());
            if (aIsInt && bIsInt) {
                return b.getInner().getIntValue().compareTo(a.getInner().getIntValue());
            } else if (aIsDouble && bIsDouble) {
                return b.getInner().getDoubleValue().compareTo(a.getInner().getDoubleValue());
            } else if (aIsInt && bIsDouble) {
                return b.getInner().getDoubleValue().compareTo(new BigDecimal(a.getInner().getIntValue()));
            } else if (aIsDouble && bIsInt) {
                return new BigDecimal(b.getInner().getIntValue()).compareTo(a.getInner().getDoubleValue());
            }
        }
        return 0;
    }
}
