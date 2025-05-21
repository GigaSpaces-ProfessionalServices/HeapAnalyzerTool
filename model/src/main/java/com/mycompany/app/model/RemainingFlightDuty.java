package com.mycompany.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

//import com.aa.lookahead.dataobjects.legality.keys.RemainingFlightDutyKey;
//import com.aa.lookahead.utils.common.CommonUtility;
import com.gigaspaces.annotation.pojo.*;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;

//@CompoundSpaceIndexes({
//        @CompoundSpaceIndex(paths = {
//                "remainingFlightDutyKey.flightKey", "remainingFlightDutyKey.employeeNumber"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "remainingFlightDutyKey.flightKey", "remainingFlightDutyKey.employeeNumber", "remainingFlightDutyKey.crewSequenceKey"
//        })
//})

@SpaceClass(blobstoreEnabled = false)
//@MirrorTable(name = MirrorConstants.REMAINING_FLIGHT_DUTY)
public class RemainingFlightDuty implements Serializable {

    private static final long serialVersionUID = 7600000579962178976L;
//    @MirrorColumn(name = MirrorConstants.REMAINING_FLIGHT_DUTY_KEY , embedded=true)
    private RemainingFlightDutyKey remainingFlightDutyKey;
    private String employeeNumber;
//    @MirrorColumn(name = MirrorConstants.LAY_OVER_LTA, type = MirrorConstants.DATETIME2)
    private Date layOverLTA;
//    @MirrorColumn(name = MirrorConstants.LTR, type = MirrorConstants.BIGINT)
    private Long lTR;
//    @MirrorColumn(name = MirrorConstants.PROJECTED_LTR, type = MirrorConstants.BIGINT)
    private Long projectedLTR;
//    @MirrorColumn(name = MirrorConstants.CONTROL_LTR, type = MirrorConstants.BIGINT)
    private Long controlLTR;
//    @MirrorColumn(name = MirrorConstants.DTR, type = MirrorConstants.BIGINT)
    private Long dtr = null;
//    @MirrorColumn(name = MirrorConstants.PROJECTED_DTR, type = MirrorConstants.BIGINT)
    private Long projectedDTR;
//    @MirrorColumn(name = MirrorConstants.CONTROL_DTR, type = MirrorConstants.BIGINT)
    private Long controlDTR;
//    @MirrorColumn(name = MirrorConstants.EDTR, type = MirrorConstants.BIGINT)
    private Long edtr = null;
//    @MirrorColumn(name = MirrorConstants.LATEST_GMT_ARV_TIME, type = MirrorConstants.DATETIME2)
    private Date latestGMTArvTime = null;
//    @MirrorColumn(name = MirrorConstants.LATEST_GMT_DEP_TIME, type = MirrorConstants.DATETIME2)
    private Date latestGMTDepTime = null;
//    @MirrorColumn(name = MirrorConstants.LTA, type = MirrorConstants.DATETIME2)
    private Date lTA = null;
//    @MirrorColumn(name = MirrorConstants.FDP_END_TIME, type = MirrorConstants.DATETIME2)
    private Date fdpEndTime = null;
//    @MirrorColumn(name = MirrorConstants.PROJ_GMT_ARV_TIME, type = MirrorConstants.DATETIME2)
    private Date projGMTArvTime = null;
//    @MirrorColumn(name = MirrorConstants.PROJ_GMT_DEP_TIME, type = MirrorConstants.DATETIME2)
    private Date projGMTDepTime = null;
//    @MirrorColumn(name = MirrorConstants.CNTL_GMT_DEP_TIME, type = MirrorConstants.DATETIME2)
    private Date cntlGMTDepTime = null;
//    @MirrorColumn(name = MirrorConstants.CNTL_GMT_ARV_TIME, type = MirrorConstants.DATETIME2)
    private Date cntlGMTArvTime = null;
//    @MirrorColumn(name = MirrorConstants.FTR, type = MirrorConstants.BIGINT)
    private Long ftr = null;
//    @MirrorColumn(name = MirrorConstants.DUTY_TIME_REMAINING, type = MirrorConstants.BIGINT)
    private Long dutyTimeRemaining;
//    @MirrorColumn(name = MirrorConstants.DROP_DEAD_LEG_MOT, type = MirrorConstants.DATETIME2)
    private Date dropDeadLegMot;
//    @MirrorColumn(name = MirrorConstants.DROP_DEAD_LEG_EMOT, type = MirrorConstants.DATETIME2)
    private Date dropDeadLegEMOT;
//    @MirrorColumn(name = MirrorConstants.DROP_DEAD_SEQUENCE_MOT, type = MirrorConstants.DATETIME2)
    private Date dropDeadSequenceMot;
//    @MirrorColumn(name = MirrorConstants.DROP_DEAD_SEQUENCE_EMOT, type = MirrorConstants.DATETIME2)
    private Date dropDeadSequenceEMot;
//    @MirrorColumn(name = MirrorConstants.PROJ_DROP_DEAD_LEG_MOT, type = MirrorConstants.DATETIME2)
    private Date projDropDeadLegMot;
//    @MirrorColumn(name = MirrorConstants.PROJ_DROP_DEAD_LEG_EMOT, type = MirrorConstants.DATETIME2)
    private Date projdropDeadLegEMOT;
//    @MirrorColumn(name = MirrorConstants.PROJ_DROP_DEAD_SEQUENCE_MOT, type = MirrorConstants.DATETIME2)
    private Date projDropDeadSequenceMot;
//    @MirrorColumn(name = MirrorConstants.PROJ_DROP_DEAD_SEQUENCE_EMOT, type = MirrorConstants.DATETIME2)
    private Date projDropDeadSequenceEmot;
//    @MirrorColumn(name = MirrorConstants.LATEST_TAXI_OUT_TIME_IN_MINUTES, type = MirrorConstants.INT)
    private Integer latestTaxiOutTimeInMinutes;
//    @MirrorColumn(name = MirrorConstants.ARRIVAL_TIME_LAST_LEG, type = MirrorConstants.DATETIME2)
    private Date arrivalTimeOfLastLeg;
//    @MirrorColumn(name = MirrorConstants.PROJ_ARRIVAL_TIME_LAST_LEG, type = MirrorConstants.DATETIME2)
    private Date projArrivalTimeOfLastLeg;
//    @MirrorColumn(name = MirrorConstants.CONTROL_ARRIVAL_TIME_LAST_LEG, type = MirrorConstants.DATETIME2)
    private Date controlArrivalTimeOfLastLeg;
//    @MirrorColumn(name = MirrorConstants.FDP_MOT, type = MirrorConstants.DATETIME2)
    private Date fdpMOT;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_MOT, type = MirrorConstants.DATETIME2)
    private Date flightMOT;
//    @MirrorColumn(name = MirrorConstants.DUTY_START_TIME, type = MirrorConstants.DATETIME2)
    private Date dutyStartTime;
//    @MirrorColumn(name = MirrorConstants.DUTY_END_TIME, type = MirrorConstants.DATETIME2)
    private Date dutyEndTime;
//    @MirrorColumn(name = MirrorConstants.CONTROLLED_CURRENT_REST_TIME, type = MirrorConstants.INT)
    private Integer controlledCurrentRestTime;
//    @MirrorColumn(name = MirrorConstants.PROJECTED_CURRENT_REST_TIME, type = MirrorConstants.INT)
    private Integer projectedCurrentRestTime;
//    @MirrorColumn(name = MirrorConstants.LATEST_CURRENT_REST_TIME, type = MirrorConstants.INT)
    private Integer latestCurrentRestTime;
//    @MirrorColumn(name = MirrorConstants.ALLOWABLE_MAX_DUTY, type = MirrorConstants.INT)
    private Integer allowableMaxDuty;
//    @MirrorColumn(name = MirrorConstants.MINIMUM_REST_NEEDED, type = MirrorConstants.INT)
    private Integer minimumRestNeeded = 0;
//    @MirrorColumn(name = MirrorConstants.NEXT_DUTY_START_TIME, type = MirrorConstants.DATETIME2)
    private Date nextDutyStartTime;
//    @MirrorColumn(name = MirrorConstants.TRAVEL_TIME_FOR_CREW, type = MirrorConstants.INT)
    private Integer travelTimeForCrew = 0;
//    @MirrorColumn(name = MirrorConstants.DEBRIEF_MINUTES, type = MirrorConstants.INT)
    private Integer debriefMinutes = 0;
//    @MirrorColumn(name = MirrorConstants.NEXT_DAY_SIGN_IN_MINUTES, type = MirrorConstants.INT)
    private Integer nextDaySignInMinutes = 0;
//    @MirrorColumn(name = MirrorConstants.SEQUENCE_FTR, type = MirrorConstants.INT)
    private Integer sequenceFTR = 0;
//    @MirrorColumn(name = MirrorConstants.SEQUENCE_DTR, type = MirrorConstants.BIGINT)
    private Long sequenceDTR = 0L;
//    @MirrorColumn(name = MirrorConstants.MAX_DUTY_END_TIME, type = MirrorConstants.DATETIME2)
    private Date maxDutyEndTime;
//    @MirrorColumn(name = MirrorConstants.NUMBER_OF_LEGS_IN_DUTY, type = MirrorConstants.INT)
    private Integer noOfLegsInDuty = 0;
//    @MirrorColumn(name = MirrorConstants.FLYING_TIME_LEFT, type = MirrorConstants.INT)
    private Integer flyingTimeLeft = 0;
//    @MirrorColumn(name = MirrorConstants.MAX_ALLOWED_FLYING, type = MirrorConstants.INT)
    private Integer maxAllowedFlying = 0;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_SEQUENCE_DTR, type = MirrorConstants.BIGINT)
    private Long previousSequenceDTR = null;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_SEQUENCE_FTR, type = MirrorConstants.BIGINT)
    private Long previousSequenceFTR = null;
//    @MirrorColumn(name = MirrorConstants.FDP_EXTN_MINS, type = MirrorConstants.INT)
    private Integer fdpExtnMins = 0;
//    @MirrorColumn(name = MirrorConstants.FDP_MOT_GMT, type = MirrorConstants.DATETIME2)
    private Date fdpMOTGMT;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_MOT_GMT, type = MirrorConstants.DATETIME2)
    private Date flightMOTGMT;
//    @MirrorColumn(name = MirrorConstants.UPDATE_TIME, type = MirrorConstants.DATETIME2)
    private Date updateTime;
    private HashMap<String, RemainingFlightDuty> snapshots;

    private Integer minimumConnectTime = 0; //minimum connect time

    @SpaceId(autoGenerate = false)
    public RemainingFlightDutyKey getRemainingFlightDutyKey() {
        return remainingFlightDutyKey;
    }

    public RemainingFlightDuty() {
    }

    public RemainingFlightDuty(RemainingFlightDutyKey remainingFlightDutyKey) {
        this.remainingFlightDutyKey = remainingFlightDutyKey;
    }

    public void setRemainingFlightDutyKey(RemainingFlightDutyKey remainingFlightDutyKey) {
        this.remainingFlightDutyKey = remainingFlightDutyKey;
        this.employeeNumber = remainingFlightDutyKey.getEmployeeNumber();
    }

    public Date getLayOverLTA() {
        return layOverLTA;
    }

    public void setLayOverLTA(Date layOverLTA) {
        this.layOverLTA = layOverLTA;
    }

    public Long getlTR() {
        return lTR;
    }

    public void setlTR(Long lTR) {
        this.lTR = lTR;
    }

    public Long getProjectedLTR() {
        return projectedLTR;
    }

    public void setProjectedLTR(Long projectedLTR) {
        this.projectedLTR = projectedLTR;
    }

    public Long getControlLTR() {
        return controlLTR;
    }

    public void setControlLTR(Long controlLTR) {
        this.controlLTR = controlLTR;
    }

    public Long getDtr() {
        return dtr;
    }

    public void setDtr(Long dtr) {
        this.dtr = dtr;
    }

    /**
     * @return the dtr
     */
    public Long getDtr(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return dtr;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getDtr() != null) {
        return getSnapshots().get(snapshotId).getDtr();
      } else {
        return dtr;
      }
    }

    /**
     * @param dtr - the dtr to set
     */
    public void setDtr(Long dtr, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.dtr = dtr;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setDtr(dtr);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setDtr(dtr);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Long getProjectedDTR() {
        return projectedDTR;
    }

    public void setProjectedDTR(Long projectedDTR) {
        this.projectedDTR = projectedDTR;
    }

    /**
     * @return the projectedDTR
     */
    public Long getProjectedDTR(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return projectedDTR;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getProjectedDTR() != null) {
        return getSnapshots().get(snapshotId).getProjectedDTR();
      } else {
        return projectedDTR;
      }
    }

    /**
     * @param projectedDTR - the projectedDTR to set
     */
    public void setProjectedDTR(Long projectedDTR, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.projectedDTR = projectedDTR;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setProjectedDTR(projectedDTR);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setProjectedDTR(projectedDTR);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Long getControlDTR() {
        return controlDTR;
    }

    public void setControlDTR(Long controlDTR) {
        this.controlDTR = controlDTR;
    }

    /**
     * @return the controlDTR
     */
    public Long getControlDTR(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return controlDTR;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getControlDTR() != null) {
        return getSnapshots().get(snapshotId).getControlDTR();
      } else {
        return controlDTR;
      }
    }

    /**
     * @param controlDTR - the controlDTR to set
     */
    public void setControlDTR(Long controlDTR, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.controlDTR = controlDTR;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setControlDTR(controlDTR);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setControlDTR(controlDTR);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Long getEdtr() {
        return edtr;
    }

    public void setEdtr(Long edtr) {
        this.edtr = edtr;
    }

    public Date getLatestGMTArvTime() {
        return latestGMTArvTime;
    }

    public void setLatestGMTArvTime(Date latestGMTArvTime) {
        this.latestGMTArvTime = latestGMTArvTime;
    }

    /**
     * @return the latestGMTArvTime
     */
    public Date getLatestGMTArvTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return latestGMTArvTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getLatestGMTArvTime() != null) {
        return getSnapshots().get(snapshotId).getLatestGMTArvTime();
      } else {
        return latestGMTArvTime;
      }
    }

    /**
     * @param latestGMTArvTime - the latestGMTArvTime to set
     */
    public void setLatestGMTArvTime(Date latestGMTArvTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.latestGMTArvTime = latestGMTArvTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setLatestGMTArvTime(latestGMTArvTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setLatestGMTArvTime(latestGMTArvTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Date getLatestGMTDepTime() {
        return latestGMTDepTime;
    }

    public void setLatestGMTDepTime(Date latestGMTDepTime) {
        this.latestGMTDepTime = latestGMTDepTime;
    }

    /**
     * @return the latestGMTDepTime
     */
    public Date getLatestGMTDepTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return latestGMTDepTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getLatestGMTDepTime() != null) {
        return getSnapshots().get(snapshotId).getLatestGMTDepTime();
      } else {
        return latestGMTDepTime;
      }
    }

    /**
     * @param latestGMTDepTime - the latestGMTDepTime to set
     */
    public void setLatestGMTDepTime(Date latestGMTDepTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.latestGMTDepTime = latestGMTDepTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setLatestGMTDepTime(latestGMTDepTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setLatestGMTDepTime(latestGMTDepTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Date getlTA() {
        return lTA;
    }

    public void setlTA(Date lTA) {
        this.lTA = lTA;
    }

    public Date getFdpEndTime() {
        return fdpEndTime;
    }

    public void setFdpEndTime(Date fdpEndTime) {
        this.fdpEndTime = fdpEndTime;
    }
   
    /**
     * 
     * @return the fdpEndTime
     */
    public Date getFdpEndTime(String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            return fdpEndTime;
//          }
          if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
              && getSnapshots().get(snapshotId).getFdpEndTime() != null) {
            return getSnapshots().get(snapshotId).getFdpEndTime();
          } else {
            return fdpEndTime;
          }
    }
    
    /**
     * set the fdpEndTime to snapshot
     */
    
    public void setFdpEndTime(Date fdpEndTime,String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            this.fdpEndTime = fdpEndTime;
//          } else {
//            RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//            if (snapRmt != null) {
//                snapRmt.setFdpEndTime(fdpEndTime);
//            } else {
//                RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//                newSnapShotRmt.setFdpEndTime(fdpEndTime);
//                getSnapshots().put(snapshotId, newSnapShotRmt);
//            }
//          }
    }

    public Date getProjGMTArvTime() {
        return projGMTArvTime;
    }

    public void setProjGMTArvTime(Date projGMTArvTime) {
        this.projGMTArvTime = projGMTArvTime;
    }

    /**
     * @return the projGMTArvTime
     */
    public Date getProjGMTArvTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return projGMTArvTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getProjGMTArvTime() != null) {
        return getSnapshots().get(snapshotId).getProjGMTArvTime();
      } else {
        return projGMTArvTime;
      }
    }

    /**
     * @param projGMTArvTime - the projGMTArvTime to set
     */
    public void setProjGMTArvTime(Date projGMTArvTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.projGMTArvTime = projGMTArvTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setProjGMTArvTime(projGMTArvTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setProjGMTArvTime(projGMTArvTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Date getProjGMTDepTime() {
        return projGMTDepTime;
    }

    public void setProjGMTDepTime(Date projGMTDepTime) {
        this.projGMTDepTime = projGMTDepTime;
    }

    /**
     * @return the projGMTDepTime
     */
    public Date getProjGMTDepTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return projGMTDepTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getProjGMTDepTime() != null) {
        return getSnapshots().get(snapshotId).getProjGMTDepTime();
      } else {
        return projGMTDepTime;
      }
    }

    /**
     * @param projGMTDepTime - the projGMTDepTime to set
     */
    public void setProjGMTDepTime(Date projGMTDepTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.projGMTDepTime = projGMTDepTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setProjGMTDepTime(projGMTDepTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setProjGMTDepTime(projGMTDepTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Date getCntlGMTDepTime() {
        return cntlGMTDepTime;
    }

    public void setCntlGMTDepTime(Date cntlGMTDepTime) {
        this.cntlGMTDepTime = cntlGMTDepTime;
    }

    /**
     * @return the cntlGMTDepTime
     */
    public Date getCntlGMTDepTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return cntlGMTDepTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getCntlGMTDepTime() != null) {
        return getSnapshots().get(snapshotId).getCntlGMTDepTime();
      } else {
        return cntlGMTDepTime;
      }
    }

    /**
     * @param cntlGMTDepTime - the cntlGMTDepTime to set
     */
    public void setCntlGMTDepTime(Date cntlGMTDepTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.cntlGMTDepTime = cntlGMTDepTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setCntlGMTDepTime(cntlGMTDepTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setCntlGMTDepTime(cntlGMTDepTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Date getCntlGMTArvTime() {
        return cntlGMTArvTime;
    }

    public void setCntlGMTArvTime(Date cntlGMTArvTime) {
        this.cntlGMTArvTime = cntlGMTArvTime;
    }

    /**
     * @return the cntlGMTArvTime
     */
    public Date getCntlGMTArvTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return cntlGMTArvTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getCntlGMTArvTime() != null) {
        return getSnapshots().get(snapshotId).getCntlGMTArvTime();
      } else {
        return cntlGMTArvTime;
      }
    }

    /**
     * @param cntlGMTArvTime - the cntlGMTArvTime to set
     */
    public void setCntlGMTArvTime(Date cntlGMTArvTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.cntlGMTArvTime = cntlGMTArvTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setCntlGMTArvTime(cntlGMTArvTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setCntlGMTArvTime(cntlGMTArvTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Long getFtr() {
        return ftr;
    }

    public void setFtr(Long ftr) {
        this.ftr = ftr;
    }

    public Long getFtr(String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            return ftr;
//          }
          if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
              && getSnapshots().get(snapshotId).getFtr() != null) {
            return getSnapshots().get(snapshotId).getFtr();
          } else {
            return ftr;
          }
    }

    public void setFtr(Long ftr, String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            this.ftr = ftr;
//          } else {
//            RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//            if (snapRmt != null) {
//                snapRmt.setFtr(ftr);
//            } else {
//                RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//                newSnapShotRmt.setFtr(ftr);
//                getSnapshots().put(snapshotId, newSnapShotRmt);
//            }
//          }
    }
    
    public Long getDutyTimeRemaining() {
        return dutyTimeRemaining;
    }

    public void setDutyTimeRemaining(Long dutyTimeRemaining) {
        this.dutyTimeRemaining = dutyTimeRemaining;
    }

    public Date getDropDeadLegMot() {
        return dropDeadLegMot;
    }

    public void setDropDeadLegMot(Date dropDeadLegMot) {
        this.dropDeadLegMot = dropDeadLegMot;
    }

    public Date getDropDeadLegEMOT() {
        return dropDeadLegEMOT;
    }

    public void setDropDeadLegEMOT(Date dropDeadLegEMOT) {
        this.dropDeadLegEMOT = dropDeadLegEMOT;
    }

    public Date getDropDeadSequenceMot() {
        return dropDeadSequenceMot;
    }

    public void setDropDeadSequenceMot(Date dropDeadSequenceMot) {
        this.dropDeadSequenceMot = dropDeadSequenceMot;
    }

    public Date getDropDeadSequenceEMot() {
        return dropDeadSequenceEMot;
    }

    public void setDropDeadSequenceEMot(Date dropDeadSequenceEMot) {
        this.dropDeadSequenceEMot = dropDeadSequenceEMot;
    }

    public Date getProjDropDeadLegMot() {
        return projDropDeadLegMot;
    }

    public void setProjDropDeadLegMot(Date projDropDeadLegMot) {
        this.projDropDeadLegMot = projDropDeadLegMot;
    }

    public Date getProjdropDeadLegEMOT() {
        return projdropDeadLegEMOT;
    }

    public void setProjdropDeadLegEMOT(Date projdropDeadLegEMOT) {
        this.projdropDeadLegEMOT = projdropDeadLegEMOT;
    }

    public Date getProjDropDeadSequenceMot() {
        return projDropDeadSequenceMot;
    }

    public void setProjDropDeadSequenceMot(Date projDropDeadSequenceMot) {
        this.projDropDeadSequenceMot = projDropDeadSequenceMot;
    }

    public Date getProjDropDeadSequenceEmot() {
        return projDropDeadSequenceEmot;
    }

    public void setProjDropDeadSequenceEmot(Date projDropDeadSequenceEmot) {
        this.projDropDeadSequenceEmot = projDropDeadSequenceEmot;
    }

    public Integer getLatestTaxiOutTimeInMinutes() {
        return latestTaxiOutTimeInMinutes;
    }

    public void setLatestTaxiOutTimeInMinutes(Integer latestTaxiOutTimeInMinutes) {
        this.latestTaxiOutTimeInMinutes = latestTaxiOutTimeInMinutes;
    }

    public Date getArrivalTimeOfLastLeg() {
        return arrivalTimeOfLastLeg;
    }

    public void setArrivalTimeOfLastLeg(Date arrivalTimeOfLastLeg) {
        this.arrivalTimeOfLastLeg = arrivalTimeOfLastLeg;
    }

    public Date getProjArrivalTimeOfLastLeg() {
        return projArrivalTimeOfLastLeg;
    }

    public void setProjArrivalTimeOfLastLeg(Date projArrivalTimeOfLastLeg) {
        this.projArrivalTimeOfLastLeg = projArrivalTimeOfLastLeg;
    }

    public Date getFdpMOT() {
        return fdpMOT;
    }

    public void setFdpMOT(Date fdpMOT) {
        this.fdpMOT = fdpMOT;
    }

    public Date getFlightMOT() {
        return flightMOT;
    }

    public void setFlightMOT(Date flightMOT) {
        this.flightMOT = flightMOT;
    }

    @SpaceRouting
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getDutyStartTime() {
        return dutyStartTime;
    }

    public void setDutyStartTime(Date dutyStartTime) {
        this.dutyStartTime = dutyStartTime;
    }

    public Date getDutyEndTime() {
        return dutyEndTime;
    }

    public void setDutyEndTime(Date dutyEndTime) {
        this.dutyEndTime = dutyEndTime;
    }

    public Integer getAllowableMaxDuty() {
        return allowableMaxDuty;
    }

    public void setAllowableMaxDuty(Integer allowableMaxDuty) {
        this.allowableMaxDuty = allowableMaxDuty;
    }

    public Integer getMinimumRestNeeded() {
        return minimumRestNeeded;
    }

    public void setMinimumRestNeeded(Integer minimumRestNeeded) {
        this.minimumRestNeeded = minimumRestNeeded;
    }

    public Integer getControlledCurrentRestTime() {
        return controlledCurrentRestTime;
    }

    public void setControlledCurrentRestTime(Integer controlledCurrentRestTime) {
        this.controlledCurrentRestTime = controlledCurrentRestTime;
    }

    /**
     * @return the controlledCurrentRestTime
     */
    public Integer getControlledCurrentRestTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return controlledCurrentRestTime;
//      }
      if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getControlledCurrentRestTime() != null) {
        return getSnapshots().get(snapshotId).getControlledCurrentRestTime();
      } else {
        return controlledCurrentRestTime;
      }
    }

    /**
     * @param controlledCurrentRestTime - the controlledCurrentRestTime to set
     */
    public void setControlledCurrentRestTime(Integer controlledCurrentRestTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.controlledCurrentRestTime = controlledCurrentRestTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setControlledCurrentRestTime(controlledCurrentRestTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setControlledCurrentRestTime(controlledCurrentRestTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Integer getProjectedCurrentRestTime() {
        return projectedCurrentRestTime;
    }

    public void setProjectedCurrentRestTime(Integer projectedCurrentRestTime) {
        this.projectedCurrentRestTime = projectedCurrentRestTime;
    }

    /**
     * @return the projectedCurrentRestTime
     */
    public Integer getProjectedCurrentRestTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return projectedCurrentRestTime;
//      }
      if (getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getProjectedCurrentRestTime() != null) {
        return getSnapshots().get(snapshotId).getProjectedCurrentRestTime();
      } else {
        return projectedCurrentRestTime;
      }
    }

    /**
     * @param projectedCurrentRestTime - the projectedCurrentRestTime to set
     */
    public void setProjectedCurrentRestTime(Integer projectedCurrentRestTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.projectedCurrentRestTime = projectedCurrentRestTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setProjectedCurrentRestTime(projectedCurrentRestTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setProjectedCurrentRestTime(projectedCurrentRestTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Integer getLatestCurrentRestTime() {
        return latestCurrentRestTime;
    }

    public void setLatestCurrentRestTime(Integer latestCurrentRestTime) {
        this.latestCurrentRestTime = latestCurrentRestTime;
    }

    /**
     * @return the latestCurrentRestTime
     */
    public Integer getLatestCurrentRestTime(String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        return latestCurrentRestTime;
//      }
      if (getSnapshots().get(snapshotId) != null
          && getSnapshots().get(snapshotId).getLatestCurrentRestTime() != null) {
        return getSnapshots().get(snapshotId).getLatestCurrentRestTime();
      } else {
        return latestCurrentRestTime;
      }
    }

    /**
     * @param latestCurrentRestTime - the latestCurrentRestTime to set
     */
    public void setLatestCurrentRestTime(Integer latestCurrentRestTime, String snapshotId) {
//      if (CommonUtility.isMasterSnapshot(snapshotId)) {
//        this.latestCurrentRestTime = latestCurrentRestTime;
//      } else {
//        RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//        if (snapRmt != null) {
//            snapRmt.setLatestCurrentRestTime(latestCurrentRestTime);
//        } else {
//            RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//            newSnapShotRmt.setLatestCurrentRestTime(latestCurrentRestTime);
//            getSnapshots().put(snapshotId, newSnapShotRmt);
//        }
//      }
    }

    public Date getNextDutyStartTime() {
        return nextDutyStartTime;
    }

    public void setNextDutyStartTime(Date nextDutyStartTime) {
        this.nextDutyStartTime = nextDutyStartTime;
    }

    public Integer getTravelTimeForCrew() {
        return travelTimeForCrew;
    }

    public void setTravelTimeForCrew(Integer travelTimeForCrew) {
        this.travelTimeForCrew = travelTimeForCrew;
    }

    public Integer getDebriefMinutes() {
        return debriefMinutes;
    }

    public void setDebriefMinutes(Integer debriefMinutes) {
        this.debriefMinutes = debriefMinutes;
    }

    public Integer getNextDaySignInMinutes() {
        return nextDaySignInMinutes;
    }

    public void setNextDaySignInMinutes(Integer nextDaySignInMinutes) {
        this.nextDaySignInMinutes = nextDaySignInMinutes;
    }

    public Integer getSequenceFTR() {
        return sequenceFTR;
    }

    public void setSequenceFTR(Integer sequenceFTR) {
        this.sequenceFTR = sequenceFTR;
    }

    public Long getSequenceDTR() {
        return sequenceDTR;
    }

    public void setSequenceDTR(Long sequenceDTR) {
        this.sequenceDTR = sequenceDTR;
    }

    /**
     * @return the sequenceDTR
     */
    public Long getSequenceDTR(String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            return sequenceDTR;
//        }
        if (getSnapshots() != null && getSnapshots().get(snapshotId) != null
                && getSnapshots().get(snapshotId).getSequenceDTR() != null) {
            return getSnapshots().get(snapshotId).getSequenceDTR();
        } else {
            return sequenceDTR;
        }
    }

    /**
     * @param sequenceDTR - the sequenceDTR to set
     */
    public void setSequenceDTR(Long sequenceDTR, String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            this.sequenceDTR = sequenceDTR;
//        } else {
//            RemainingFlightDuty snapRmt = getSnapshots().get(snapshotId);
//            if (snapRmt != null) {
//                snapRmt.setSequenceDTR(sequenceDTR);
//            } else {
//                RemainingFlightDuty newSnapShotRmt = new RemainingFlightDuty();
//                newSnapShotRmt.setSequenceDTR(sequenceDTR);
//                getSnapshots().put(snapshotId, newSnapShotRmt);
//            }
//        }
    }

    public Date getMaxDutyEndTime() {
        return maxDutyEndTime;
    }

    public void setMaxDutyEndTime(Date maxDutyEndTime) {
        this.maxDutyEndTime = maxDutyEndTime;
    }

    public Integer getNoOfLegsInDuty() {
        return noOfLegsInDuty;
    }

    public void setNoOfLegsInDuty(Integer noOfLegsInDuty) {
        this.noOfLegsInDuty = noOfLegsInDuty;
    }

    public Integer getFlyingTimeLeft() {
        return flyingTimeLeft;
    }

    public void setFlyingTimeLeft(Integer flyingTimeLeft) {
        this.flyingTimeLeft = flyingTimeLeft;
    }

    public Integer getMaxAllowedFlying() {
        return maxAllowedFlying;
    }

    public void setMaxAllowedFlying(Integer maxAllowedFlying) {
        this.maxAllowedFlying = maxAllowedFlying;
    }

    public Date getControlArrivalTimeOfLastLeg() {
        return controlArrivalTimeOfLastLeg;
    }

    public void setControlArrivalTimeOfLastLeg(Date controlArrivalTimeOfLastLeg) {
        this.controlArrivalTimeOfLastLeg = controlArrivalTimeOfLastLeg;
    }

    public Long getPreviousSequenceDTR() {
        return previousSequenceDTR;
    }

    public void setPreviousSequenceDTR(Long previousSequenceDTR) {
        this.previousSequenceDTR = previousSequenceDTR;
    }

    public Long getPreviousSequenceFTR() {
        return previousSequenceFTR;
    }

    public void setPreviousSequenceFTR(Long previousSequenceFTR) {
        this.previousSequenceFTR = previousSequenceFTR;
    }

    public Integer getFdpExtnMins() {
        return fdpExtnMins;
    }

    public void setFdpExtnMins(Integer fdpExtnMins) {
        this.fdpExtnMins = fdpExtnMins;
    }
    
    public Date getFdpMOTGMT() {
        return fdpMOTGMT;
    }

    public void setFdpMOTGMT(Date fdpMOTGMT) {
        this.fdpMOTGMT = fdpMOTGMT;
    }

    public Date getFlightMOTGMT() {
        return flightMOTGMT;
    }

    public void setFlightMOTGMT(Date flightMOTGMT) {
        this.flightMOTGMT = flightMOTGMT;
    }

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date fosUpdateTime) {
		this.updateTime = fosUpdateTime;
	}

    public Integer getMinimumConnectTime() {
        return minimumConnectTime;
    }

    public void setMinimumConnectTime(Integer minimumConnectTime) {
        this.minimumConnectTime = minimumConnectTime;
    }

	/**
     * Deep Copy Constructor
     *
     * @param remainingFlightDuty
     * @param snapshotId
     */
    public RemainingFlightDuty(RemainingFlightDuty remainingFlightDuty, String snapshotId) {
        this.remainingFlightDutyKey = new RemainingFlightDutyKey(remainingFlightDuty.getRemainingFlightDutyKey(), snapshotId);
        this.employeeNumber = remainingFlightDuty.getEmployeeNumber();
        this.layOverLTA = remainingFlightDuty.getLayOverLTA();
        this.lTR = remainingFlightDuty.getlTR();
        this.projectedLTR = remainingFlightDuty.getProjectedLTR();
        this.controlLTR = remainingFlightDuty.getControlLTR();
        this.dtr = remainingFlightDuty.getDtr();
        this.projectedDTR = remainingFlightDuty.getProjectedDTR();
        this.controlDTR = remainingFlightDuty.getControlDTR();
        this.edtr = remainingFlightDuty.getEdtr();
        this.latestGMTArvTime = remainingFlightDuty.getLatestGMTArvTime();
        this.latestGMTDepTime = remainingFlightDuty.getLatestGMTDepTime();
        this.lTA = remainingFlightDuty.getlTA();
        this.fdpEndTime = remainingFlightDuty.getFdpEndTime();
        this.projGMTArvTime = remainingFlightDuty.getProjGMTArvTime();
        this.projGMTDepTime = remainingFlightDuty.getProjGMTDepTime();
        this.cntlGMTDepTime = remainingFlightDuty.getCntlGMTDepTime();
        this.cntlGMTArvTime = remainingFlightDuty.getCntlGMTArvTime();
        this.ftr = remainingFlightDuty.getFtr();
        this.dutyTimeRemaining = remainingFlightDuty.getDutyTimeRemaining();
        this.dropDeadLegMot = remainingFlightDuty.getDropDeadLegMot();
        this.dropDeadLegEMOT = remainingFlightDuty.getDropDeadLegEMOT();
        this.dropDeadSequenceMot = remainingFlightDuty.getDropDeadSequenceMot();
        this.dropDeadSequenceEMot = remainingFlightDuty.getDropDeadSequenceEMot();
        this.projDropDeadLegMot = remainingFlightDuty.getProjDropDeadLegMot();
        this.projdropDeadLegEMOT = remainingFlightDuty.getProjdropDeadLegEMOT();
        this.projDropDeadSequenceMot = remainingFlightDuty.getProjDropDeadSequenceMot();
        this.projDropDeadSequenceEmot = remainingFlightDuty.getProjDropDeadSequenceEmot();
        this.latestTaxiOutTimeInMinutes = remainingFlightDuty.getLatestTaxiOutTimeInMinutes();
        this.arrivalTimeOfLastLeg = remainingFlightDuty.getArrivalTimeOfLastLeg();
        this.projArrivalTimeOfLastLeg = remainingFlightDuty.getProjArrivalTimeOfLastLeg();
        this.controlArrivalTimeOfLastLeg = remainingFlightDuty.getControlArrivalTimeOfLastLeg();
        this.fdpMOT = remainingFlightDuty.getFdpMOT();
        this.flightMOT = remainingFlightDuty.getFlightMOT();
        this.dutyStartTime = remainingFlightDuty.getDutyStartTime();
        this.dutyEndTime = remainingFlightDuty.getDutyEndTime();
        this.controlledCurrentRestTime = remainingFlightDuty.getControlledCurrentRestTime();
        this.projectedCurrentRestTime = remainingFlightDuty.getProjectedCurrentRestTime();
        this.latestCurrentRestTime = remainingFlightDuty.getLatestCurrentRestTime();
        this.allowableMaxDuty = remainingFlightDuty.getAllowableMaxDuty();
        this.minimumRestNeeded = remainingFlightDuty.getMinimumRestNeeded();
        this.nextDutyStartTime = remainingFlightDuty.getNextDutyStartTime();
        this.travelTimeForCrew = remainingFlightDuty.getTravelTimeForCrew();
        this.debriefMinutes = remainingFlightDuty.getDebriefMinutes();
        this.nextDaySignInMinutes = remainingFlightDuty.getNextDaySignInMinutes();
        this.sequenceFTR = remainingFlightDuty.getSequenceFTR();
        this.sequenceDTR = remainingFlightDuty.getSequenceDTR();
        this.maxDutyEndTime = remainingFlightDuty.getMaxDutyEndTime();
        this.noOfLegsInDuty = remainingFlightDuty.getNoOfLegsInDuty();
        this.flyingTimeLeft = remainingFlightDuty.getFlyingTimeLeft();
        this.maxAllowedFlying = remainingFlightDuty.getMaxAllowedFlying();
        this.previousSequenceDTR = remainingFlightDuty.getPreviousSequenceDTR();
        this.previousSequenceFTR = remainingFlightDuty.getPreviousSequenceFTR();
        this.fdpExtnMins = remainingFlightDuty.getFdpExtnMins();
        this.fdpMOTGMT = remainingFlightDuty.getFdpMOTGMT();
        this.flightMOTGMT = remainingFlightDuty.getFlightMOTGMT();
        this.minimumConnectTime = remainingFlightDuty.getMinimumConnectTime();
    }

    /**
     * @return the snapshots
     */
    public HashMap<String, RemainingFlightDuty> getSnapshots() {
        if(snapshots == null){
            snapshots= new HashMap<>();
        }
        return snapshots;
    }

    /**
     * @param snapshots the snapshots to set
     */
    public void setSnapshots(HashMap<String, RemainingFlightDuty> snapshots) {
        this.snapshots = snapshots;
    }

    @Override
    public String toString() {
        return "RemainingFlightDuty [remainingFlightDutyKey=" + remainingFlightDutyKey + ", employeeNumber="
                + employeeNumber + ", layOverLTA=" + layOverLTA + ", lTR=" + lTR + ", projectedLTR=" + projectedLTR
                + ", controlLTR=" + controlLTR + ", dtr=" + dtr + ", projectedDTR=" + projectedDTR + ", controlDTR="
                + controlDTR + ", edtr=" + edtr + ", latestGMTArvTime=" + latestGMTArvTime + ", latestGMTDepTime="
                + latestGMTDepTime + ", lTA=" + lTA + ", fdpEndTime=" + fdpEndTime + ", projGMTArvTime="
                + projGMTArvTime + ", projGMTDepTime=" + projGMTDepTime + ", cntlGMTDepTime=" + cntlGMTDepTime
                + ", cntlGMTArvTime=" + cntlGMTArvTime + ", ftr=" + ftr + ", dutyTimeRemaining=" + dutyTimeRemaining
                + ", dropDeadLegMot=" + dropDeadLegMot + ", dropDeadLegEMOT=" + dropDeadLegEMOT
                + ", dropDeadSequenceMot=" + dropDeadSequenceMot + ", dropDeadSequenceEMot=" + dropDeadSequenceEMot
                + ", projDropDeadLegMot=" + projDropDeadLegMot + ", projdropDeadLegEMOT=" + projdropDeadLegEMOT
                + ", projDropDeadSequenceMot=" + projDropDeadSequenceMot + ", projDropDeadSequenceEmot="
                + projDropDeadSequenceEmot + ", latestTaxiOutTimeInMinutes=" + latestTaxiOutTimeInMinutes
                + ", arrivalTimeOfLastLeg=" + arrivalTimeOfLastLeg + ", projArrivalTimeOfLastLeg="
                + projArrivalTimeOfLastLeg + ", controlArrivalTimeOfLastLeg=" + controlArrivalTimeOfLastLeg
                + ", fdpMOT=" + fdpMOT + ", flightMOT=" + flightMOT + ", dutyStartTime=" + dutyStartTime
                + ", dutyEndTime=" + dutyEndTime + ", controlledCurrentRestTime=" + controlledCurrentRestTime
                + ", projectedCurrentRestTime=" + projectedCurrentRestTime + ", latestCurrentRestTime="
                + latestCurrentRestTime + ", allowableMaxDuty=" + allowableMaxDuty + ", minimumRestNeeded="
                + minimumRestNeeded + ", nextDutyStartTime=" + nextDutyStartTime + ", travelTimeForCrew="
                + travelTimeForCrew + ", debriefMinutes=" + debriefMinutes + ", nextDaySignInMinutes="
                + nextDaySignInMinutes + ", sequenceFTR=" + sequenceFTR + ", sequenceDTR=" + sequenceDTR
                + ", maxDutyEndTime=" + maxDutyEndTime + ", noOfLegsInDuty=" + noOfLegsInDuty + ", flyingTimeLeft="
                + flyingTimeLeft + ", maxAllowedFlying=" + maxAllowedFlying + ", previousSequenceDTR="
                + previousSequenceDTR + ", previousSequenceFTR=" + previousSequenceFTR + ", fdpExtnMins=" + fdpExtnMins
                + "]";
    }
}
