package com.mycompany.app.model;

import java.io.Serializable;

public class CrewPositionDetail implements Serializable {
    private static final long serialVersionUID = 6755375040407628669L;
    private String employeeNumber;
    private String sequencePosition;
    private String departureStation;
    private String failingContinuityIndicator;
    private Integer neededRestMinutes;
    private String restType;
    private String arrivalOfLastLeg;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getSequencePosition() {
        return sequencePosition;
    }

    public void setSequencePosition(String sequencePosition) {
        this.sequencePosition = sequencePosition;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getFailingContinuityIndicator() {
        return failingContinuityIndicator;
    }

    public void setFailingContinuityIndicator(String failingContinuityIndicator) {
        this.failingContinuityIndicator = failingContinuityIndicator;
    }

    public Integer getNeededRestMinutes() {
        return neededRestMinutes;
    }

    public void setNeededRestMinutes(Integer neededRestMinutes) {
        this.neededRestMinutes = neededRestMinutes;
    }

    public String getRestType() {
        return restType;
    }

    public void setRestType(String restType) {
        this.restType = restType;
    }

    public String getArrivalOfLastLeg() {
        return arrivalOfLastLeg;
    }

    public void setArrivalOfLastLeg(String arrivalOfLastLeg) {
        this.arrivalOfLastLeg = arrivalOfLastLeg;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        CrewPositionDetail other = CrewPositionDetail.class.cast(obj);

        if (employeeNumber == null) {
            if (other.employeeNumber != null)
                return false;
        } else if (!employeeNumber.equals(other.employeeNumber)) {
            return false;
        }

        if (sequencePosition == null) {
            if (other.sequencePosition != null)
                return false;
        } else if (!sequencePosition.equals(other.sequencePosition)) {
            return false;
        }

        if (departureStation == null) {
            if (other.departureStation != null)
                return false;
        } else if (!departureStation.equals(other.departureStation)) {
            return false;
        }

        if (failingContinuityIndicator == null) {
            if (other.failingContinuityIndicator != null)
                return false;
        } else if (!failingContinuityIndicator.equals(other.failingContinuityIndicator)) {
            return false;
        }

        if (neededRestMinutes == null) {
            if (other.neededRestMinutes != null)
                return false;
        } else if (!neededRestMinutes.equals(other.neededRestMinutes)) {
            return false;
        }

        if (restType == null) {
            if (other.restType != null)
                return false;
        } else if (!restType.equals(other.restType)) {
            return false;
        }

        if (arrivalOfLastLeg == null) {
            if (other.arrivalOfLastLeg != null)
                return false;
        } else if (!arrivalOfLastLeg.equals(other.arrivalOfLastLeg)) {
            return false;
        }

        return true;
    }

}
