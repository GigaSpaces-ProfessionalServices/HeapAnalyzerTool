package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.LKAFlightKey;
//import com.aa.lookahead.dataobjects.crewsequence.read.CrewSequenceKey;

import java.io.Serializable;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;

public class RemainingFlightDutyKey implements Serializable {

    private static final long serialVersionUID = 1836961235625277989L;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_KEY, embedded=true)
    private LKAFlightKey flightKey;
//    @MirrorColumn(name = MirrorConstants.EMPLOYEE_NUMBER, type = MirrorConstants.NVARCHAR)
    private String employeeNumber;
//    @MirrorColumn(name = MirrorConstants.CREW_SEQUENCE_KEY, embedded=true)
    private CrewSequenceKey crewSequenceKey;

    public RemainingFlightDutyKey(LKAFlightKey flightKey, String employeeNumber, CrewSequenceKey crewSequenceKey) {
        this.flightKey = flightKey;
        this.employeeNumber = employeeNumber;
        this.crewSequenceKey = crewSequenceKey;
    }

    public LKAFlightKey getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(LKAFlightKey flightKey) {
        this.flightKey = flightKey;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public CrewSequenceKey getCrewSequenceKey() {
        return crewSequenceKey;
    }

    public void setCrewSequenceKey(CrewSequenceKey crewSequenceKey) {
        this.crewSequenceKey = crewSequenceKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        RemainingFlightDutyKey other = RemainingFlightDutyKey.class.cast(obj);
        if (flightKey == null) {
            if (other.flightKey != null)
                return false;
        } else if (!flightKey.equals(other.flightKey))
            return false;
        if (crewSequenceKey == null) {
            if (other.crewSequenceKey != null)
                return false;
        } else if (!crewSequenceKey.equals(other.crewSequenceKey))
            return false;
        if (employeeNumber == null) {
            if (other.employeeNumber != null)
                return false;
        } else if (!employeeNumber.equals(other.employeeNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return flightKey.toString() + "|" + employeeNumber +
                "|" + crewSequenceKey.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((flightKey == null) ? 0 : flightKey.hashCode());
        result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
        result = prime * result + ((crewSequenceKey == null) ? 0 : crewSequenceKey.hashCode());
        return result;
    }

    /**
     * Deep Copy Constructor
     *
     * @param flightDutyKey
     * @param snapshotId
     */
    public RemainingFlightDutyKey(RemainingFlightDutyKey flightDutyKey, String snapshotId) {
        LKAFlightKey flightKey = new LKAFlightKey(flightDutyKey.getFlightKey());
        flightKey.setSnapshotId(snapshotId);
        this.flightKey = flightKey;
        this.employeeNumber = flightDutyKey.getEmployeeNumber();
        this.crewSequenceKey = new CrewSequenceKey(flightDutyKey.getCrewSequenceKey());
        this.crewSequenceKey.setSnapshotId(snapshotId);
    }

}
