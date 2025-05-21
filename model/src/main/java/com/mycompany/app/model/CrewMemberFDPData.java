package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.crewmember.keys.FdpDataKey;
//import com.aa.lookahead.utils.common.CrewMirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;
import com.gigaspaces.annotation.pojo.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 623797
 */
//@CompoundSpaceIndexes({
//        @CompoundSpaceIndex(paths = {
//                "fdpDataKey.activityMonth", "fdpDataKey.employeeNumber"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "sequenceOrignDate", "sequenceNumber", "dutyPeriodNumber"
//        })
//})
//@MirrorTable(name = CrewMirrorConstants.CREW_MEMBER_FDP_DATA)
@SpaceClass
public class CrewMemberFDPData extends Status implements Serializable   {
    private static final long serialVersionUID = 2182897338662332030L;
//    @MirrorColumn(name = CrewMirrorConstants.FDP_DATA_KEY, type = CrewMirrorConstants.NVARCHAR, precision = 27, pk = true)
    private String fdpDataKey = null;
//    @MirrorColumn(name = CrewMirrorConstants.FOS_UPDATE_TIME, type = CrewMirrorConstants.DATETIME2, precision = CrewMirrorConstants.DATETIME2_PRECISION)
    private Date sourceTimestamp = null;
//    @MirrorColumn(name = CrewMirrorConstants.EVENT_GMT_START_DATE, type = CrewMirrorConstants.DATETIME2, precision = CrewMirrorConstants.DATETIME2_PRECISION)
    private Date eventGMTStartDate = null;
//    @MirrorColumn(name = CrewMirrorConstants.EVENT_GMT_END_DATE, type = CrewMirrorConstants.DATETIME2, precision = CrewMirrorConstants.DATETIME2_PRECISION)
    private Date eventGMTEndDate = null;
//    @MirrorColumn(name = CrewMirrorConstants.FLIGHT_DURATION, type = CrewMirrorConstants.INT)
    private Integer flightDuration = null;

//    @MirrorColumn(name = CrewMirrorConstants.DUTY_PERIOD_NUMBER, type = CrewMirrorConstants.INT)
    private Integer dutyPeriodNumber;
//    @MirrorColumn(name = CrewMirrorConstants.SEQUENCE_NUMBER, type = CrewMirrorConstants.NVARCHAR, precision = 6)
    private String sequenceNumber;
//    @MirrorColumn(name = CrewMirrorConstants.SEQUENCE_ORIGN_DATE, type = CrewMirrorConstants.DATETIME2, precision = CrewMirrorConstants.DATETIME2_PRECISION)
    private Date sequenceOrignDate;
//    @MirrorColumn(name = CrewMirrorConstants.POSITION_CODE, type = CrewMirrorConstants.NVARCHAR, precision = 4)
    private String positionCode;
//    @MirrorColumn(name = CrewMirrorConstants.DEPARTURE_LONGITUDE, type = CrewMirrorConstants.NVARCHAR, precision = 8)
    private String depLongitude;
//    @MirrorColumn(name = CrewMirrorConstants.ARRIVAL_LONGITUDE, type = CrewMirrorConstants.NVARCHAR, precision = 8)
    private String arvLongitude;
//    @MirrorColumn(name = CrewMirrorConstants.ACCLIMATED_LONGITUDE, type = CrewMirrorConstants.NVARCHAR, precision = 8)
    private String acclimatedTheaterLongitude;
//    @MirrorColumn(name = CrewMirrorConstants.THEATER_LONGITUDE, type = CrewMirrorConstants.NVARCHAR, precision = 8)
    private String currentTheaterLongitude;
//    @MirrorColumn(name = CrewMirrorConstants.ACCLIMATED_STATION, type = CrewMirrorConstants.NVARCHAR, precision = 3)
    private String currentAcclimatedTheaterStation;
//    @MirrorColumn(name = CrewMirrorConstants.THEATER_STATION, type = CrewMirrorConstants.NVARCHAR, precision = 3)
    private String currentTheaterStation;
//    @MirrorColumn(name = CrewMirrorConstants.FDP_EXTENSION_LIMIT, type = CrewMirrorConstants.INT)
    private Integer fdpExtensionLimit;
//    @MirrorColumn(name = CrewMirrorConstants.FDP_INDICATORS, type = CrewMirrorConstants.NVARCHAR, precision = 20)
    private String fdpIndicators = null;
//    @MirrorColumn(name = CrewMirrorConstants.ACCLIMATED_INDICATORS, type = CrewMirrorConstants.NVARCHAR, precision = 20)
    private String acclimatedIndicators = null;
//    @MirrorColumn(name = CrewMirrorConstants.CONTRACTUAL_MONTH, type = CrewMirrorConstants.NVARCHAR, precision = 7)
    private String contractualMonth;

    /**
     * @return the fdpDataKey
     */
    @SpaceId(autoGenerate = false)
    public String getFdpDataKey() {
        return fdpDataKey;
    }

    /**
     * @param fdpDataKey the fdpDataKey to set
     */
    public void setFdpDataKey(String fdpDataKey) {
        this.fdpDataKey = fdpDataKey;
//        this.employeeNumber = this.fdpDataKey.getEmployeeNumber();
    }

    private String employeeNumber;

    /**
     * @return the employeeNumber
     */
    @SpaceIndex
    @SpaceRouting
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * @param employeeNumber the employeeNumber to set
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * @return the sourceTimestamp
     */
    public Date getSourceTimestamp() {
        return sourceTimestamp;
    }

    /**
     * @param sourceTimestamp the sourceTimestamp to set
     */
    public void setSourceTimestamp(Date sourceTimestamp) {
        this.sourceTimestamp = sourceTimestamp;
    }

    /**
     * @return the eventGMTEndDate
     */
    public Date getEventGMTEndDate() {
        return eventGMTEndDate;
    }

    /**
     * @param eventGMTEndDate the eventGMTEndDate to set
     */
    public void setEventGMTEndDate(Date eventGMTEndDate) {
        this.eventGMTEndDate = eventGMTEndDate;
    }

    /**
     * @return the flightDuration
     */
    public Integer getFlightDuration() {
        return flightDuration;
    }

    /**
     * @param flightDuration the flightDuration to set
     */
    public void setFlightDuration(Integer flightDuration) {
        this.flightDuration = flightDuration;
    }

    /**
     * @return the eventGMTStartDate
     */
    public Date getEventGMTStartDate() {
        return eventGMTStartDate;
    }

    /**
     * @param eventGMTStartDate the eventGMTStartDate to set
     */
    public void setEventGMTStartDate(Date eventGMTStartDate) {
        this.eventGMTStartDate = eventGMTStartDate;
    }

    /**
     * @return the fdpIndicators
     */
    public String getFdpIndicators() {
        return fdpIndicators;
    }

    /**
     * @param fdpIndicators the fdpIndicators to set
     */
    public void setFdpIndicators(String fdpIndicators) {
        this.fdpIndicators = fdpIndicators;
    }

    /**
     * @return the acclimatedIndicators
     */
    public String getAcclimatedIndicators() {
        return acclimatedIndicators;
    }

    /**
     * @param acclimatedIndicators the acclimatedIndicators to set
     */
    public void setAcclimatedIndicators(String acclimatedIndicators) {
        this.acclimatedIndicators = acclimatedIndicators;
    }

    /**
     * @return the dutyPeriodNumber
     */
    public Integer getDutyPeriodNumber() {
        return dutyPeriodNumber;
    }

    /**
     * @param dutyPeriodNumber the dutyPeriodNumber to set
     */
    public void setDutyPeriodNumber(Integer dutyPeriodNumber) {
        this.dutyPeriodNumber = dutyPeriodNumber;
    }

    /**
     * @return the sequenceNumber
     */
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * @param sequenceNumber the sequenceNumber to set
     */
    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * @return the sequenceOrignDate
     */
    public Date getSequenceOrignDate() {
        return sequenceOrignDate;
    }

    /**
     * @param sequenceOrignDate the sequenceOrignDate to set
     */
    public void setSequenceOrignDate(Date sequenceOrignDate) {
        this.sequenceOrignDate = sequenceOrignDate;
    }

    /**
     * @return the positionCode
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * @param positionCode the positionCode to set
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    /**
     * @return the depLongitude
     */
    public String getDepLongitude() {
        return depLongitude;
    }

    /**
     * @param depLongitude the depLongitude to set
     */
    public void setDepLongitude(String depLongitude) {
        this.depLongitude = depLongitude;
    }

    /**
     * @return the arvLongitude
     */
    public String getArvLongitude() {
        return arvLongitude;
    }

    /**
     * @param arvLongitude the arvLongitude to set
     */
    public void setArvLongitude(String arvLongitude) {
        this.arvLongitude = arvLongitude;
    }

    /**
     * @return the acclimatedTheaterLongitude
     */
    public String getAcclimatedTheaterLongitude() {
        return acclimatedTheaterLongitude;
    }

    /**
     * @param acclimatedTheaterLongitude the acclimatedTheaterLongitude to set
     */
    public void setAcclimatedTheaterLongitude(String acclimatedTheaterLongitude) {
        this.acclimatedTheaterLongitude = acclimatedTheaterLongitude;
    }

    /**
     * @return the currentTheaterLongitude
     */
    public String getCurrentTheaterLongitude() {
        return currentTheaterLongitude;
    }

    /**
     * @param currentTheaterLongitude the currentTheaterLongitude to set
     */
    public void setCurrentTheaterLongitude(String currentTheaterLongitude) {
        this.currentTheaterLongitude = currentTheaterLongitude;
    }

    /**
     * @return the currentAcclimatedTheaterStation
     */
    public String getCurrentAcclimatedTheaterStation() {
        return currentAcclimatedTheaterStation;
    }

    /**
     * @param currentAcclimatedTheaterStation the currentAcclimatedTheaterStation to set
     */
    public void setCurrentAcclimatedTheaterStation(String currentAcclimatedTheaterStation) {
        this.currentAcclimatedTheaterStation = currentAcclimatedTheaterStation;
    }

    /**
     * @return the currentTheaterStation
     */
    public String getCurrentTheaterStation() {
        return currentTheaterStation;
    }

    /**
     * @param currentTheaterStation the currentTheaterStation to set
     */
    public void setCurrentTheaterStation(String currentTheaterStation) {
        this.currentTheaterStation = currentTheaterStation;
    }

    /**
     * @return the fdpExtensionLimit
     */
    public Integer getFdpExtensionLimit() {
        return fdpExtensionLimit;
    }

    /**
     * @param fdpExtensionLimit the fdpExtensionLimit to set
     */
    public void setFdpExtensionLimit(Integer fdpExtensionLimit) {
        this.fdpExtensionLimit = fdpExtensionLimit;
    }

    /**
     * @return the contractualMonth
     */
    public String getContractualMonth() {
        return contractualMonth;
    }

    /**
     * @param contractualMonth the contractualMonth to set
     */
    public void setContractualMonth(String contractualMonth) {
        this.contractualMonth = contractualMonth;
    }
}
