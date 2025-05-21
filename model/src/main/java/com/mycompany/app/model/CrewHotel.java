package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.crewsequence.read.CrewHotelKey;
//import com.aa.lookahead.dataobjects.crewsequence.read.CrewPositionKey;
//import com.aa.lookahead.utils.common.CrewMirrorConstants;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
//import com.aa.lookahead.utils.common.annotations.MirrorTable;
import com.gigaspaces.annotation.pojo.*;

import java.io.Serializable;
import java.util.Date;

//@CompoundSpaceIndexes({
//        @CompoundSpaceIndex(paths = {
//                "crewHotelKey.sequenceNumber", "crewHotelKey.sequenceOrignDate", "crewHotelKey.crewBase",
//                "crewHotelKey.crewType", "crewHotelKey.airlineCode", "crewHotelKey.domesticOrInternational"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "crewHotelKey.sequenceNumber", "crewHotelKey.sequenceOrignDate", "crewHotelKey.crewBase",
//                "crewHotelKey.crewType", "crewHotelKey.airlineCode", "crewHotelKey.domesticOrInternational",
//                "crewHotelKey.employeeNumber"
//        }),
//        @CompoundSpaceIndex(paths = {
//                "crewHotelKey.sequenceNumber", "crewHotelKey.sequenceOrignDate", "crewHotelKey.crewBase",
//                "crewHotelKey.crewType", "crewHotelKey.airlineCode", "crewHotelKey.domesticOrInternational",
//                "crewHotelKey.employeeNumber", "crewHotelKey.dutyPeriodNumber"
//        })
//})
@SpaceClass(blobstoreEnabled = false)
//@MirrorTable(name = CrewMirrorConstants.CREW_HOTEL)
public class CrewHotel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5219166827945616113L;

//    @MirrorColumn(name = CrewMirrorConstants.CREW_HOTEL_KEY, type = CrewMirrorConstants.NVARCHAR, precision = 60, pk = true, allowNulls = false)
    private String crewHotelKey;
//    @MirrorColumn(name = MirrorConstants.CREW_HOTEL_SOURCE_TIMESTAMP, type = CrewMirrorConstants.DATETIME2, precision = CrewMirrorConstants.DATETIME2_PRECISION)
    private Date sourceTimeStamp;
//    @MirrorColumn(name = CrewMirrorConstants.CREW_HOTEL_NAME, type = CrewMirrorConstants.NVARCHAR, precision = CrewMirrorConstants.NVARCHAR_PRECISION)
    private String hotelName;
//    @MirrorColumn(name = CrewMirrorConstants.CREW_HOTEL_PHONE, type = CrewMirrorConstants.NVARCHAR, precision = CrewMirrorConstants.NVARCHAR_PRECISION)
    private String hotelPhone;
//    @MirrorColumn(name = MirrorConstants.CREW_HOTEL_CONTRACTUAL_MONTH, type = CrewMirrorConstants.NVARCHAR, precision = 7)
    private String contractualMonth;
    private CrewPositionKey positionKey;

    private String routingId;

    @SpaceId(autoGenerate = false)
    public String getCrewHotelKey() {
        return crewHotelKey;
    }

    public CrewHotel() {
    }

    public CrewHotel(String crewHotelKey) {
        this.crewHotelKey = crewHotelKey;
    }

    public void setCrewHotelKey(String crewHotelKey) {
        this.crewHotelKey = crewHotelKey;
//        if (this.crewHotelKey != null)
//        {
//            this.employeeNumber = this.crewHotelKey.getEmployeeNumber();
//            this.positionKey = new CrewPositionKey(crewHotelKey.getSequenceNumber(),crewHotelKey.getSequenceOrignDate(),
//               crewHotelKey.getCrewBase(),crewHotelKey.getCrewType(),crewHotelKey.getAirlineCode(),
//               crewHotelKey.getDomesticOrInternational(),crewHotelKey.getEmployeeNumber(),crewHotelKey.getPosition());
//        }
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
//        if ("000000".equals(employeeNumber)) {
//            return crewHotelKey.generateSequenceKeyString();
//        }
        return employeeNumber;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }


    /**
     * @param employeeNumber the employeeNumber to set
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getSourceTimeStamp() {
        return sourceTimeStamp;
    }

    public void setSourceTimeStamp(Date sourceTimeStamp) {
        this.sourceTimeStamp = sourceTimeStamp;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
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

    public boolean isEqual(CrewHotel crewHotel) {
        boolean isEqual = false;
        if (crewHotel.getCrewHotelKey() != null && getCrewHotelKey().equals(crewHotel.getCrewHotelKey())
                && crewHotel.getHotelName() != null && getHotelName().equals(crewHotel.getHotelName())
                && crewHotel.getHotelPhone() != null && getHotelPhone().equals(crewHotel.getHotelPhone())
                && crewHotel.getContractualMonth() != null
                && getContractualMonth().equals(crewHotel.getContractualMonth())) {
            isEqual = true;
        }

        return isEqual;
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
