package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.LKAFlightKey;
//import com.aa.lookahead.dataobjects.crewsequence.raw.LegType;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

//@MirrorTable(name = MirrorConstants.CREW_FLIGHT_DETAIL)
public class CrewFlightDetail implements Serializable
{
   private static final long serialVersionUID = 8091558416942823305L;
   /**
    *
    */
//    @MirrorColumn(name = MirrorConstants.FLIGHT_KEY, pk = true, embedded=true)
    private LKAFlightKey flightKey;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_POSITION, type = MirrorConstants.NVARCHAR)
    private String flightPosition;
//    @MirrorColumn(name = MirrorConstants.LEG_TYPE, embedded=true)
    private String legType;
//    @MirrorColumn(name = MirrorConstants.REQUIRED_FA_STAFFING, type = MirrorConstants.BIT)
    private Boolean requiredFAStaffing = false;
//    @MirrorColumn(name = MirrorConstants.CODE_21E2, type = MirrorConstants.NVARCHAR)
    private String code21E2;
//    @MirrorColumn(name = MirrorConstants.LANGUAGE_REQUIREMENT, type = MirrorConstants.NVARCHAR)
    private String languageRequirement;
//    @MirrorColumn(name = MirrorConstants.ATC_DELAY_MINUTES, type = MirrorConstants.INT)
    private Integer atcDelayMinutes;
//    @MirrorColumn(name = MirrorConstants.DEICING_DELAY_MINUTES, type = MirrorConstants.INT)
    private Integer deicingDelayMinutes;
//    @MirrorColumn(name = MirrorConstants.RAMP_DELAY_MINUTES, type = MirrorConstants.INT)
    private Integer rampDelayMinutes;
//    @MirrorColumn(name = MirrorConstants.LEG_ASSIGNMENT_CODE, type = MirrorConstants.NVARCHAR)
    private String legAssignmentCode;
//    @MirrorColumn(name = MirrorConstants.LEG_REMOVAL_CODE, type = MirrorConstants.NVARCHAR)
    private String legRemovalCode;
//    @MirrorColumn(name = MirrorConstants.DEPARTURE_TIME_LOCAL_REFERENCE_MINUTES, type = MirrorConstants.INT)
    private Integer departureTimeLocalReferenceMinutes;
//    @MirrorColumn(name = MirrorConstants.ARRIVAL_TIME_LOCAL_REFERENCE_MINUTES, type = MirrorConstants.INT)
    private Integer arrivalTimeLocalReferenceMinutes;
//    @MirrorColumn(name = MirrorConstants.ACTUAL_EQUIPMENT_TYPE, type = MirrorConstants.NVARCHAR)
    private String actualEquipmentType;
//    @MirrorColumn(name = MirrorConstants.EXPANSION, embedded=true)
    private String expansionBits;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_ORDER_IN_SEQUENCE, type = MirrorConstants.INT)
    private Integer flightOrderInSequence;
//    @MirrorColumn(name = MirrorConstants.ACTUAL_SEAT, type = MirrorConstants.NVARCHAR)
    private String actualSeat;
//    @MirrorColumn(name = MirrorConstants.CREW_TYPE_CODE, type = MirrorConstants.NVARCHAR)
    private String crewTypeCode;
//    @MirrorColumn(name = MirrorConstants.DEAD_HEAD_TYPE, type = MirrorConstants.NVARCHAR)
    private String deadHeadType;
//    @MirrorColumn(name= MirrorConstants.SEAT_SPECIFIC_DATA, embedded=true)
    private String seatSpecificData;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_FLIGHT_KEY, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_450)
    private LKAFlightKey previousFlightKey;
//    @MirrorColumn(name = MirrorConstants.NEXT_FLIGHT_KEY, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_450)
    private LKAFlightKey nextFlightKey;
//    @MirrorColumn(name = MirrorConstants.CREW_DUTY_KEY, pk = true, embedded=true)
    private CrewDutyKey dutyKey;
//    @MirrorColumn(name = MirrorConstants.OAL_DEPARTURE_TIME, type = MirrorConstants.DATETIME2)
    private Date oalDepartureTime;
//    @MirrorColumn(name = MirrorConstants.OAL_ARRIVAL_TIME, type = MirrorConstants.DATETIME2)
    private Date oalArrivalTime;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_TYPE, type = MirrorConstants.NVARCHAR)
    private String flightType;
//    @MirrorColumn(name = MirrorConstants.REPORT_OR_SURFACE_LEG_ARRIVAL_STN, type = MirrorConstants.NVARCHAR)
    private String reportOrSurfaceLegArrivalStn;
    //Arrival station of previous leg
//    @MirrorColumn(name = MirrorConstants.PRVIOUS_LEG_ARRIVAL_STATION, type = MirrorConstants.NVARCHAR)
    private String previousLegArrivalStation;
    //Crew Coming From
//    @MirrorColumn(name = MirrorConstants.CREW_COMING_FROM, type = MirrorConstants.NVARCHAR)
    private String crewComingFrom;
    // indicators used to determine if the flight is the begging or end of a duty
//    @MirrorColumn(name = MirrorConstants.FIRST_FLIGHT_IN_DUTY, type = MirrorConstants.BIT)
    private Boolean firstFlightInDuty;
//    @MirrorColumn(name = MirrorConstants.LAST_FLIGHT_IN_DUTY, type = MirrorConstants.BIT)
    private Boolean lastFlightInDuty;
//    @MirrorColumn(name = MirrorConstants.ARRIVAL_STATION, type = MirrorConstants.NVARCHAR)
    private String arrivalStation;
//    @MirrorColumn(name = MirrorConstants.IS_HRD, type = MirrorConstants.BIT)
    private Boolean isHRD = false;
//    @MirrorColumn(name = MirrorConstants.IS_IPD, type = MirrorConstants.BIT)
    private Boolean isIPD = false;
//    @MirrorColumn(name = MirrorConstants.NEXT_FLIGHT_CREW_TYPE_CODE, type = MirrorConstants.NVARCHAR)
    private String nextFlightCrewTypeCode;
//    @MirrorColumn(name = MirrorConstants.CONTRACTUAL_MONTH, type = MirrorConstants.NVARCHAR)
    private String contractualMonth;
   //domestic international
   private String baseLeg;
   private boolean operatingFlight;

   public LKAFlightKey getFlightKey()
   {
      return flightKey;
   }

   public void setFlightKey(LKAFlightKey flightKey)
   {
      this.flightKey = flightKey;
   }

   public String getFlightPosition()
   {
      return flightPosition;
   }

   public void setFlightPosition(String flightPosition)
   {
      this.flightPosition = flightPosition;
   }

   public String getLegType()
   {
      return legType;
   }

   public void setLegType(String legType)
   {
      this.legType = legType;
   }

   public Boolean isRequiredFAStaffing()
   {
      return requiredFAStaffing;
   }

   public void setRequiredFAStaffing(Boolean requiredFAStaffing)
   {
      this.requiredFAStaffing = requiredFAStaffing;
   }

   public String getCode21E2()
   {
      return code21E2;
   }

   public void setCode21E2(String code21E2)
   {
      this.code21E2 = code21E2;
   }

   public String getLanguageRequirement()
   {
      return languageRequirement;
   }

   public void setLanguageRequirement(String languageRequirement)
   {
      this.languageRequirement = languageRequirement;
   }

   public Integer getAtcDelayMinutes()
   {
      return atcDelayMinutes;
   }

   public void setAtcDelayMinutes(Integer atcDelayMinutes)
   {
      this.atcDelayMinutes = atcDelayMinutes;
   }

   public Integer getDeicingDelayMinutes()
   {
      return deicingDelayMinutes;
   }

   public void setDeicingDelayMinutes(Integer deicingDelayMinutes)
   {
      this.deicingDelayMinutes = deicingDelayMinutes;
   }

   public Integer getRampDelayMinutes()
   {
      return rampDelayMinutes;
   }

   public void setRampDelayMinutes(Integer rampDelayMinutes)
   {
      this.rampDelayMinutes = rampDelayMinutes;
   }

   public String getLegAssignmentCode()
   {
      return legAssignmentCode;
   }

   public void setLegAssignmentCode(String legAssignmentCode)
   {
      this.legAssignmentCode = legAssignmentCode;
   }

   public String getLegRemovalCode()
   {
      return legRemovalCode;
   }

   public void setLegRemovalCode(String legRemovalCode)
   {
      this.legRemovalCode = legRemovalCode;
   }

   public Integer getDepartureTimeLocalReferenceMinutes()
   {
      return departureTimeLocalReferenceMinutes;
   }

   public void setDepartureTimeLocalReferenceMinutes(Integer depTimeLocalRefMinutes)
   {
      this.departureTimeLocalReferenceMinutes = depTimeLocalRefMinutes;
   }

   public Integer getArrivalTimeLocalReferenceMinutes()
   {
      return arrivalTimeLocalReferenceMinutes;
   }

   public void setArrivalTimeLocalReferenceMinutes(Integer arvTimeLocalRefMinutes)
   {
      this.arrivalTimeLocalReferenceMinutes = arvTimeLocalRefMinutes;
   }

   public String getActualEquipmentType()
   {
      return actualEquipmentType;
   }

   public void setActualEquipmentType(String actualEquipmentType)
   {
      this.actualEquipmentType = actualEquipmentType;
   }

   public String getExpansionBits()
   {
      return expansionBits;
   }

   public void setExpansionBits(String expansionBits)
   {
      this.expansionBits = expansionBits;
   }

   public Integer getFlightOrderInSequence()
   {
      return flightOrderInSequence;
   }

   public void setFlightOrderInSequence(Integer flightOrderInSequence)
   {
      this.flightOrderInSequence = flightOrderInSequence;
   }

   public String getActualSeat()
   {
      return actualSeat;
   }

   public void setActualSeat(String actualSeat)
   {
      this.actualSeat = actualSeat;
   }

   public String getSeatSpecificData()
   {
      return seatSpecificData;
   }

   public void setSeatSpecificData(String seatSpecificData)
   {
      this.seatSpecificData = seatSpecificData;
   }

   public LKAFlightKey getPreviousFlightKey()
   {
      return previousFlightKey;
   }

   public void setPreviousFlightKey(LKAFlightKey prevFlightKey)
   {
      this.previousFlightKey = prevFlightKey;
   }

   public LKAFlightKey getNextFlightKey()
   {
      return nextFlightKey;
   }

   public void setNextFlightKey(LKAFlightKey nextFlightKey)
   {
      this.nextFlightKey = nextFlightKey;
   }

   public String getCrewTypeCode()
   {
      return crewTypeCode;
   }

   public void setCrewTypeCode(String crewTypeCode)
   {
      this.crewTypeCode = crewTypeCode;
   }

   public String getDeadHeadType()
   {
      return deadHeadType;
   }

   public void setDeadHeadType(String deadHeadType)
   {
      this.deadHeadType = deadHeadType;
   }

   /**
    * @return the dutyKey
    */
   public CrewDutyKey getDutyKey()
   {
      return dutyKey;
   }

   /**
    * @param dutyKey the dutyKey to set
    */
   public void setDutyKey(CrewDutyKey dutyKey)
   {
      this.dutyKey = dutyKey;
   }

   public Date getOalDepartureTime()
   {
      return oalDepartureTime;
   }

   public void setOalDepartureTime(Date oalDepartureTime)
   {
      this.oalDepartureTime = oalDepartureTime;
   }

   public Date getOalArrivalTime()
   {
      return oalArrivalTime;
   }

   public void setOalArrivalTime(Date oalArrivalTime)
   {
      this.oalArrivalTime = oalArrivalTime;
   }

   public String getFlightType()
   {
      return flightType;
   }

   public void setFlightType(String flightType)
   {
      this.flightType = flightType;
   }

   public String getReportOrSurfaceLegArrivalStn()
   {
      return reportOrSurfaceLegArrivalStn;
   }

   public void setReportOrSurfaceLegArrivalStn(String reportOrSurfaceLegArrivalStn)
   {
      this.reportOrSurfaceLegArrivalStn = reportOrSurfaceLegArrivalStn;
   }

   public String getBaseLeg() {
      return baseLeg;
   }

   public void setBaseLeg(String baseLeg) {
      this.baseLeg = baseLeg;
   }

   public boolean isOperatingFlight() {
      return operatingFlight;
   }

   public void setOperatingFlight(boolean operatingFlight) {
      this.operatingFlight = operatingFlight;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;

      CrewFlightDetail other = CrewFlightDetail.class.cast(obj);

      if (flightKey == null)
      {
         if (other.flightKey != null)
            return false;
      }
      else if (!flightKey.equals(other.flightKey))
      {
         return false;
      }

      if (previousFlightKey == null)
      {
         if (other.previousFlightKey != null)
            return false;
      }
      else if (!previousFlightKey.equals(other.previousFlightKey))
      {
         return false;
      }

      if (nextFlightKey == null)
      {
         if (other.nextFlightKey != null)
            return false;
      }
      else if (!nextFlightKey.equals(other.nextFlightKey))
      {
         return false;
      }

      if (dutyKey == null)
      {
         if (other.dutyKey != null)
            return false;
      }
      else if (!dutyKey.equals(other.dutyKey))
      {
         return false;
      }

      if (flightPosition == null)
      {
         if (other.flightPosition != null)
            return false;
      }
      else if (!flightPosition.equals(other.flightPosition))
      {
         return false;
      }

      if (requiredFAStaffing == null)
      {
         if (other.requiredFAStaffing != null)
            return false;
      }
      else if (!requiredFAStaffing.equals(other.requiredFAStaffing))
      {
         return false;
      }

      if (code21E2 == null)
      {
         if (other.code21E2 != null)
            return false;
      }
      else if (!code21E2.equals(other.code21E2))
      {
         return false;
      }

      if (languageRequirement == null)
      {
         if (other.languageRequirement != null)
            return false;
      }
      else if (!languageRequirement.equals(other.languageRequirement))
      {
         return false;
      }

      if (atcDelayMinutes == null)
      {
         if (other.atcDelayMinutes != null)
            return false;
      }
      else if (!atcDelayMinutes.equals(other.atcDelayMinutes))
      {
         return false;
      }

      if (deicingDelayMinutes == null)
      {
         if (other.deicingDelayMinutes != null)
            return false;
      }
      else if (!deicingDelayMinutes.equals(other.deicingDelayMinutes))
      {
         return false;
      }

      if (rampDelayMinutes == null)
      {
         if (other.rampDelayMinutes != null)
            return false;
      }
      else if (!rampDelayMinutes.equals(other.rampDelayMinutes))
      {
         return false;
      }

      if (legAssignmentCode == null)
      {
         if (other.legAssignmentCode != null)
            return false;
      }
      else if (!legAssignmentCode.equals(other.legAssignmentCode))
      {
         return false;
      }

      if (legRemovalCode == null)
      {
         if (other.legRemovalCode != null)
            return false;
      }
      else if (!legRemovalCode.equals(other.legRemovalCode))
      {
         return false;
      }

      if (departureTimeLocalReferenceMinutes == null)
      {
         if (other.departureTimeLocalReferenceMinutes != null)
            return false;
      }
      else if (!departureTimeLocalReferenceMinutes.equals(other.departureTimeLocalReferenceMinutes))
      {
         return false;
      }

      if (arrivalTimeLocalReferenceMinutes == null)
      {
         if (other.arrivalTimeLocalReferenceMinutes != null)
            return false;
      }
      else if (!arrivalTimeLocalReferenceMinutes.equals(other.arrivalTimeLocalReferenceMinutes))
      {
         return false;
      }

      if (actualEquipmentType == null)
      {
         if (other.actualEquipmentType != null)
            return false;
      }
      else if (!actualEquipmentType.equals(other.actualEquipmentType))
      {
         return false;
      }

      if (flightOrderInSequence == null)
      {
         if (other.flightOrderInSequence != null)
            return false;
      }
      else if (!flightOrderInSequence.equals(other.flightOrderInSequence))
      {
         return false;
      }

      if (actualSeat == null)
      {
         if (other.actualSeat != null)
            return false;
      }
      else if (!actualSeat.equals(other.actualSeat))
      {
         return false;
      }

      if (crewTypeCode == null)
      {
         if (other.crewTypeCode != null)
            return false;
      }
      else if (!crewTypeCode.equals(other.crewTypeCode))
      {
         return false;
      }

      if (deadHeadType == null)
      {
         if (other.deadHeadType != null)
            return false;
      }
      else if (!deadHeadType.equals(other.deadHeadType))
      {
         return false;
      }

      if (oalDepartureTime == null)
      {
         if (other.oalDepartureTime != null)
            return false;
      }
      else if (!oalDepartureTime.equals(other.oalDepartureTime))
      {
         return false;
      }

      if (oalArrivalTime == null)
      {
         if (other.oalArrivalTime != null)
            return false;
      }
      else if (!oalArrivalTime.equals(other.oalArrivalTime))
      {
         return false;
      }

      if (reportOrSurfaceLegArrivalStn == null)
      {
         if (other.reportOrSurfaceLegArrivalStn != null)
            return false;
      }
      else if (!reportOrSurfaceLegArrivalStn.equals(other.reportOrSurfaceLegArrivalStn))
      {
         return false;
      }

      if (legType == null)
      {
         if (other.legType != null)
            return false;
      }
      else if (!legType.toString().equals(other.legType.toString()))
   //      else if (!legType.isEqual(other.legType))
      {
         return false;
      }

      if (seatSpecificData == null)
      {
         if (other.seatSpecificData != null)
            return false;
      }
      else if (!seatSpecificData.toString().equals(other.seatSpecificData.toString()))
      {
         return false;
      }

      if (flightType == null)
      {
         if (other.flightType != null)
            return false;
      }
//      else if (!flightType.getFlightTypeDescription().equals(other.flightType.getFlightTypeDescription()))
//      {
//         return false;
//      }

      if (expansionBits == null)
      {
         if (other.expansionBits != null)
            return false;
      }
      else if (!expansionBits.toString().equals(other.expansionBits.toString()))
      {
         return false;
      }

      if (previousLegArrivalStation == null)
      {
         if (other.previousLegArrivalStation != null)
            return false;
      }
      else if (!previousLegArrivalStation.equals(other.previousLegArrivalStation))
      {
         return false;
      }

      if (crewComingFrom == null)
      {
         if (other.crewComingFrom != null)
            return false;
      }
      else if (!crewComingFrom.equals(other.crewComingFrom))
      {
         return false;
      }

      if (nextFlightCrewTypeCode == null)
      {
         if (other.nextFlightCrewTypeCode != null)
            return false;
      }
      else if (!nextFlightCrewTypeCode.equals(other.nextFlightCrewTypeCode))
      {
         return false;
      }

      if (contractualMonth == null)
      {
         if (other.contractualMonth != null)
            return false;
      }
      else if (!contractualMonth.equals(other.contractualMonth))
      {
         return false;
      }

      return true;
   }

   /**
    * @return the firstFlightInDuty
    */
   public Boolean getFirstFlightInDuty()
   {
      return firstFlightInDuty;
   }

   /**
    * @param firstFlightInDuty the firstFlightInDuty to set
    */
   public void setFirstFlightInDuty(Boolean firstFlightInDuty)
   {
      this.firstFlightInDuty = firstFlightInDuty;
   }

   /**
    * @return the lastFlightInDuty
    */
   public Boolean getLastFlightInDuty()
   {
      return lastFlightInDuty;
   }

   /**
    * @param lastFlightInDuty the lastFlightInDuty to set
    */
   public void setLastFlightInDuty(Boolean lastFlightInDuty)
   {
      this.lastFlightInDuty = lastFlightInDuty;
   }

	/**
	 * @return the previousLegArrivalStation
	 */
	public String getPreviousLegArrivalStation() {
		return previousLegArrivalStation;
	}

	/**
	 * @param previousLegArrivalStation the previousLegArrivalStation to set
	 */
	public void setPreviousLegArrivalStation(String previousLegArrivalStation) {
		this.previousLegArrivalStation = previousLegArrivalStation;
	}

	/**
	 * @return crewComingFrom
	 */
	public String getCrewComingFrom() {
		return crewComingFrom;
	}

	/**
	 * @param crewComingFrom
	 */
	public void setCrewComingFrom(String crewComingFrom) {
		this.crewComingFrom = crewComingFrom;
	}


	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public Boolean getIsHRD() {
		return isHRD;
	}

	public void setIsHRD(Boolean isHRD) {
		this.isHRD = isHRD;
	}

   public Boolean getIsIPD() {
      return isIPD;
   }

   public void setIsIPD(Boolean isIPD) {
      this.isIPD = isIPD;
   }

	public String getNextFlightCrewTypeCode() {
		return nextFlightCrewTypeCode;
	}

	public void setNextFlightCrewTypeCode(String nextFlightCrewTypeCode) {
		this.nextFlightCrewTypeCode = nextFlightCrewTypeCode;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CrewFlightDetail [flightKey=" + flightKey + ", flightPosition="
				+ flightPosition + ", legType=" + legType + ", requiredFAStaffing="
				+ requiredFAStaffing + ", code21E2=" + code21E2
				+ ", languageRequirement=" + languageRequirement
				+ ", atcDelayMinutes=" + atcDelayMinutes + ", deicingDelayMinutes="
				+ deicingDelayMinutes + ", rampDelayMinutes=" + rampDelayMinutes
				+ ", legAssignmentCode=" + legAssignmentCode + ", legRemovalCode="
				+ legRemovalCode + ", departureTimeLocalReferenceMinutes="
				+ departureTimeLocalReferenceMinutes
				+ ", arrivalTimeLocalReferenceMinutes="
				+ arrivalTimeLocalReferenceMinutes + ", actualEquipmentType="
				+ actualEquipmentType + ", expansionBits=" + expansionBits
				+ ", flightOrderInSequence=" + flightOrderInSequence
				+ ", actualSeat=" + actualSeat + ", crewTypeCode=" + crewTypeCode
				+ ", deadHeadType=" + deadHeadType + ", seatSpecificData="
				+ seatSpecificData + ", previousFlightKey=" + previousFlightKey
				+ ", nextFlightKey=" + nextFlightKey + ", dutyKey=" + dutyKey
				+ ", oalDepartureTime=" + oalDepartureTime + ", oalArrivalTime="
				+ oalArrivalTime + ", flightType=" + flightType
				+ ", reportOrSurfaceLegArrivalStn=" + reportOrSurfaceLegArrivalStn
				+ ", previousLegArrivalStation=" + previousLegArrivalStation
				+ ", crewComingFrom=" + crewComingFrom
				+ ", firstFlightInDuty=" + firstFlightInDuty
				+ ", lastFlightInDuty=" + lastFlightInDuty
				+ ", nextFlightCrewTypeCode=" + nextFlightCrewTypeCode
            + ", contractualMonth=" + contractualMonth + "]";
	}

	public CrewFlightDetail()
	{}

	public CrewFlightDetail(CrewFlightDetail flightDetail, String snapshotId)
	{
		this.actualEquipmentType = flightDetail.getActualEquipmentType();
		this.actualSeat = flightDetail.getActualSeat();
		this.arrivalTimeLocalReferenceMinutes = flightDetail.getArrivalTimeLocalReferenceMinutes();
		this.atcDelayMinutes = flightDetail.getAtcDelayMinutes();
		this.code21E2 = flightDetail.getCode21E2();
		this.crewComingFrom = flightDetail.getCrewComingFrom();
		this.crewTypeCode = flightDetail.getCrewTypeCode();
		this.deadHeadType = flightDetail.getDeadHeadType();
		this.deicingDelayMinutes = flightDetail.getDeicingDelayMinutes();
		this.departureTimeLocalReferenceMinutes = flightDetail.getDepartureTimeLocalReferenceMinutes();
		if(flightDetail.getDutyKey()!=null)
		{
			CrewDutyKey crewDutyKey = new CrewDutyKey(flightDetail.getDutyKey().getPositionKey(),flightDetail.getDutyKey().getDutyPeriodNumber());
			crewDutyKey.setSnapshotId(snapshotId);
			this.dutyKey = crewDutyKey;
		}
		this.expansionBits = flightDetail.getExpansionBits();
		this.firstFlightInDuty = flightDetail.getFirstFlightInDuty();
		if(flightDetail.getFlightKey()!=null)
		{
			LKAFlightKey fltKey = new LKAFlightKey(flightDetail.getFlightKey().generateNonSnapshotFlightKey());
			fltKey.setSnapshotId(snapshotId);
			this.flightKey = fltKey;
		}
		this.flightOrderInSequence = flightDetail.getFlightOrderInSequence();
		this.flightPosition = flightDetail.getFlightPosition();
		this.flightType = flightDetail.getFlightType();
		this.languageRequirement = flightDetail.getLanguageRequirement();
		this.lastFlightInDuty = flightDetail.getLastFlightInDuty();
		this.legAssignmentCode = flightDetail.getLegAssignmentCode();
		this.legRemovalCode = flightDetail.getLegRemovalCode();
		this.legType = flightDetail.getLegType();
		if(flightDetail.getNextFlightKey() !=null)
		{
			LKAFlightKey nextFltKey = new LKAFlightKey(flightDetail.getNextFlightKey().generateNonSnapshotFlightKey());
			nextFltKey.setSnapshotId(snapshotId);
			this.nextFlightKey = nextFltKey;
		}
		this.oalArrivalTime = flightDetail.getOalArrivalTime();
		this.oalDepartureTime = flightDetail.getOalDepartureTime();
		if(flightDetail.getPreviousFlightKey() != null)
		{
			LKAFlightKey prevFltKey = new LKAFlightKey(flightDetail.getPreviousFlightKey().generateNonSnapshotFlightKey());
			prevFltKey.setSnapshotId(snapshotId);
			this.previousFlightKey = prevFltKey;
		}
		this.previousLegArrivalStation = flightDetail.getPreviousLegArrivalStation();
		this.rampDelayMinutes = flightDetail.getRampDelayMinutes();
		this.reportOrSurfaceLegArrivalStn = flightDetail.getReportOrSurfaceLegArrivalStn();
		this.requiredFAStaffing = flightDetail.isRequiredFAStaffing();
		this.seatSpecificData = flightDetail.getSeatSpecificData();
		this.contractualMonth = flightDetail.getContractualMonth();
	}

   public boolean isSACrew()
   {
      if (dutyKey!=null) {
         return dutyKey.isSACrew();
      }
      return false;
   }

}
