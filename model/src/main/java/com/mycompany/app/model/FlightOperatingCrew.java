package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.LKAFlightKey;
//import com.aa.lookahead.dataobjects.crewsequence.read.CrewFlightDetail;
import com.gigaspaces.annotation.pojo.*;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;
/**
 * @author 623797
 */
@SpaceClass(blobstoreEnabled = false)
//@MirrorTable(name = MirrorConstants.FLIGHT_OPERATING_CREW)
public class FlightOperatingCrew implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8637360810357045460L;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_KEY, pk = true, embedded = true)
    private LKAFlightKey flightKey;
//    @MirrorColumn(name = MirrorConstants.ROUTING_FLIGHT_KEY, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION)
    private LKAFlightKey routingFlightKey;
    private List<CrewFlightDetail> cockPitCrewList;
    private List<CrewFlightDetail> cabinCrewList;
    private List<CrewFlightDetail> deadHeadCrewList;
    private List<CrewFlightDetail> regionalDHCrewList;
//    @MirrorColumn(name = MirrorConstants.FOC_FLIGHT_DATE, type = MirrorConstants.DATETIME2)
    private Date flightDate;
//    @MirrorColumn(name = MirrorConstants.FOC_FLIGHT_DATE_LONG, type = MirrorConstants.BIGINT)

    private long flightDtLong;
//    @MirrorColumn(name = MirrorConstants.POSITION_EMPLOYEE_MAP, convertToJson = true)
    private HashMap<String, String> positionEmployeeMap; 
//    @MirrorColumn(name = MirrorConstants.FOS_UPDATE_TIME, type = MirrorConstants.DATETIME2)
    private Date fosUpdateTime;

    /**
     * Default constructor
     */
    public FlightOperatingCrew() {
        this.positionEmployeeMap = new HashMap<String, String>();
        this.positionEmployeeMap.put("CA", "000000");
        this.positionEmployeeMap.put("FO", "000000");
        this.cockPitCrewList = new ArrayList<CrewFlightDetail>();
        this.cabinCrewList = new ArrayList<CrewFlightDetail>();
        this.deadHeadCrewList = new ArrayList<CrewFlightDetail>();
        this.regionalDHCrewList = new ArrayList<>();
    }

    public FlightOperatingCrew(FlightOperatingCrew fltOptCrew, ArrayList<CrewFlightDetail> cockPitCrewList, ArrayList<CrewFlightDetail> cabinCrewList,
                               ArrayList<CrewFlightDetail> deadHeadCrewList, String snapshotId) {
        this.cabinCrewList = cabinCrewList;
        this.cockPitCrewList = cockPitCrewList;
        this.deadHeadCrewList = deadHeadCrewList;
        this.flightDate = fltOptCrew.getFlightDate();
        if (flightDate != null)
            this.flightDtLong = flightDate.getTime();
        if (fltOptCrew.getFlightKey() != null) {
            LKAFlightKey fltKey = new LKAFlightKey(fltOptCrew.getFlightKey());
            fltKey.setSnapshotId(snapshotId);
            this.flightKey = fltKey;
        }
        this.routingFlightKey = fltOptCrew.getRoutingFlightKey();
        this.positionEmployeeMap = fltOptCrew.getPositionEmployeeMap();
    }

    /**
     * @return <code>LKAFlightKey</code> flight key
     */
    @SpaceId(autoGenerate = false)
    public LKAFlightKey getFlightKey() {
        return flightKey;
    }

    /**
     * @param flightKey <code>LKAFlightKey</code> flight key
     */
    public void setFlightKey(LKAFlightKey flightKey) {
        this.flightKey = flightKey;
    }

    /**
     * @return the cockPitCrewList
     */
    @SpaceIndexes({
            @SpaceIndex(path = "[*].dutyKey.employeeNumber", type = SpaceIndexType.BASIC),
    })
    public List<CrewFlightDetail> getCockPitCrewList() {
        return cockPitCrewList;
    }

    /**
     * @param cockPitCrewList the cockPitCrewList to set
     */
    public void setCockPitCrewList(List<CrewFlightDetail> cockPitCrewList) {
        this.cockPitCrewList = cockPitCrewList;
    }

    /**
     * @return the cabinCrewList
     */
    @SpaceIndexes({
            @SpaceIndex(path = "[*].dutyKey.employeeNumber", type = SpaceIndexType.BASIC),
    })
    public List<CrewFlightDetail> getCabinCrewList() {
        return cabinCrewList;
    }

    /**
     * @param cabinCrewList the cabinCrewList to set
     */
    public void setCabinCrewList(List<CrewFlightDetail> cabinCrewList) {
        this.cabinCrewList = cabinCrewList;
    }

    /**
     * @return the deadHeadCrewList
     */
    public List<CrewFlightDetail> getDeadHeadCrewList() {
        return deadHeadCrewList;
    }

    /**
     * @param deadHeadCrewList
     */
    public void setDeadHeadCrewList(List<CrewFlightDetail> deadHeadCrewList) {
        this.deadHeadCrewList = deadHeadCrewList;
    }

    /**
     * @return the deadHeadCrewList
     */
    public List<CrewFlightDetail> getRegionalDHCrewList() {
        return regionalDHCrewList;
    }

    /**
     * @param deadHeadCrewList
     */
    public void setRegionalDHCrewList(List<CrewFlightDetail> deadHeadCrewList) {
        this.regionalDHCrewList = deadHeadCrewList;
    }

    /**
     * @return the flightDate
     */
    @SpaceIndex(type = SpaceIndexType.EXTENDED)
    public Date getFlightDate() {
        return flightDate;
    }

    /**
     * @param flightDate the flightDate to set
     */
    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
        if (this.flightDate != null)
            this.flightDtLong = this.flightDate.getTime();
    }

    public HashMap<String, String> getPositionEmployeeMap() {
        return positionEmployeeMap;
    }

    public void setPositionEmployeeMap(HashMap<String, String> positionEmployeeMap) {
        this.positionEmployeeMap = positionEmployeeMap;
    }

    @SpaceRouting
    public LKAFlightKey getRoutingFlightKey() {
        if (routingFlightKey == null)
            return flightKey;
        return routingFlightKey;
    }

    public void setRoutingFlightKey(LKAFlightKey routingFlightKey) {
        this.routingFlightKey = routingFlightKey;
    }


    @SpaceProperty(nullValue="-1" )
    public long getFlightDtLong() {
        return flightDtLong;
    }

    public void setFlightDtLong(long flightDtLong) {
        this.flightDtLong = flightDtLong;
    }

	public Date getFosUpdateTime() {
		return fosUpdateTime;
	}

	public void setFosUpdateTime(Date fosUpdateTime) {
		this.fosUpdateTime = fosUpdateTime;
	}
}
