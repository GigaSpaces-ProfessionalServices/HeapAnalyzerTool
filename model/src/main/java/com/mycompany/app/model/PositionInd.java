package com.mycompany.app.model;

import java.io.Serializable;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
/**
 * Created by derhuang on 10/31/17.
 */
public class PositionInd implements Serializable {

    private static final long serialVersionUID = -1668049402658555114L;
//    @MirrorColumn(name = MirrorConstants.LONG_RANGE, type = MirrorConstants.BIT)
    private Boolean longRange; //bit 12
//    @MirrorColumn(name = MirrorConstants.POSITION_IND_BITS, type = MirrorConstants.NVARCHAR)
    private String bits;

    public Boolean getLongRange() {
        return longRange;
    }

    public void setLongRange(Boolean longRange) {
        this.longRange = longRange;
    }

    /*
        * This gives back the leg type as bits (non-Javadoc)
        * @see java.lang.Object#toString()
        */
    @Override
    public String toString()
    {
        return bits;
    }

    /**
     * @param bits the bits to set
     */
    public void setBits(String bits)
    {
        this.bits = bits;
    }
    
    public String getBits() {
        return bits;
    }
}
