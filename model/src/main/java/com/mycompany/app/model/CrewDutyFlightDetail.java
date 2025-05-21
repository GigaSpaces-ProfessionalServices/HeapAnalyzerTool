package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.crewsequence.raw.CrewHotel;
import com.gigaspaces.annotation.pojo.*;
import com.gigaspaces.metadata.index.SpaceIndexType;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//@CompoundSpaceIndexes({
//        @CompoundSpaceIndex(paths = {
//                "dutyKey.sequenceNumber", "dutyKey.sequenceOrignDate", "dutyKey.crewBase", "dutyKey.crewType",
//                "dutyKey.airlineCode", "dutyKey.domesticOrInternational"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "dutyKey.sequenceNumber", "dutyKey.sequenceOrignDate", "dutyKey.crewBase", "dutyKey.crewType",
//                "dutyKey.airlineCode", "dutyKey.domesticOrInternational", "dutyKey.employeeNumber"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "dutyKey.sequenceNumber", "dutyKey.sequenceOrignDate", "dutyKey.crewBase", "dutyKey.crewType",
//                "dutyKey.airlineCode", "dutyKey.domesticOrInternational", "dutyKey.position"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "dutyKey.sequenceNumber", "dutyKey.sequenceOrignDate", "dutyKey.dutyPeriodNumber", "employeeNumber"
//        })
//})

@SpaceClass
//@MirrorTable(name = MirrorConstants.CREW_DUTY_FLIGHT_DETAIL)
public class CrewDutyFlightDetail implements Serializable, Cloneable
{
   private static final long serialVersionUID = 7904148089760178309L;
//   @MirrorColumn(name = MirrorConstants.CREW_DUTY_KEY, pk = true, embedded=true)
   private CrewDutyKey dutyKey;
//   @MirrorColumn(name = MirrorConstants.NEXT_DUTY_KEY, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
   private CrewDutyKey nextDutyKey;
//   @MirrorColumn(name = MirrorConstants.PREVIOUS_DUTY_KEY, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
   private CrewDutyKey previousDutyKey;
   private CrewPositionKey positionKey;
//   @MirrorColumn(name = MirrorConstants.FOS_UPDATE_TIME, type = MirrorConstants.DATETIME2)
   private Date fosUpdateTime;
//   @MirrorColumn(name = MirrorConstants.RAP_POSITION, type = MirrorConstants.NVARCHAR)
   private String rapPosition;
//   @MirrorColumn(name = MirrorConstants.SEQUENCE_POSITION, type = MirrorConstants.NVARCHAR)
   private String sequencePosition;
//   @MirrorColumn(name = MirrorConstants.DUTY_START_TIME, type = MirrorConstants.DATETIME2)
   private Date dutyStartTime;
//   @MirrorColumn(name = MirrorConstants.DUTY_END_TIME, type = MirrorConstants.DATETIME2)
   private Date dutyEndTime;
//   @MirrorColumn(name = MirrorConstants.END_SEQUENCE_CODE, type = MirrorConstants.BIT)
   private Boolean endSequenceCode = false;
//   @MirrorColumn(name = MirrorConstants.PREVIOUS_DUTY_END_TIME, type = MirrorConstants.DATETIME2)
   private Date previousDutyEndTime;
//   @MirrorColumn(name = MirrorConstants.ACTIVITY_DATE, type = MirrorConstants.DATETIME2)
   private Date activityDate;
//   @MirrorColumn(name = MirrorConstants.PREVIOUS_REST_MINUTES, type = MirrorConstants.INT)
   private Integer previousRestMinutes;
//   @MirrorColumn(name = MirrorConstants.NEXT_REST_MINUTES, type = MirrorConstants.INT)
   private Integer nextRestMinutes;
//   @MirrorColumn(name = MirrorConstants.RAP_MINUTES, type = MirrorConstants.INT)
   private Integer rapMinutes;
   private String nextRestMinutesPreviousState;
   private String domesticOrInternationalFromFlights;

//   @MirrorColumn(name = MirrorConstants.DUTY_START_DEPARTURE_STATION, type = MirrorConstants.NVARCHAR)
   private String dutyStartDepartureStation;
//   @MirrorColumn(name = MirrorConstants.BASE_LONGTITUDE_DEGREES, type = MirrorConstants.INT)
   private Integer baseLongtitudeDegrees;
//   @MirrorColumn(name = MirrorConstants.DEPARTURE_STATION_LONGTITUDE_DEGREES, type = MirrorConstants.INT)
   private Integer departureStationLongtitudeDegrees;
//   @MirrorColumn(name = MirrorConstants.START_FDP_SERIES, type = MirrorConstants.BIT)
   private Boolean startFdpSeries;
//   @MirrorColumn(name = MirrorConstants.TEN_HOURS_REST, type = MirrorConstants.BIT)
   private Boolean tenHourRest;
//   @MirrorColumn(name = MirrorConstants.CREW_FLIGHTS, iterate=true)
   private List<CrewFlightDetail> crewFlights;
//   @MirrorColumn(name = MirrorConstants.HOTEL, embedded=true)
   private CrewHotel crewHotel;
//   @MirrorColumn(name = MirrorConstants.TEMP_DUTY_START_DATE, type = MirrorConstants.DATETIME2)
   private Date tempDutyStartDate;
//   @MirrorColumn(name = MirrorConstants.TEMP_DUTY_END_DATE, type = MirrorConstants.DATETIME2)
   private Date tempDutyEndDate;
//   @MirrorColumn(name = MirrorConstants.TEMP_CREW_BASE, type = MirrorConstants.NVARCHAR)
   private String tempCrewBase;
//   @MirrorColumn(name = MirrorConstants.TEMP_DUTY_INDICATOR, type = MirrorConstants.BIT)
   private Boolean tempDutyIndicator;
//   @MirrorColumn(name = MirrorConstants.SEQUENCE_CHANGED, type = MirrorConstants.BIT)
   private Boolean sequenceChanged = false;
//   @MirrorColumn(name = MirrorConstants.CREW_REST_START_TIME, type = MirrorConstants.DATETIME2)
   private Date crewRestStartTime;
//   @MirrorColumn(name = MirrorConstants.CREW_REST_END_TIME, type = MirrorConstants.DATETIME2)
   private Date crewRestEndTime;
//   @MirrorColumn(name = MirrorConstants.IS_REDUCED_REST, type = MirrorConstants.BIT)
   private Boolean isReducedRest = false;
//   @MirrorColumn(name = MirrorConstants.SEQUENCE_DATE, type = MirrorConstants.BIGINT)
   private long sequenceDate;
//   @MirrorColumn(name = MirrorConstants.DUTY_START_TIMESTAMP, type = MirrorConstants.BIGINT)
   private long dutyStartTimestamp;
//   @MirrorColumn(name = MirrorConstants.DUTY_END_TIMESTAMP, type = MirrorConstants.BIGINT)
   private long dutyEndTimestamp;
//   @MirrorColumn(name = MirrorConstants.SCHEDULED_ON_DUTY_MINUTES, type = MirrorConstants.INT)
   private Integer scheduledOnDutyMinutes;
//   @MirrorColumn(name = MirrorConstants.CONTRACTUAL_MONTH, type = MirrorConstants.NVARCHAR)
   private String contractualMonth;
//   @MirrorColumn(name = MirrorConstants.SCHEDULED_DUTY_START_TIME, type = MirrorConstants.DATETIME2)
   private Date scheduledDutyStartTime;
//   @MirrorColumn(name = MirrorConstants.SCHEDULED_DUTY_END_TIME, type = MirrorConstants.DATETIME2)
   private Date scheduledDutyEndTime;
//   @MirrorColumn(name = MirrorConstants.POSITION_IND, embedded=true)
   private PositionInd positionInd;
//   @MirrorColumn(name = MirrorConstants.LEGALITY_IND, embedded=true)
   private LegalityInd legalityInd;
//   @MirrorColumn(name = MirrorConstants.MISC_IND, embedded=true)
   private String miscInd;
//   @MirrorColumn(name = MirrorConstants.REST_CLASS_FACILITY, type = MirrorConstants.INT)
   private int restClassFacility;
//   @MirrorColumn(name = MirrorConstants.DOUBLE_UP_SEQUENCE, type = MirrorConstants.BIT)
   private Boolean doubleUpSequence = false;
//   @MirrorColumn(name = MirrorConstants.THIRTY_HOUR_REST_START_TIME, type = MirrorConstants.DATETIME2)
   private Date thirtyHourRestStartTime;
//   @MirrorColumn(name = MirrorConstants.THIRTY_HOUR_REST_END_TIME, type = MirrorConstants.DATETIME2)
   private Date thirtyHourRestEndTime;
//   @MirrorColumn(name = MirrorConstants.IS_AMOC, type = MirrorConstants.BIT)
   private Boolean isAmoc = false;
//   @MirrorColumn(name = MirrorConstants.IS_SEA_BLR_AMOC, type = MirrorConstants.BIT)
   private Boolean isSeaBlrAmoc = false;
//   @MirrorColumn(name = MirrorConstants.IS_DEL_JFK_AMOC, type = MirrorConstants.BIT)
   private Boolean isDelJfkAmoc = false;
//   @MirrorColumn(name = MirrorConstants.ROUTING_ID, type = MirrorConstants.NVARCHAR)
   private String routingId;
   private String previousEmployeeNumber;
   private String assignedDuringTraining;

   public String getAssignedDuringTraining() {
      return assignedDuringTraining;
   }

   public void setAssignedDuringTraining(String assignedDuringTraining) {
      this.assignedDuringTraining = assignedDuringTraining;
   }




   @SpaceId(autoGenerate = false)
    public CrewDutyKey getDutyKey() {
        return dutyKey;
    }

    public void setDutyKey(CrewDutyKey dutyKey) {
        this.dutyKey = dutyKey;
        if (this.dutyKey != null)
        {
           this.employeeNumber = this.dutyKey.getEmployeeNumber();
           this.positionKey = new CrewPositionKey(dutyKey.getSequenceNumber(),dutyKey.getSequenceOrignDate(),
              dutyKey.getCrewBase(),dutyKey.getCrewType(),dutyKey.getAirlineCode(),
              dutyKey.getDomesticOrInternational(),dutyKey.getEmployeeNumber(),dutyKey.getPosition());
        }
    }

    private String employeeNumber;

    /**
     * @return the employeeNumber
     */
    @SpaceIndex
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @SpaceRouting
    public String getRoutingId() {
        if ("000000".equals(employeeNumber)) {
            return dutyKey.generateSequenceKeyString();
        }
        return employeeNumber;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

   /**
    * @param employeeNumber the employeeNumber to set
    */
   public void setEmployeeNumber(String employeeNumber)
   {
      this.employeeNumber = employeeNumber;
   }

   public void setPositionKey(CrewPositionKey positionKey)
   {
      this.positionKey = positionKey;
   }

   @SpaceIndex
   public CrewPositionKey getPositionKey()
   {
      return positionKey;
   }

   public Date getFosUpdateTime()
   {
      return fosUpdateTime;
   }

   public void setFosUpdateTime(Date fosUpdateTime)
   {
      this.fosUpdateTime = fosUpdateTime;
   }

   public String getSequencePosition()
   {
      return sequencePosition;
   }

   public void setSequencePosition(String sequencePosition)
   {
      this.sequencePosition = sequencePosition;
   }

   @SpaceIndex(type = SpaceIndexType.EXTENDED)
   public Date getDutyStartTime()
   {
      return dutyStartTime;
   }

   public void setDutyStartTime(Date dutyStartTime)
   {
      this.dutyStartTime = dutyStartTime;
      if( this.dutyStartTime != null )
         setDutyStartTimestamp(this.dutyStartTime.getTime());
   }

   @SpaceIndex(type = SpaceIndexType.EXTENDED)
   public Date getDutyEndTime()
   {
      return dutyEndTime;
   }

   public void setDutyEndTime(Date dutyEndTime)
   {
      this.dutyEndTime = dutyEndTime;
      if( this.dutyEndTime != null )
         setDutyEndTimestamp(this.dutyEndTime.getTime());
   }

   public Boolean getEndSequenceCode()
   {
      return endSequenceCode;
   }

   public void setEndSequenceCode(Boolean endSequenceCode)
   {
      this.endSequenceCode = endSequenceCode;
   }

   public Date getPreviousDutyEndTime()
   {
      return previousDutyEndTime;
   }

   public void setPreviousDutyEndTime(Date previousDutyEndTime)
   {
      this.previousDutyEndTime = previousDutyEndTime;
   }

   public Date getActivityDate()
   {
      return activityDate;
   }

   public void setActivityDate(Date activityDate)
   {
      this.activityDate = activityDate;
   }

   public String getDutyStartDepartureStation()
   {
      return dutyStartDepartureStation;
   }

   public void setDutyStartDepartureStation(String dutyStartDepartureStation)
   {
      this.dutyStartDepartureStation = dutyStartDepartureStation;
   }

   public Integer getBaseLongtitudeDegrees()
   {
      return baseLongtitudeDegrees;
   }

   public void setBaseLongtitudeDegrees(Integer baseLongtitudeDegrees)
   {
      this.baseLongtitudeDegrees = baseLongtitudeDegrees;
   }

   public Integer getDepartureStationLongtitudeDegrees()
   {
      return departureStationLongtitudeDegrees;
   }

   public void setDepartureStationLongtitudeDegrees(Integer departureStationLongtitudeDegrees)
   {
      this.departureStationLongtitudeDegrees = departureStationLongtitudeDegrees;
   }

   public Boolean getStartFdpSeries()
   {
      return startFdpSeries;
   }

   public void setStartFdpSeries(Boolean startFdpSeries)
   {
      this.startFdpSeries = startFdpSeries;
   }

   public Boolean getTenHourRest()
   {
      return tenHourRest;
   }

   public void setTenHourRest(Boolean tenHourRest)
   {
      this.tenHourRest = tenHourRest;
   }

   @SpaceIndex(path = "[*].flightKey")
   public List<CrewFlightDetail> getCrewFlights()
   {
      if (crewFlights == null)
         return new ArrayList<CrewFlightDetail>();
      return crewFlights;
   }

   public List<CrewFlightDetail> getCrewFlightsCopy(){
      if (crewFlights == null) {
         return new ArrayList<CrewFlightDetail>();
      }
      else {
         HashMap<String, CrewFlightDetail> cloneMap = new HashMap<>();
         for (CrewFlightDetail item : crewFlights)
            cloneMap.put(item.getFlightKey().toString(), item);
         return new ArrayList<CrewFlightDetail>(cloneMap.values());
      }
   }

   public void setCrewFlights(List<CrewFlightDetail> crewFlights)
   {
      this.crewFlights = crewFlights;
   }

   public Date getTempDutyStartDate()
   {
      return tempDutyStartDate;
   }

   public void setTempDutyStartDate(Date tempDutyStartDate)
   {
      this.tempDutyStartDate = tempDutyStartDate;
   }

   public Date getTempDutyEndDate()
   {
      return tempDutyEndDate;
   }

   public void setTempDutyEndDate(Date tempDutyEndDate)
   {
      this.tempDutyEndDate = tempDutyEndDate;
   }

   public String getTempCrewBase()
   {
      return tempCrewBase;
   }

   public void setTempCrewBase(String tempCrewBase)
   {
      this.tempCrewBase = tempCrewBase;
   }

   public Boolean getTempDutyIndicator()
   {
      return tempDutyIndicator;
   }

   public void setTempDutyIndicator(Boolean tempDutyIndicator)
   {
      this.tempDutyIndicator = tempDutyIndicator;
   }

   /**
    * @return the rapMinutes
    */
   public Integer getRapMinutes()
   {
      return rapMinutes;
   }

   /**
    * @param rapMinutes the rapMinutes to set
    */
   public void setRapMinutes(Integer rapMinutes)
   {
      this.rapMinutes = rapMinutes;
   }

   public CrewHotel getCrewHotel()
   {
      return crewHotel;
   }

   public void setCrewHotel(CrewHotel crewHotel)
   {
      this.crewHotel = crewHotel;
   }

   public Boolean getSequenceChanged()
   {
      return sequenceChanged;
   }

   public void setSequenceChanged(Boolean sequenceChanged)
   {
      this.sequenceChanged = sequenceChanged;
   }


   public Date getCrewRestStartTime()
   {
      return crewRestStartTime;
   }

   public void setCrewRestStartTime(Date crewRestStartTime)
   {
      this.crewRestStartTime = crewRestStartTime;
   }

   public Date getCrewRestEndTime()
   {
      return crewRestEndTime;
   }

   public void setCrewRestEndTime(Date crewRestEndTime)
   {
      this.crewRestEndTime = crewRestEndTime;
   }

   public Boolean getIsReducedRest()
   {
      return isReducedRest;
   }

   public void setIsReducedRest(Boolean isReducedRest)
   {
      this.isReducedRest = isReducedRest;
   }

   public Date getThirtyHourRestStartTime()
   {
      return thirtyHourRestStartTime;
   }

   public void setThirtyHourRestStartTime(Date thirtyHourRestStartTime)
   {
      this.thirtyHourRestStartTime = thirtyHourRestStartTime;
   }

   public Date getThirtyHourRestEndTime()
   {
      return thirtyHourRestEndTime;
   }

   public void setThirtyHourRestEndTime(Date thirtyHourRestEndTime)
   {
      this.thirtyHourRestEndTime = thirtyHourRestEndTime;
   }


   public CrewDutyFlightDetail()
   {
   }

   public CrewDutyFlightDetail(CrewDutyFlightDetail flightDuty, ArrayList<CrewFlightDetail> crewFlights,
                               String snapshotId)
   {
      this.activityDate = flightDuty.getActivityDate();
      this.baseLongtitudeDegrees = flightDuty.getBaseLongtitudeDegrees();
      this.crewFlights = crewFlights;
      this.crewHotel = flightDuty.getCrewHotel();
      this.departureStationLongtitudeDegrees = flightDuty.getDepartureStationLongtitudeDegrees();
      if (flightDuty.getDutyKey() != null)
      {
         CrewDutyKey crewDutyKey = new CrewDutyKey(flightDuty.getDutyKey().getPositionKey(), flightDuty
                 .getDutyKey().getDutyPeriodNumber());
         crewDutyKey.setSnapshotId(snapshotId);
         this.dutyKey = crewDutyKey;
      }
      this.dutyStartDepartureStation = flightDuty.getDutyStartDepartureStation();
      this.dutyStartTime = flightDuty.getDutyStartTime();
      this.dutyEndTime = flightDuty.getDutyEndTime();

      this.employeeNumber = flightDuty.getEmployeeNumber();
      this.endSequenceCode = flightDuty.getEndSequenceCode();
      this.fosUpdateTime = flightDuty.getFosUpdateTime();

      this.previousDutyEndTime = flightDuty.getPreviousDutyEndTime();
      this.rapMinutes = flightDuty.getRapMinutes();
      this.nextRestMinutes = flightDuty.getNextRestMinutes();
      this.previousRestMinutes = flightDuty.getPreviousRestMinutes();
      this.nextRestMinutesPreviousState = flightDuty.getNextRestMinutesPreviousState();
      this.domesticOrInternationalFromFlights = flightDuty.getDomesticOrInternationalFromFlights();
      this.sequenceChanged = flightDuty.getSequenceChanged();
      this.sequencePosition = flightDuty.getSequencePosition();
      this.startFdpSeries = flightDuty.getStartFdpSeries();
      this.tempCrewBase = flightDuty.getTempCrewBase();
      this.tempDutyEndDate = flightDuty.getTempDutyEndDate();
      this.tempDutyIndicator = flightDuty.getTempDutyIndicator();
      this.tempDutyStartDate = flightDuty.getTempDutyStartDate();
      this.tenHourRest = flightDuty.getTenHourRest();
      this.crewRestEndTime = flightDuty.getCrewRestEndTime();
      this.crewRestStartTime = flightDuty.getCrewRestStartTime();
      this.isReducedRest = flightDuty.getIsReducedRest();
      this.sequenceDate = flightDuty.getSequenceDate();
      this.nextDutyKey = flightDuty.getNextDutyKey();
      this.previousDutyKey = flightDuty.getPreviousDutyKey();
      this.restClassFacility = flightDuty.getRestClassFacility();
      this.positionInd = flightDuty.getPositionInd();
      this.legalityInd = flightDuty.getLegalityInd();
      this.miscInd = flightDuty.getMiscInd();
      this.positionKey = flightDuty.getPositionKey();
      this.contractualMonth = flightDuty.getContractualMonth();
      this.assignedDuringTraining = flightDuty.getAssignedDuringTraining();
   }

   /**
    * @return the previousRestMinutes
    */
   public Integer getPreviousRestMinutes()
   {
      return previousRestMinutes;
   }

   /**
    * @param previousRestMinutes the previousRestMinutes to set
    */
   public void setPreviousRestMinutes(Integer previousRestMinutes)
   {
      this.previousRestMinutes = previousRestMinutes;
   }

   /**
    * @return the nextRestMinutes
    */
   public Integer getNextRestMinutes()
   {
      return nextRestMinutes;
   }

   /**
    * @param nextRestMinutes the nextRestMinutes to set
    */
   public void setNextRestMinutes(Integer nextRestMinutes)
   {
      this.nextRestMinutes = nextRestMinutes;
   }

    public String getNextRestMinutesPreviousState()
   {
      return nextRestMinutesPreviousState;
   }

   /**
    * @param domesticOrInternationalFromFlights either uninitialized, previouslyOver30hr or previouslyUnder30hr
    */
   public void setDomesticOrInternationalFromFlights(String domesticOrInternationalFromFlights)
   {
      this.domesticOrInternationalFromFlights = domesticOrInternationalFromFlights;
   }

   public String getDomesticOrInternationalFromFlights()
   {
      return domesticOrInternationalFromFlights;
   }

   /**
    * @param state either uninitialized, previouslyOver30hr or previouslyUnder30hr
    */
   public void setNextRestMinutesPreviousState(String state)
   {
      this.nextRestMinutesPreviousState = state;
   }

   /**
    * @return the sequenceDate
    */
   @SpaceIndex(type = SpaceIndexType.EXTENDED)
   @SpaceProperty(nullValue="-1" )
   public long getSequenceDate()
   {
      return sequenceDate;
   }

   /**
    * Sets the sequence date as a long value representing the Date with no time.
    * @param sequenceDate the sequenceDate to set
    */
   public void setSequenceDate(long sequenceDate)
   {
      this.sequenceDate = sequenceDate;
   }

   /**
    * @return the nextDutyKey
    */
   public CrewDutyKey getNextDutyKey()
   {
      return nextDutyKey;
   }

   /**
    * @param nextDutyKey the nextDutyKey to set
    */
   public void setNextDutyKey(CrewDutyKey nextDutyKey)
   {
      this.nextDutyKey = nextDutyKey;
   }

   /**
    * @return the previousDutyKey
    */
   public CrewDutyKey getPreviousDutyKey()
   {
      return previousDutyKey;
   }

   /**
    * @param previousDutyKey the previousDutyKey to set
    */
   public void setPreviousDutyKey(CrewDutyKey previousDutyKey)
   {
      this.previousDutyKey = previousDutyKey;
   }


   /**
    * @return the scheduledOnDutyMinutes
    */
   public Integer getScheduledOnDutyMinutes() {
      return scheduledOnDutyMinutes;
   }

   /**
    * @param scheduledOnDutyMinutes the scheduledOnDutyMinutes to set
    */
   public void setScheduledOnDutyMinutes(Integer scheduledOnDutyMinutes) {
      this.scheduledOnDutyMinutes = scheduledOnDutyMinutes;
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

   /**
    * @return the scheduledDutyStartTime
    */
   public Date getScheduledDutyStartTime() {
      return scheduledDutyStartTime;
   }

   /**
    * @param scheduledDutyStartTime the scheduledDutyStartTime to set
    */
   public void setScheduledDutyStartTime(Date scheduledDutyStartTime) {
      this.scheduledDutyStartTime = scheduledDutyStartTime;
   }

   public Date getScheduledDutyEndTime() {
      return scheduledDutyEndTime;
   }

   public void setScheduledDutyEndTime(Date scheduledDutyEndTime) {
      this.scheduledDutyEndTime = scheduledDutyEndTime;
   }

   @SpaceIndex(type = SpaceIndexType.EXTENDED)
   @SpaceProperty(nullValue="-1" )
   public long getDutyStartTimestamp()
   {
      return dutyStartTimestamp;
   }

   public void setDutyStartTimestamp(long dutyStartTimestamp)
   {
      this.dutyStartTimestamp = dutyStartTimestamp;
   }

   @SpaceIndex(type = SpaceIndexType.EXTENDED)
   @SpaceProperty(nullValue="-1" )
   public long getDutyEndTimestamp()
   {
      return dutyEndTimestamp;
   }

   public void setDutyEndTimestamp(long dutyEndTimestamp)
   {
      this.dutyEndTimestamp = dutyEndTimestamp;
   }

   public String getRapPosition() {
      return rapPosition;
   }

   public void setRapPosition(String rapPosition) {
      this.rapPosition = rapPosition;
   }

    public PositionInd getPositionInd() {
        return positionInd;
    }

    public void setPositionInd(PositionInd positionInd) {
        this.positionInd = positionInd;
    }

   public LegalityInd getLegalityInd() {
      return legalityInd;
   }

   public void setLegalityInd(LegalityInd legalityInd) {
      this.legalityInd = legalityInd;
   }

   public String getMiscInd() {
      return miscInd;
   }

   public void setMiscInd(String miscInd) {
      this.miscInd = miscInd;
   }

   //@Override
   @SpaceProperty(nullValue="-1" )
   public int getRestClassFacility()
   {
      return restClassFacility;
   }

   public void setRestClassFacility(int restClassFacility)
   {
      this.restClassFacility = restClassFacility;
	}

	public Boolean getDoubleUpSequence() {
		return doubleUpSequence;
	}

	public void setDoubleUpSequence(Boolean doubleUpSequence) {
		this.doubleUpSequence = doubleUpSequence;
	}
   public Boolean getAmoc() {  return isAmoc;  }

   public void setAmoc(Boolean amoc) {      isAmoc = amoc;   }

   public Boolean getSeaBlrAmoc() {  return isSeaBlrAmoc;  }

   public void setSeaBlrAmoc(Boolean seaBlrAmoc) {      isSeaBlrAmoc = seaBlrAmoc;   }

   public Boolean getDelJfkAmoc() {  return isDelJfkAmoc;  }

   public void setDelJfkAmoc(Boolean DelJfkAmoc) {      isDelJfkAmoc = DelJfkAmoc;   }

   public String getPreviousEmployeeNumber() {
      return previousEmployeeNumber;
   }
   public void setPreviousEmployeeNumber(String previousEmployeeNumber) {
      this.previousEmployeeNumber =  previousEmployeeNumber;
   }

@Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (!(o instanceof CrewDutyFlightDetail))
         return false;

      CrewDutyFlightDetail that = (CrewDutyFlightDetail)o;

      if (sequenceDate != that.sequenceDate)
         return false;
      if (dutyStartTimestamp != that.dutyStartTimestamp)
         return false;
      if (dutyEndTimestamp != that.dutyEndTimestamp)
         return false;
      if( restClassFacility != that.restClassFacility)
         return false;
      if (dutyKey != null ? !dutyKey.equals(that.dutyKey) : that.dutyKey != null)
         return false;
      if (nextDutyKey != null ? !nextDutyKey.equals(that.nextDutyKey) : that.nextDutyKey != null)
         return false;
      if (previousDutyKey != null ? !previousDutyKey.equals(that.previousDutyKey) :
              that.previousDutyKey != null)
         return false;
      if (positionKey != null ? !positionKey.equals(that.positionKey) : that.positionKey != null)
         return false;
      if (fosUpdateTime != null ? !fosUpdateTime.equals(that.fosUpdateTime) : that.fosUpdateTime != null)
         return false;
      if (rapPosition != null ? !rapPosition.equals(that.rapPosition) : that.rapPosition != null)
         return false;
      if (sequencePosition != null ? !sequencePosition.equals(that.sequencePosition) :
              that.sequencePosition != null)
         return false;
      if (dutyStartTime != null ? !dutyStartTime.equals(that.dutyStartTime) : that.dutyStartTime != null)
         return false;
      if (dutyEndTime != null ? !dutyEndTime.equals(that.dutyEndTime) : that.dutyEndTime != null)
         return false;
      if (endSequenceCode != null ? !endSequenceCode.equals(that.endSequenceCode) :
              that.endSequenceCode != null)
         return false;
      if (previousDutyEndTime != null ? !previousDutyEndTime.equals(that.previousDutyEndTime) :
              that.previousDutyEndTime != null)
         return false;
      if (activityDate != null ? !activityDate.equals(that.activityDate) : that.activityDate != null)
         return false;
      if (previousRestMinutes != null ? !previousRestMinutes.equals(that.previousRestMinutes) :
              that.previousRestMinutes != null)
         return false;
      if (nextRestMinutes != null ? !nextRestMinutes.equals(that.nextRestMinutes) :
              that.nextRestMinutes != null)
         return false;
      if (rapMinutes != null ? !rapMinutes.equals(that.rapMinutes) : that.rapMinutes != null)
         return false;
      if (dutyStartDepartureStation != null ?
              !dutyStartDepartureStation.equals(that.dutyStartDepartureStation) :
              that.dutyStartDepartureStation != null)
         return false;
      if (baseLongtitudeDegrees != null ? !baseLongtitudeDegrees.equals(that.baseLongtitudeDegrees) :
              that.baseLongtitudeDegrees != null)
         return false;
      if (departureStationLongtitudeDegrees != null ?
              !departureStationLongtitudeDegrees.equals(that.departureStationLongtitudeDegrees) :
              that.departureStationLongtitudeDegrees != null)
         return false;
      if (startFdpSeries != null ? !startFdpSeries.equals(that.startFdpSeries) : that.startFdpSeries != null)
         return false;
      if (tenHourRest != null ? !tenHourRest.equals(that.tenHourRest) : that.tenHourRest != null)
         return false;
      if (crewHotel != null ? !crewHotel.equals(that.crewHotel) : that.crewHotel != null)
         return false;
      if (tempDutyStartDate != null ? !tempDutyStartDate.equals(that.tempDutyStartDate) :
              that.tempDutyStartDate != null)
         return false;
      if (tempDutyEndDate != null ? !tempDutyEndDate.equals(that.tempDutyEndDate) :
              that.tempDutyEndDate != null)
         return false;
      if (tempCrewBase != null ? !tempCrewBase.equals(that.tempCrewBase) : that.tempCrewBase != null)
         return false;
      if (tempDutyIndicator != null ? !tempDutyIndicator.equals(that.tempDutyIndicator) :
              that.tempDutyIndicator != null)
         return false;
      if (sequenceChanged != null ? !sequenceChanged.equals(that.sequenceChanged) :
              that.sequenceChanged != null)
         return false;
      if (crewRestStartTime != null ? !crewRestStartTime.equals(that.crewRestStartTime) :
              that.crewRestStartTime != null)
         return false;
      if (crewRestEndTime != null ? !crewRestEndTime.equals(that.crewRestEndTime) :
              that.crewRestEndTime != null)
         return false;
      if (isReducedRest != null ? !isReducedRest.equals(that.isReducedRest) : that.isReducedRest != null)
         return false;
      if (scheduledOnDutyMinutes != null ? !scheduledOnDutyMinutes.equals(that.scheduledOnDutyMinutes) :
              that.scheduledOnDutyMinutes != null)
         return false;
      if (contractualMonth != null ? !contractualMonth.equals(that.contractualMonth) :
              that.contractualMonth != null)
         return false;
      if (scheduledDutyStartTime != null ? !scheduledDutyStartTime.equals(that.scheduledDutyStartTime) :
              that.scheduledDutyStartTime != null)
         return false;
      return employeeNumber != null ? employeeNumber.equals(that.employeeNumber) :
              that.employeeNumber == null;
   }

   @Override
   public int hashCode()
   {
      int result = dutyKey != null ? dutyKey.hashCode() : 0;
      result = 31 * result + (nextDutyKey != null ? nextDutyKey.hashCode() : 0);
      result = 31 * result + (previousDutyKey != null ? previousDutyKey.hashCode() : 0);
      result = 31 * result + (positionKey != null ? positionKey.hashCode() : 0);
      result = 31 * result + (fosUpdateTime != null ? fosUpdateTime.hashCode() : 0);
      result = 31 * result + (rapPosition != null ? rapPosition.hashCode() : 0);
      result = 31 * result + (sequencePosition != null ? sequencePosition.hashCode() : 0);
      result = 31 * result + (dutyStartTime != null ? dutyStartTime.hashCode() : 0);
      result = 31 * result + (dutyEndTime != null ? dutyEndTime.hashCode() : 0);
      result = 31 * result + (endSequenceCode != null ? endSequenceCode.hashCode() : 0);
      result = 31 * result + (previousDutyEndTime != null ? previousDutyEndTime.hashCode() : 0);
      result = 31 * result + (activityDate != null ? activityDate.hashCode() : 0);
      result = 31 * result + (previousRestMinutes != null ? previousRestMinutes.hashCode() : 0);
      result = 31 * result + (nextRestMinutes != null ? nextRestMinutes.hashCode() : 0);
      result = 31 * result + (rapMinutes != null ? rapMinutes.hashCode() : 0);
      result = 31 * result + (dutyStartDepartureStation != null ? dutyStartDepartureStation.hashCode() : 0);
      result = 31 * result + (baseLongtitudeDegrees != null ? baseLongtitudeDegrees.hashCode() : 0);
      result = 31 * result +
              (departureStationLongtitudeDegrees != null ? departureStationLongtitudeDegrees.hashCode() : 0);
      result = 31 * result + (startFdpSeries != null ? startFdpSeries.hashCode() : 0);
      result = 31 * result + (tenHourRest != null ? tenHourRest.hashCode() : 0);
      result = 31 * result + (crewHotel != null ? crewHotel.hashCode() : 0);
      result = 31 * result + (tempDutyStartDate != null ? tempDutyStartDate.hashCode() : 0);
      result = 31 * result + (tempDutyEndDate != null ? tempDutyEndDate.hashCode() : 0);
      result = 31 * result + (tempCrewBase != null ? tempCrewBase.hashCode() : 0);
      result = 31 * result + (tempDutyIndicator != null ? tempDutyIndicator.hashCode() : 0);
      result = 31 * result + (sequenceChanged != null ? sequenceChanged.hashCode() : 0);
      result = 31 * result + (crewRestStartTime != null ? crewRestStartTime.hashCode() : 0);
      result = 31 * result + (crewRestEndTime != null ? crewRestEndTime.hashCode() : 0);
      result = 31 * result + (isReducedRest != null ? isReducedRest.hashCode() : 0);
      result = 31 * result + (int)(sequenceDate ^ (sequenceDate >>> 32));
      result = 31 * result + (int)(dutyStartTimestamp ^ (dutyStartTimestamp >>> 32));
      result = 31 * result + (int)(dutyEndTimestamp ^ (dutyEndTimestamp >>> 32));
      result = 31 * result + (int)(restClassFacility ^ (restClassFacility >>> 32));
      result = 31 * result + (scheduledOnDutyMinutes != null ? scheduledOnDutyMinutes.hashCode() : 0);
      result = 31 * result + (contractualMonth != null ? contractualMonth.hashCode() : 0);
      result = 31 * result + (scheduledDutyStartTime != null ? scheduledDutyStartTime.hashCode() : 0);
      result = 31 * result + (employeeNumber != null ? employeeNumber.hashCode() : 0);
      return result;
   }

   public enum NextRestMinutesPreviousState {
       UNINITIALIZED {
           public String toString() {
               return "UNINITIALIZED";
           }
       },
       OVER30 {
           public String toString() {
               return "OVER30";
           }
       },
       UNDER30 {
           public String toString() {
               return "UNDER30";
           }
       };
       public static NextRestMinutesPreviousState fromString(String text) {
           for (NextRestMinutesPreviousState value : NextRestMinutesPreviousState.values()) {
               if (value.toString().equalsIgnoreCase(text)) {
                   return value;
               }
           }
           return null;
       }
   }

   @Override
   public String toString() {
      return "CrewDutyFlightDetail{" +
              "dutyKey=" + dutyKey +
              ", nextDutyKey=" + nextDutyKey +
              ", previousDutyKey=" + previousDutyKey +
              ", positionKey=" + positionKey +
              ", fosUpdateTime=" + fosUpdateTime +
              ", rapPosition='" + rapPosition +
              ", sequencePosition='" + sequencePosition +
              ", dutyStartTime=" + dutyStartTime +
              ", dutyEndTime=" + dutyEndTime +
              ", previousDutyEndTime=" + previousDutyEndTime +
              ", activityDate=" + activityDate +
              ", previousRestMinutes=" + previousRestMinutes +
              ", nextRestMinutes=" + nextRestMinutes +
              ", rapMinutes=" + rapMinutes +
              ", nextRestMinutesPreviousState='" + nextRestMinutesPreviousState +
              ", domesticOrInternationalFromFlights='" + domesticOrInternationalFromFlights +
              ", dutyStartDepartureStation='" + dutyStartDepartureStation +
              ", tenHourRest=" + tenHourRest +
              ", crewFlights=" + crewFlights +
              ", dutyStartTimestamp=" + dutyStartTimestamp +
              ", dutyEndTimestamp=" + dutyEndTimestamp +
              ", positionInd=" + positionInd +
              ", doubleUpSequence=" + doubleUpSequence +
              ", thirtyHourRestStartTime=" + thirtyHourRestStartTime +
              ", thirtyHourRestEndTime=" + thirtyHourRestEndTime +
              ", isAmoc=" + isAmoc +
              ", isSeaBlrAmoc=" + isSeaBlrAmoc +
              ", isDelJfkAmoc=" + isDelJfkAmoc +
              ", routingId='" + routingId +
              ", employeeNumber='" + employeeNumber +
              '}';
   }

   @Override
   public CrewDutyFlightDetail clone() {
      try {
         return (CrewDutyFlightDetail) super.clone();
      } catch (CloneNotSupportedException e) {
         throw new IllegalStateException(e);
      }
   }
}
