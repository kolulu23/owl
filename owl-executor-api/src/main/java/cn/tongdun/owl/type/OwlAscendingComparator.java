package cn.tongdun.owl.type;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 3:54 PM
 */
public class OwlAscendingComparator implements Comparator<OwlVariable> {
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
                return a.getInner().getIntValue().compareTo(b.getInner().getIntValue());
            } else if (aIsDouble && bIsDouble) {
                return a.getInner().getDoubleValue().compareTo(b.getInner().getDoubleValue());
            } else if (aIsInt && bIsDouble) {
                return new BigDecimal(a.getInner().getIntValue()).compareTo(b.getInner().getDoubleValue());
            } else if (aIsDouble && bIsInt) {
                return a.getInner().getDoubleValue().compareTo(new BigDecimal(b.getInner().getIntValue()));
            }
        }
        // If type doesn't match or one of them is null, don't do sort
        return 0;
    }
}
