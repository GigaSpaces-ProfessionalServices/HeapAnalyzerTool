package com.mycompany.app.model;

import java.io.Serializable;

//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
public class LegalityInd implements Serializable {

    private static final long serialVersionUID = -1668049402658655114L;
//    @MirrorColumn(name = MirrorConstants.EXTENDED_LONG_RANGE, type = MirrorConstants.BIT)
    private Boolean extendedLongRange; //bit 2
//    @MirrorColumn(name = MirrorConstants.LEGALITY_IND_BITS, type = MirrorConstants.NVARCHAR)
    private String bits;

    public Boolean getExtendedLongRange() {
        return extendedLongRange;
    }

    public void setExtendedLongRange(Boolean extendedLongRange) {
        this.extendedLongRange = extendedLongRange;
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
