package com.mycompany.app.model;

import java.io.Serializable;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "jsonId")
public class CrewSequenceKey implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2972435756693615846L;
//    @MirrorColumn(name = MirrorConstants.SEQUENCE_NUMBER, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String sequenceNumber;
//    @MirrorColumn(name = MirrorConstants.SEQUENCE_ORIGIN_DATE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String sequenceOrignDate;
//    @MirrorColumn(name = MirrorConstants.CREW_BASE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String crewBase;
//    @MirrorColumn(name = MirrorConstants.CREW_TYPE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String crewType;
//    @MirrorColumn(name = MirrorConstants.CREW_SEQ_AIRLINE_CODE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_5)
    private String airlineCode;
//    @MirrorColumn(name = MirrorConstants.DOMESTIC_OR_INTERNATIONAL, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_5)
    private String domesticOrInternational;
//    @MirrorColumn(name = MirrorConstants.CREW_SEQ_SNAPSHOT_ID, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String snapshotId = "0";

    public CrewSequenceKey() {

    }

    public CrewSequenceKey(String sequenceNumber, String sequenceOrignDate,
                           String crewBase, String crewType, String airlineCode,
                           String domesticOrInternational) {
        this.sequenceNumber = sequenceNumber;
        this.sequenceOrignDate = sequenceOrignDate;
        this.crewBase = crewBase;
        this.crewType = crewType;
        this.airlineCode = airlineCode;
        this.domesticOrInternational = domesticOrInternational;

    }

    public CrewSequenceKey(String sequenceNumber, String sequenceOrignDate,
            String crewBase, String crewType, String airlineCode,
            String domesticOrInternational,String snapshotId ) {
        this.sequenceNumber = sequenceNumber;
        this.sequenceOrignDate = sequenceOrignDate;
        this.crewBase = crewBase;
        this.crewType = crewType;
        this.airlineCode = airlineCode;
        this.domesticOrInternational = domesticOrInternational;
        this.snapshotId=snapshotId;
}

    public CrewSequenceKey(CrewSequenceKey sequenceKey) {
        this.sequenceNumber = sequenceKey.getSequenceNumber();
        this.sequenceOrignDate = sequenceKey.getSequenceOrignDate();
        this.crewBase = sequenceKey.getCrewBase();
        this.crewType = sequenceKey.getCrewType();
        this.airlineCode = sequenceKey.getAirlineCode();
        this.domesticOrInternational = sequenceKey.getDomesticOrInternational();

    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSequenceOrignDate() {
        return sequenceOrignDate;
    }

    public void setSequenceOrignDate(String sequenceOrigDate) {
        this.sequenceOrignDate = sequenceOrigDate;
    }

    public String getCrewBase() {
        return crewBase;
    }

    public void setCrewBase(String crewBase) {
        this.crewBase = crewBase;
    }

    public String getCrewType() {
        return crewType;
    }

    public void setCrewType(String crewType) {
        this.crewType = crewType;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getDomesticOrInternational() {
        return domesticOrInternational;
    }

    public void setDomesticOrInternational(String domesticOrInternational) {
        this.domesticOrInternational = domesticOrInternational;
    }

    /**
     * @return the snapshotId
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /**
     * @param snapshotId the snapshotId to set
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public CrewSequenceKey getSequenceKey() {
        return this;
    }

//    public static boolean isEqual(CrewSequenceKey crewSequenceKey1,
//                                  CrewSequenceKey crewSequenceKey2) {
//        boolean isEqual = false;
//        if (crewSequenceKey1 == null || crewSequenceKey2 == null) {
//            isEqual = ComparisonUtil.isEqualCheckIfOneObjectIsNull(
//                    crewSequenceKey1, crewSequenceKey2);
//        } else {
//            if (ComparisonUtil.isEqual(crewSequenceKey1.getSequenceNumber(),
//                    crewSequenceKey2.getSequenceNumber())
//                    && ComparisonUtil.isEqual(
//                    crewSequenceKey1.getSequenceOrignDate(),
//                    crewSequenceKey2.getSequenceOrignDate())
//                    && ComparisonUtil.isEqual(
//                    crewSequenceKey1.getAirlineCode(),
//                    crewSequenceKey2.getAirlineCode())
//                    && ComparisonUtil.isEqual(crewSequenceKey1.getCrewBase(),
//                    crewSequenceKey2.getCrewBase())
//                    && ComparisonUtil.isEqual(crewSequenceKey1.getCrewType(),
//                    crewSequenceKey2.getCrewType())
//                    && ComparisonUtil.isEqual(
//                    crewSequenceKey1.getDomesticOrInternational(),
//                    crewSequenceKey2.getDomesticOrInternational())) {
//                isEqual = true;
//            }
//        }
//        return isEqual;
//
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CrewSequenceKey that = (CrewSequenceKey) o;

        if (sequenceNumber != null ? !sequenceNumber.equals(that.sequenceNumber) : that.sequenceNumber != null)
            return false;
        if (sequenceOrignDate != null ? !sequenceOrignDate.equals(that.sequenceOrignDate) :
                that.sequenceOrignDate != null)
            return false;
        if (crewBase != null ? !crewBase.equals(that.crewBase) : that.crewBase != null)
            return false;
        if (crewType != null ? !crewType.equals(that.crewType) : that.crewType != null)
            return false;
        if (airlineCode != null ? !airlineCode.equals(that.airlineCode) : that.airlineCode != null)
            return false;
        if (domesticOrInternational != null ? !domesticOrInternational.equals(that.domesticOrInternational) :
                that.domesticOrInternational != null)
            return false;
        return snapshotId != null ? snapshotId.equals(that.snapshotId) : that.snapshotId == null;
    }

    @Override
    public int hashCode() {
        int result = sequenceNumber != null ? sequenceNumber.hashCode() : 0;
        result = 31 * result + (sequenceOrignDate != null ? sequenceOrignDate.hashCode() : 0);
        result = 31 * result + (crewBase != null ? crewBase.hashCode() : 0);
        result = 31 * result + (crewType != null ? crewType.hashCode() : 0);
        result = 31 * result + (airlineCode != null ? airlineCode.hashCode() : 0);
        result = 31 * result + (domesticOrInternational != null ? domesticOrInternational.hashCode() : 0);
        result = 31 * result + (snapshotId != null ? snapshotId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return sequenceNumber + "|" + sequenceOrignDate +
                "|" + crewBase + "|" + crewType + "|"
                + airlineCode + "|" + domesticOrInternational + "|" + snapshotId;
    }

    public String generateSequenceKeyString() {
        return sequenceNumber + "|" + sequenceOrignDate +
                "|" + crewBase + "|" + crewType + "|"
                + airlineCode + "|" + domesticOrInternational + "|" + snapshotId;
    }
}
