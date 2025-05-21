package com.mycompany.app.model;

//import com.aa.lookahead.crew.legality.southamerica.SouthAmericaCrewBases;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
import java.io.Serializable;

public class CrewDutyKey extends CrewPositionKey implements Serializable {
    private static final long serialVersionUID = -5615625528585306533L;
//    @MirrorColumn(name = MirrorConstants.DUTY_PERIOD_NUMBER, type = MirrorConstants.INT)
    private Integer dutyPeriodNumber;

    public CrewDutyKey() {
    }

    /**
     * Creates a new new <code>CrewDutyKey</code>.
     *
     * @param sequenceNumber          <code>String</code> sequence number
     * @param sequenceOrignDate       <code>String</code> sequence origination date as yyyy-MM-dd
     * @param crewBase                <code>String</code> crew base (DFW/ORD/MIA)
     * @param crewType                <code>String</code> crew type (F/P)
     * @param airlineCode             <code>String</code> airline code
     * @param domesticOrInternational <code>String</code> domestic or international
     *                                indicator (D/I)
     * @param employeeNumber          <code>String</code> employee number
     * @param dutyPeriodNumber        <code>Integer</code> duty period number
     * @param position                <code>String</code> sequence position (CA/FO/01..09)
     */
    public CrewDutyKey(String sequenceNumber, String sequenceOrignDate, String crewBase, String crewType,
                       String airlineCode, String domesticOrInternational, String employeeNumber, Integer dutyPeriodNumber,
                       String position) {
        super(sequenceNumber, sequenceOrignDate, crewBase, crewType, airlineCode, domesticOrInternational,
                employeeNumber, position);
        this.dutyPeriodNumber = dutyPeriodNumber;
    }

    /**
     * Creates a new <code>CrewDutyKey</code> object using the position key and duty period
     * number
     *
     * @param positionKey   <code>CrewPositionKey</code> position key
     * @param dutyPrdNumber <code>Integer</code> duty period number
     */
    public CrewDutyKey(CrewPositionKey positionKey, Integer dutyPrdNumber) {
        super(positionKey, positionKey.getEmployeeNumber(), positionKey.getPosition());
        this.dutyPeriodNumber = dutyPrdNumber;
    }

    public Integer getDutyPeriodNumber() {
        return dutyPeriodNumber;
    }

    public void setDutyPeriodNumber(Integer dutyPeriodNumber) {
        this.dutyPeriodNumber = dutyPeriodNumber;
    }

    public CrewDutyKey getDutyKey() {
        return this;
    }

    public boolean isSACrew() {
//        for (SouthAmericaCrewBases base : SouthAmericaCrewBases.values()) {
//            if (base.getCrewbase().equals(this.getCrewBase()))
//                return true;
//        }
        return false;
    }

    public boolean isEmpty() {
        return (getEmployeeNumber()==null || getSequenceNumber()==null);
    }

    @Override
    public String toString() {
        return super.toString() + "|" + dutyPeriodNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        CrewDutyKey that = (CrewDutyKey) o;

        return dutyPeriodNumber != null ? dutyPeriodNumber.equals(that.dutyPeriodNumber) :
                that.dutyPeriodNumber == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dutyPeriodNumber != null ? dutyPeriodNumber.hashCode() : 0);
        return result;
    }
}
