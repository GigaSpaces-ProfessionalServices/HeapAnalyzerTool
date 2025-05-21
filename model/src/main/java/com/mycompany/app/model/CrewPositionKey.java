package com.mycompany.app.model;

import java.io.Serializable;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
public class CrewPositionKey extends CrewSequenceKey implements Serializable {
    private static final long serialVersionUID = -1603768316222462915L;

//    @MirrorColumn(name = MirrorConstants.EMPLOYEE_NUMBER, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String employeeNumber;
//    @MirrorColumn(name = MirrorConstants.POSITION, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String position;

    /**
     * Default constructor
     */
    public CrewPositionKey() {
    }

    /**
     * Creates a new <code>CrewPositionKey</code>
     *
     * @param sequenceNumber          <code>String</code> sequence number
     * @param sequenceOrignDate       <code>String</code> sequence origination date as yyyy-MM-dd
     * @param crewBase                <code>String</code> crew base (DFW/ORD/MIA)
     * @param crewType                <code>String</code> crew type (F/P)
     * @param airlineCode             <code>String</code> airline code
     * @param domesticOrInternational <code>String</code> domestic or international
     *                                indicator (D/I)
     * @param employeeNumber          <code>String</code> employee number
     * @param position                <code>String</code> sequence position (CA/FO/01..09)
     */
    public CrewPositionKey(String sequenceNumber, String sequenceOrignDate, String crewBase, String crewType,
                           String airlineCode, String domesticOrInternational, String employeeNumber, String position) {
        super(sequenceNumber, sequenceOrignDate, crewBase, crewType, airlineCode, domesticOrInternational);
        this.employeeNumber = employeeNumber;
        this.position = position;
    }

    /**
     * Creates a new <code>CrewPositionKey</code> using the crew sequenceKey and employee
     * number
     *
     * @param sequenceKey    <code>CrewSequenceKey</code> crew sequence key
     * @param employeeNumber <code>String</code> employee number
     * @param position       <code>String</code> sequence position (CA/FO/01..09)
     */
    public CrewPositionKey(CrewSequenceKey sequenceKey, String employeeNumber, String position) {
        super(sequenceKey.getSequenceNumber(), sequenceKey.getSequenceOrignDate(), sequenceKey.getCrewBase(),
                sequenceKey.getCrewType(), sequenceKey.getAirlineCode(), sequenceKey.getDomesticOrInternational());
        this.employeeNumber = employeeNumber;
        this.position = position;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public CrewPositionKey getPositionKey() {
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + position + "|" + employeeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        CrewPositionKey that = (CrewPositionKey) o;

        if (employeeNumber != null ? !employeeNumber.equals(that.employeeNumber) : that.employeeNumber != null)
            return false;
        return position != null ? position.equals(that.position) : that.position == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (employeeNumber != null ? employeeNumber.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
