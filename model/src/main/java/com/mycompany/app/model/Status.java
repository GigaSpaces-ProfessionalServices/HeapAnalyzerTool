package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.FlightCacheObject;
//import com.aa.lookahead.dataobjects.IReplicableForSnapshot;
//import com.aa.lookahead.dataobjects.LKAFlightKey;
//import com.aa.lookahead.dataobjects.event.enums.ArrivalStatus;
//import com.aa.lookahead.dataobjects.event.enums.DepartureStatus;
//import com.aa.lookahead.dataobjects.event.enums.FlightReleaseStatus;
//import com.aa.lookahead.dataobjects.event.enums.LegStatus;
//import com.aa.lookahead.utils.common.CommonUtility;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;
import com.gigaspaces.annotation.pojo.CompoundSpaceIndex;
import com.gigaspaces.annotation.pojo.CompoundSpaceIndexes;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.HashMap;

//@CompoundSpaceIndexes({ @CompoundSpaceIndex(paths = { "flightKey.departureleStation", "flightKey.snapshotId", "arrivalStation" }) })

//@MirrorTable(name = MirrorConstants.FLIGHT_STATUS)
//public class Status extends FlightCacheObject implements IReplicableForSnapshot {
@SpaceClass(blobstoreEnabled = false)
public class Status {
    private String id;
//    @MirrorColumn(name = MirrorConstants.ARRIVAL_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String arrivalStatus;
//    @MirrorColumn(name = MirrorConstants.ARRIVAL_STATUS_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.DATETIME2_PRECISION)
    private Date arrivalStatus_timestamp;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_ARRIVAL_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String previousArrivalStatus;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_ARRIVAL_STATUS_TIMESTAMP, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private Date previousArrivalStatus_timestamp;
//    @MirrorColumn(name = MirrorConstants.DEPARTURE_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String departureStatus;
//    @MirrorColumn(name = MirrorConstants.DEPARTURE_STATUS_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.DATETIME2_PRECISION)
    private Date departureStatus_timestamp;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_DEPARTURE_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String previousDepartureStatus;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_DEPARTURE_STATUS_TIMESTAMP, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private Date previousDepartureStatus_timestamp;

//    @MirrorColumn(name = MirrorConstants.LEG_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String legStatus;
//    @MirrorColumn(name = MirrorConstants.LEG_STATUS_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.DATETIME2_PRECISION)
    private Date legStatus_timestamp;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_LEG_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String previousLegStatus;
//    @MirrorColumn(name = MirrorConstants.PREVIOUS_LEG_STATUS_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.NVARCHAR_PRECISION)
    private Date previousLegStatus_timestamp;
//    @MirrorColumn(name = MirrorConstants.CANCELLED_REASON, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String cancelledReason; // If flight was cancelled, this lists reason
//    @MirrorColumn(name = MirrorConstants.CANCELLED_CODE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String cancelledCode; // If flight was cancelled, this code is reason why

//    @MirrorColumn(name = MirrorConstants.FLIGHT_RELEASE_STATUS, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String flightReleaseStatus;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_RELEASE_STATUS_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.DATETIME2_PRECISION)
    private Date flightReleaseStatus_timestamp;

//    @MirrorColumn(name = MirrorConstants.STUBBED_FLIGHT_NUMBER, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private String stubbedFlightNumber;
//    @MirrorColumn(name = MirrorConstants.STUBBED_FLIGHT_NUMBER_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.DATETIME2_PRECISION)
    private Date stubbedFlightNumber_timestamp;

//    @MirrorColumn(name = MirrorConstants.REASON_CODE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_5)
    private String reasonCode;
//    @MirrorColumn(name = MirrorConstants.REASON_DESCRIPTION, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_500)
    private String reasonDescription;

//    @MirrorColumn(name = MirrorConstants.NEXT_LEG_RECOVERY, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_450)
    private LKAFlightKey next_leg_recovery;

//    @MirrorColumn(name = MirrorConstants.PREV_LEG_DIV, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_450)
    private LKAFlightKey prev_leg_div;
//    @MirrorColumn(name = MirrorConstants.CREATED, type = MirrorConstants.BIT)
    private boolean created;
//    @MirrorColumn(name = MirrorConstants.THRU_FLIGHT, type = MirrorConstants.BIT)
    private boolean thruFlight;
//    @MirrorColumn(name = MirrorConstants.GROUND_INTERRUPTED, type = MirrorConstants.BIT)
    private boolean groundInterrupted;
//    @MirrorColumn(name = MirrorConstants.DELAY_REASON_CODES, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_5)
    private String delayReasonCodes;
//    @MirrorColumn(name = MirrorConstants.DELAY_REASON_CODES_TIMESTAMP, type = MirrorConstants.DATETIME2, precision = MirrorConstants.NVARCHAR_PRECISION_5)
    private Date delayReasonCodes_timestamp;
    private Boolean soarFlight;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_PLAN_RELEASE_COUNT, type = MirrorConstants.INT)
    private Integer flightPlanReleaseCount;


    private static final long serialVersionUID = 6197280715130044391L;

    public Status() {
    }

//    public Status(LKAFlightKey flightKey) {
//        super(flightKey);
//    }

    /**
     * Deep Clone Constructor
     *
     * @param status
     */
//    public Status(Status status) {
//        super(status);
//
//        if (status == null)
//            return;
//
//        this.arrivalStatus = status.getArrivalStatus();
//        this.arrivalStatus_timestamp = status.getArrivalStatus_timestamp();
//        this.previousArrivalStatus = status.getPreviousArrivalStatus();
//
//        this.departureStatus = status.getDepartureStatus();
//        this.departureStatus_timestamp = status.getDepartureStatus_timestamp();
//        this.previousDepartureStatus = status.getPreviousDepartureStatus();
//
//        this.legStatus = status.getLegStatus();
//        this.legStatus_timestamp = status.getLegStatus_timestamp();
//        this.previousLegStatus = status.getPreviousLegStatus();
//        this.cancelledReason = status.getCancelledReason(); // If flight was cancelled, this lists reason
//        this.cancelledCode = status.getCancelledCode(); // If flight was cancelled, this code is reason why
//        this.flightReleaseStatus = status.getFlightReleaseStatus();
//        this.flightReleaseStatus_timestamp = status.getFlightReleaseStatus_timestamp();
//
//        this.stubbedFlightNumber = status.getStubbedFlightNumber();
//        this.stubbedFlightNumber_timestamp = status.getStubbedFlightNumber_timestamp();
//        this.reasonCode = status.reasonCode;
//        this.reasonDescription = status.reasonDescription;
//    }
//
//    @Override
//    public String toString() {
//        return "Status [" + (arrivalStatus != null ? "arrivalStatus=" + arrivalStatus + ", " : "")
//                + (previousArrivalStatus != null ? "previousArrivalStatus=" + previousArrivalStatus + ", " : "")
//                + (departureStatus != null ? "departureStatus=" + departureStatus + ", " : "")
//                + (previousDepartureStatus != null ? "previousDepartureStatus=" + previousDepartureStatus + ", " : "") + (legStatus != null ? "legStatus=" + legStatus + ", " : "")
//                + (previousLegStatus != null ? "previousLegStatus=" + previousLegStatus + ", " : "") + (cancelledReason != null ? "cancelledReason=" + cancelledReason + ", " : "")
//                + (cancelledCode != null ? "cancelledCode=" + cancelledCode + ", " : "") + (flightReleaseStatus != null ? "flightReleaseStatus=" + flightReleaseStatus + ", " : "")
//                + (stubbedFlightNumber != null ? "stubbedFlightNumber=" + stubbedFlightNumber + ", " : "") + (reasonCode != null ? "reasonCode=" + reasonCode + ", " : "")
//                + (soarFlight != null ? "soarFlight=" + soarFlight + ", " : "")
//                + (reasonDescription != null ? "reasonDescription=" + reasonDescription + ", " : "") + (flightKey != null ? "flightKey=" + flightKey : "") +"]";
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((arrivalStatus == null) ? 0 : arrivalStatus.hashCode());
        result = prime * result + ((arrivalStatus_timestamp == null) ? 0 : arrivalStatus_timestamp.hashCode());
        result = prime * result + ((cancelledCode == null) ? 0 : cancelledCode.hashCode());
        result = prime * result + ((cancelledReason == null) ? 0 : cancelledReason.hashCode());
        result = prime * result + ((departureStatus == null) ? 0 : departureStatus.hashCode());
        result = prime * result + ((departureStatus_timestamp == null) ? 0 : departureStatus_timestamp.hashCode());
        result = prime * result + ((flightReleaseStatus == null) ? 0 : flightReleaseStatus.hashCode());
        result = prime * result + ((flightReleaseStatus_timestamp == null) ? 0 : flightReleaseStatus_timestamp.hashCode());
        result = prime * result + ((legStatus == null) ? 0 : legStatus.hashCode());
        result = prime * result + ((legStatus_timestamp == null) ? 0 : legStatus_timestamp.hashCode());
        result = prime * result + ((previousArrivalStatus == null) ? 0 : previousArrivalStatus.hashCode());
        result = prime * result + ((previousDepartureStatus == null) ? 0 : previousDepartureStatus.hashCode());
        result = prime * result + ((stubbedFlightNumber == null) ? 0 : stubbedFlightNumber.hashCode());
        result = prime * result + ((stubbedFlightNumber_timestamp == null) ? 0 : stubbedFlightNumber_timestamp.hashCode());

        result = prime * result + ((reasonCode == null) ? 0 : reasonCode.hashCode());
        result = prime * result + ((soarFlight == null) ? 0 : soarFlight.hashCode());
        result = prime * result + ((reasonDescription == null) ? 0 : reasonDescription.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Status other = (Status) obj;
        if (arrivalStatus != other.arrivalStatus)
            return false;
        if (arrivalStatus_timestamp == null) {
            if (other.arrivalStatus_timestamp != null)
                return false;
        } else if (!arrivalStatus_timestamp.equals(other.arrivalStatus_timestamp))
            return false;
        if (cancelledCode == null) {
            if (other.cancelledCode != null)
                return false;
        } else if (!cancelledCode.equals(other.cancelledCode))
            return false;
        if (cancelledReason == null) {
            if (other.cancelledReason != null)
                return false;
        } else if (!cancelledReason.equals(other.cancelledReason))
            return false;
        if (departureStatus != other.departureStatus)
            return false;
        if (departureStatus_timestamp == null) {
            if (other.departureStatus_timestamp != null)
                return false;
        } else if (!departureStatus_timestamp.equals(other.departureStatus_timestamp))
            return false;
        if (flightReleaseStatus != other.flightReleaseStatus)
            return false;
        if (flightReleaseStatus_timestamp == null) {
            if (other.flightReleaseStatus_timestamp != null)
                return false;
        } else if (!flightReleaseStatus_timestamp.equals(other.flightReleaseStatus_timestamp))
            return false;
        if (legStatus != other.legStatus)
            return false;
        if (legStatus_timestamp == null) {
            if (other.legStatus_timestamp != null)
                return false;
        } else if (!legStatus_timestamp.equals(other.legStatus_timestamp))
            return false;
        if (previousArrivalStatus != other.previousArrivalStatus)
            return false;
        if (previousDepartureStatus != other.previousDepartureStatus)
            return false;
        if (stubbedFlightNumber == null) {
            if (other.stubbedFlightNumber != null)
                return false;
        } else if (!stubbedFlightNumber.equals(other.stubbedFlightNumber))
            return false;
        if (stubbedFlightNumber_timestamp == null) {
            if (other.stubbedFlightNumber_timestamp != null)
                return false;
        } else if (!stubbedFlightNumber_timestamp.equals(other.stubbedFlightNumber_timestamp))
            return false;
        if (reasonCode == null) {
            if (other.reasonCode != null)
                return false;
        } else if (!reasonCode.equals(other.reasonCode))
            return false;
        if (reasonDescription == null) {
            if (other.reasonDescription != null)
                return false;
        } else if (!reasonDescription.equals(other.reasonDescription))
            return false;
        if (previousLegStatus_timestamp == null) {
            if (other.previousLegStatus_timestamp != null)
                return false;
        } else if (!previousLegStatus_timestamp.equals(other.previousLegStatus_timestamp))
            return false;
        if (soarFlight == null) {
            if (other.soarFlight != null)
                return false;
        } else if (!soarFlight.equals(other.soarFlight))
            return false;

        return true;
    }

    // Getters & Setters
    // Customer methods listed first

    /**
     * Takes in String and maps to associated enum
     *
     * @param arrivalStatus
     */
//    public void setArrivalStatus(String arrivalStatus) {
//        try {
//            ArrivalStatus status = ArrivalStatus.getArrivalStatus(arrivalStatus.toUpperCase());
//            this.arrivalStatus = status;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void setFlightReleaseStatus(String fltstatus) {
//        try {
//            FlightReleaseStatus status = FlightReleaseStatus.getFlightReleaseStatus(fltstatus.toUpperCase());
//            this.flightReleaseStatus = status;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void setDepartureStatus(String departureStatus) {
//        try {
//            DepartureStatus status = DepartureStatus.getDepartureStatus(departureStatus.toUpperCase());
//            this.departureStatus = status;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void setLegStatus(String legStatus) {
//        try {
//            LegStatus status = LegStatus.getLegStatus(legStatus.toUpperCase());
//            this.legStatus = status;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrivalStatus getArrivalStatus() {
//        return arrivalStatus;
//    }
//
//    public void setArrivalStatus(ArrivalStatus arrivalStatus) {
//        this.arrivalStatus = arrivalStatus;
//    }
//
//    public Date getArrivalStatus_timestamp() {
//        return arrivalStatus_timestamp;
//    }
//
//    public void setArrivalStatus_timestamp(Date arrivalStatus_timestamp) {
//        this.arrivalStatus_timestamp = arrivalStatus_timestamp;
//    }
//
//    public DepartureStatus getDepartureStatus() {
//        return departureStatus;
//    }
//
//    public void setDepartureStatus(DepartureStatus departureStatus) {
//        this.departureStatus = departureStatus;
//    }

    public Date getDepartureStatus_timestamp() {
        return departureStatus_timestamp;
    }

    public void setDepartureStatus_timestamp(Date departureStatus_timestamp) {
        this.departureStatus_timestamp = departureStatus_timestamp;
    }

//    public LegStatus getLegStatus() {
//        return legStatus;
//    }
//
//    public void setLegStatus(LegStatus legStatus) {
//        this.legStatus = legStatus;
//    }

    public Date getLegStatus_timestamp() {
        return legStatus_timestamp;
    }

    public void setLegStatus_timestamp(Date legStatus_timestamp) {
        this.legStatus_timestamp = legStatus_timestamp;
    }

//    public LegStatus getPreviousLegStatus() {
//        return previousLegStatus;
//    }
//
//    public void setPreviousLegStatus(LegStatus previousLegStatus) {
//        this.previousLegStatus = previousLegStatus;
//    }
//
//    public FlightReleaseStatus getFlightReleaseStatus() {
//        return flightReleaseStatus;
//    }
//
//    public void setFlightReleaseStatus(FlightReleaseStatus flightReleaseStatus) {
//        this.flightReleaseStatus = flightReleaseStatus;
//    }

    public Date getFlightReleaseStatus_timestamp() {
        return flightReleaseStatus_timestamp;
    }

    public void setFlightReleaseStatus_timestamp(Date flightReleaseStatus_timestamp) {
        this.flightReleaseStatus_timestamp = flightReleaseStatus_timestamp;
    }

    public String getStubbedFlightNumber() {
        return stubbedFlightNumber;
    }

    public void setStubbedFlightNumber(String stubbedFlightNumber) {
        this.stubbedFlightNumber = stubbedFlightNumber;
    }

    public Date getStubbedFlightNumber_timestamp() {
        return stubbedFlightNumber_timestamp;
    }

    public void setStubbedFlightNumber_timestamp(Date stubbedFlightNumber_timestamp) {
        this.stubbedFlightNumber_timestamp = stubbedFlightNumber_timestamp;
    }

//    public ArrivalStatus getPreviousArrivalStatus() {
//        return previousArrivalStatus;
//    }
//
//    public void setPreviousArrivalStatus(ArrivalStatus previousArrivalStatus) {
//        this.previousArrivalStatus = previousArrivalStatus;
//    }
//
//    public DepartureStatus getPreviousDepartureStatus() {
//        return previousDepartureStatus;
//    }
//
//    public void setPreviousDepartureStatus(DepartureStatus previousDepartureStatus) {
//        this.previousDepartureStatus = previousDepartureStatus;
//    }

    public String getCancelledReason() {
        return cancelledReason;
    }

    public void setCancelledReason(String cancelledReason) {
        this.cancelledReason = cancelledReason;
    }

    public String getCancelledCode() {
        return cancelledCode;
    }

    public void setCancelledCode(String cancelledCode) {
        this.cancelledCode = cancelledCode;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public Date getPreviousArrivalStatus_timestamp() {
        return previousArrivalStatus_timestamp;
    }

    public void setPreviousArrivalStatus_timestamp(Date previousArrivalStatus_timestamp) {
        this.previousArrivalStatus_timestamp = previousArrivalStatus_timestamp;
    }

    public Date getPreviousDepartureStatus_timestamp() {
        return previousDepartureStatus_timestamp;
    }

    public void setPreviousDepartureStatus_timestamp(Date previousDepartureStatus_timestamp) {
        this.previousDepartureStatus_timestamp = previousDepartureStatus_timestamp;
    }

    public Date getPreviousLegStatus_timestamp() {
        return previousLegStatus_timestamp;
    }

    public void setPreviousLegStatus_timestamp(Date previousLegStatus_timestamp) {
        this.previousLegStatus_timestamp = previousLegStatus_timestamp;
    }

//    @Override
//    public Object replicate(String snapshotID) {
//        // do a deep copy
//        Status copyStatus = new Status(this);
//        copyStatus.applySnapshotID(snapshotID);
//        return copyStatus;
//    }

    public LKAFlightKey getNext_leg_recovery() {
        return next_leg_recovery;
    }

    public void setNext_leg_recovery(LKAFlightKey next_leg_recovery) {
        this.next_leg_recovery = next_leg_recovery;
    }

    public LKAFlightKey getPrev_leg_div() {
        return prev_leg_div;
    }

    public void setPrev_leg_div(LKAFlightKey prev_leg_div) {
        this.prev_leg_div = prev_leg_div;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isThruFlight() {
        return thruFlight;
    }

    public void setThruFlight(boolean thruFlight) {
        this.thruFlight = thruFlight;
    }

    public boolean isGroundInterrupted() {
        return groundInterrupted;
    }

    public void setGroundInterrupted(boolean groundInterrupted) {
        this.groundInterrupted = groundInterrupted;
    }

    public String getDelayReasonCodes() {
        return delayReasonCodes;
    }

    public void setDelayReasonCodes(String delayReasonCodes) {
        this.delayReasonCodes = delayReasonCodes;
    }

    public Date getDelayReasonCodes_timestamp() {
        return delayReasonCodes_timestamp;
    }

    public void setDelayReasonCodes_timestamp(Date delayReasonCodes_timestamp) {
        this.delayReasonCodes_timestamp = delayReasonCodes_timestamp;
    }

    public Boolean getSoarFlight() { return soarFlight; }

    public void setSoarFlight(Boolean soarFlight) { this.soarFlight = soarFlight; }

    public Integer getFlightPlanReleaseCount() {
        return flightPlanReleaseCount;
    }

    public void setFlightPlanReleaseCount(Integer flightPlanReleaseCount) {
        this.flightPlanReleaseCount = flightPlanReleaseCount;
    }

    /**
     * Map of snapshot ID to backing Status
     */
    private HashMap<String, Status> snapshots;

    public HashMap<String, Status> getSnapshots() {
        if (snapshots == null) {
            snapshots = new HashMap<>();
        }
        return snapshots;
    }

    public void setSnapshots(HashMap<String, Status> snapshots) {
        this.snapshots = snapshots;
    }

//    public void setPreviousLegStatus(LegStatus previousLegStatus, String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            this.previousLegStatus = previousLegStatus;
//        } else {
//            Status snapshotStatus = getSnapshots().get(snapshotId);
//            if (snapshotStatus != null) {
//                snapshotStatus.setPreviousLegStatus(previousLegStatus);
//            } else {
//                Status newSnapshotStatus = new Status();
//                newSnapshotStatus.setPreviousLegStatus(previousLegStatus);
//                getSnapshots().put(snapshotId, newSnapshotStatus);
//            }
//        }
//    }
//
//    public LegStatus getPreviousLegStatus(String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            return previousLegStatus;
//        }
//        if (snapshots != null && snapshots.get(snapshotId) != null
//            && snapshots.get(snapshotId).getPreviousLegStatus() != null) {
//            return snapshots.get(snapshotId).getPreviousLegStatus();
//        } else {
//            return previousLegStatus;
//        }
//    }
//
//    public void setLegStatus(LegStatus legStatus, String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            this.legStatus = legStatus;
//        } else {
//            Status snapshotStatus = getSnapshots().get(snapshotId);
//            if (snapshotStatus != null) {
//                snapshotStatus.setLegStatus(legStatus);
//            } else {
//                Status newSnapshotStatus = new Status();
//                newSnapshotStatus.setLegStatus(legStatus);
//                getSnapshots().put(snapshotId, newSnapshotStatus);
//            }
//        }
//    }
//
//    public LegStatus getLegStatus(String snapshotId) {
//        if (CommonUtility.isMasterSnapshot(snapshotId)) {
//            return legStatus;
//        }
//        if (snapshots != null && snapshots.get(snapshotId) != null
//            && snapshots.get(snapshotId).getLegStatus() != null) {
//            return snapshots.get(snapshotId).getLegStatus();
//        } else {
//            return legStatus;
//        }
//    }


    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setArrivalStatus(String arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    public void setArrivalStatus_timestamp(Date arrivalStatus_timestamp) {
        this.arrivalStatus_timestamp = arrivalStatus_timestamp;
    }

    public void setPreviousArrivalStatus(String previousArrivalStatus) {
        this.previousArrivalStatus = previousArrivalStatus;
    }

    public void setDepartureStatus(String departureStatus) {
        this.departureStatus = departureStatus;
    }

    public void setPreviousDepartureStatus(String previousDepartureStatus) {
        this.previousDepartureStatus = previousDepartureStatus;
    }

    public void setLegStatus(String legStatus) {
        this.legStatus = legStatus;
    }

    public void setPreviousLegStatus(String previousLegStatus) {
        this.previousLegStatus = previousLegStatus;
    }

    public void setFlightReleaseStatus(String flightReleaseStatus) {
        this.flightReleaseStatus = flightReleaseStatus;
    }
}
