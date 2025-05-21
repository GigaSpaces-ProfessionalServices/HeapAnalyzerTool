package com.mycompany.app.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.joda.time.LocalDate;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;

//import com.aa.lookahead.dataobjects.fltinv.LegParameters;
//import com.aa.lookahead.domainobjects.flighthub.flightevents.jaxb.ConsolidatedType;
//import com.aa.lookahead.utils.DateTimeUtils;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.metadata.index.SpaceIndexType;
//import com.ibm.streams.operator.Tuple;

public class LKAFlightKey implements Serializable {

    private static final long serialVersionUID = 7055494564308021211L;
//    @MirrorColumn(name = MirrorConstants.AIRLINE_CODE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String airlineCode;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_NUMBER, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String flightNumber; // 4-digit
//    @MirrorColumn(name = MirrorConstants.FLIGHT_DATE, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String flightDate; // ddMMMyy
//    @MirrorColumn(name = MirrorConstants.DEPARTURE_STATION, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String departureStation;
    // added default value for depDupCode to 0 fix null dupDepCode
//    @MirrorColumn(name = MirrorConstants.DUP_DEP_CODE, type = MirrorConstants.INT)
    private Integer dupDepCode = 0;
    // added default value for snapshotId to "0" fix null snapshotId
//    @MirrorColumn(name = MirrorConstants.SNAPSHOT_ID, type = MirrorConstants.NVARCHAR, precision = MirrorConstants.NVARCHAR_PRECISION_50)
    private String snapshotId = "0";
//    private static DateTimeFormatter ddMMMyy_fmt = DateTimeFormat.forPattern("ddMMMyy");

    public LKAFlightKey() {

    }

    /**
     * Deep Clone constructor
     *
     * @param fltKey
     */
    public LKAFlightKey(LKAFlightKey fltKey) {
        if (fltKey != null) {
            this.airlineCode = fltKey.airlineCode;
            this.flightNumber = fltKey.flightNumber;
            this.flightDate = fltKey.flightDate;
            this.departureStation = fltKey.departureStation;
            this.dupDepCode = fltKey.dupDepCode;
            this.snapshotId = fltKey.snapshotId;
        }
    }

    public LKAFlightKey(String airlineCode, String flightNumber, String flightDate_ddMMMyy, String departureStation) {
        this(airlineCode, flightNumber, flightDate_ddMMMyy, departureStation, 0, "0");
    }

    public LKAFlightKey(String airlineCode, String flightNumber, String flightDate_ddMMMyy, String departureStation, Integer dupDepartureCode) {
        this(airlineCode, flightNumber, flightDate_ddMMMyy, departureStation, dupDepartureCode, "0");
    }

    public LKAFlightKey(String airlineCode, String flightNumber, String flightDate_ddMMMyy, String departureStation, Integer dupDepartureCode, String snapshotId) {
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate_ddMMMyy;
        this.departureStation = departureStation;
        this.dupDepCode = dupDepartureCode;
        this.snapshotId = snapshotId;
    }

    /**
     * Constructor that takes in toString() of FlightKey and converts to fltkey object.
     *
     * @param fltkey
     *            String in the form of "AA000112MAY15JFK00", two character airline code, 1 - 4 character flight number, date in string form of ddMMMyy, and three character
     *            departureStation
     */
    public LKAFlightKey(String fltkey) {
        if (fltkey.length() < 13) {
            throw new IllegalArgumentException("fltkey length should be between 13 and 16 characters");
        }
        if (fltkey.length() > 16) {
            // parse snapshot ID and dupCode

            // look for the pattern for fltDate FEB16DFW
            String pattern = "\\D\\D\\D\\d\\d\\D\\D\\D";

            Pattern regexPattern = Pattern.compile(pattern);
            Matcher m = regexPattern.matcher(fltkey);
            if (m.find()) {
                String fltDateStr = m.group(); // get first matching
                int dupCodePosition = fltkey.indexOf(fltDateStr) + fltDateStr.length();
                String dupCodeAndSnapshotIDString = fltkey.substring(dupCodePosition);

                this.dupDepCode = Integer.parseInt(dupCodeAndSnapshotIDString.substring(0, 1));
                this.snapshotId = dupCodeAndSnapshotIDString.substring(1);

                fltkey = fltkey.substring(0, (fltkey.length() - dupCodeAndSnapshotIDString.length()));
            } else {
                throw new IllegalArgumentException("fltkey must contain a flight date string");
            }
        } else {

            this.dupDepCode = 0;
            this.snapshotId = "0";
        }
        int offset = 16 - fltkey.length();

        char[] chars = fltkey.toCharArray();
        String airlineCode = String.copyValueOf(chars, 0, 2);
        String flightNum = String.copyValueOf(chars, 2, 4 - offset);
        String flightDate = String.copyValueOf(chars, 6 - offset, 7);
        String depStation = String.copyValueOf(chars, 13 - offset, 3);
        this.setAirlineCode(airlineCode);
        this.setFlightNumber(flightNum);
        this.setFlightDate(flightDate);
        this.setDepartureStation(depStation);
    }

    /**
     * Constructs and LKAFlightKey object from a jaxb Flight object.
     *
     * @param f
     *            jaxb.Flight object
     */
//    public LKAFlightKey(ConsolidatedType f) {
//        this.airlineCode = f.getKey().getAirlineCode().getIATA();
//        this.flightNumber = f.getKey().getFltNum();
//        // Pull from STD and Offset if it exists
//        if (f != null && f.getLeg() != null  && this.flightNumber.equals("0922") && f.getLeg().getTimes() !=null && f.getLeg().getTimes().getDepGMTAdjustment() != null) {
//            this.flightDate = DateTimeUtils.calToDayOfWeek(f.getLeg().getTimes().getSTD(), f.getLeg().getTimes().getDepGMTAdjustment());
//        } else {
//            this.flightDate = DateTimeUtils.formatXMLCalendar(f.getKey().getFltOrgDate(), DateTimeUtils.ddMMMyy);
//        }
//        this.departureStation = f.getKey().getDepSta();
//        this.dupDepCode = Integer.parseInt(f.getKey().getDupDepStaNum());
//    }
//
//    public LKAFlightKey(LegParameters legParameters) {
//
//        // TODO - ensure 4-digit flightNumber?
//        String fltNum = "" + legParameters.getFlight();
//        if (fltNum.length() < 4)
//            fltNum = "0000".substring(fltNum.length()) + fltNum;
//        this.setAirlineCode(legParameters.getMarketingCarrier());
//        this.setFlightNumber(fltNum);
//        LocalDate date = new LocalDate(legParameters.getLocalDepartureDate());
//        this.setFlightDate(date.toString(ddMMMyy_fmt).toUpperCase());
//        this.setDepartureStation(legParameters.getOriginAirport());
//    }
//
//    public LKAFlightKey(Tuple tuple) {
//        this.airlineCode = tuple.getString("airlineCode");
//        this.flightNumber = tuple.getString("flightNumber");
//        this.flightDate = tuple.getString("flightDate");
//        this.departureStation = tuple.getString("departureStation");
//        this.dupDepCode = Integer.valueOf(tuple.getInt("dupDepCode"));
//
//    }

    @Override
    public String toString() {
        return "LKAFlightKey [airlineCode=" + airlineCode + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", departureStation=" + departureStation
                + ", dupDepCode=" + dupDepCode + ", snapshotId=" + snapshotId + "]";
    }

    public String toShortString() {
        return "Flight " + flightNumber + "/"+flightDate.substring(0, 2)
            +departureStation;
    }
    public String toSyntheticCostString() {
        return airlineCode + "|"+ flightNumber + "|" + flightDate
                + "|"+departureStation + "|" + dupDepCode;
    }
    public String generateNumericFlightKey(String arrivalStation) {
        String flightSequenceKey = "";
        String cityPair = departureStation + arrivalStation;
        char[] cityPairCharacters = cityPair.toCharArray();
        String hashValue = "";
        for (int i = 0; i < cityPairCharacters.length; i++) {
            hashValue += (String.valueOf(cityPairCharacters[i])).hashCode();
        }

        try {
            SimpleDateFormat flightDateDateFormat = new SimpleDateFormat("ddMMMyy");
            SimpleDateFormat newFlightDateDateFormat = new SimpleDateFormat("ddMMyy");
            String ddMMyyDate = newFlightDateDateFormat.format(flightDateDateFormat.parse(flightDate));
            flightSequenceKey += ddMMyyDate + flightNumber + hashValue;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return flightSequenceKey;
    }

    /*
     * (non-Javadoc) outputs the string which can be consumed by the LKAFlightKey Constructor. It is defined as Recovery Event is exported and consumed in Diversion Consumer,
     * to convert back the newValue into flightKey, to create a diversionView Object
     */

    public String concatString() {
        StringBuilder sb = new StringBuilder();
        appendFlightKeyInfoExceptSnapshot(sb);
        sb.append(snapshotId);
        return sb.toString();

    }

    public String concatFlightKeyStringExceptSnapshot() {
        StringBuilder sb = new StringBuilder();
        appendFlightKeyInfoExceptSnapshot(sb);
        return sb.toString();
    }

    private void appendFlightKeyInfoExceptSnapshot(StringBuilder sb) {
        sb.append(airlineCode);
        sb.append(flightNumber);
        sb.append(flightDate);
        sb.append(departureStation);
        sb.append(dupDepCode);
    }

    // Getters & Setters

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((airlineCode == null) ? 0 : airlineCode.hashCode());
        result = prime * result + ((departureStation == null) ? 0 : departureStation.hashCode());
        result = prime * result + ((dupDepCode == null) ? 0 : dupDepCode.hashCode());
        result = prime * result + ((flightDate == null) ? 0 : flightDate.hashCode());
        result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
        result = prime * result + ((snapshotId == null) ? 0 : snapshotId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LKAFlightKey other = (LKAFlightKey) obj;
        if (flightNumber == null) {
            if (other.flightNumber != null)
                return false;
        } else if (!flightNumber.equals(other.flightNumber))
            return false;
        if (departureStation == null) {
            if (other.departureStation != null)
                return false;
        } else if (!departureStation.equals(other.departureStation))
            return false;
        if (flightDate == null) {
            if (other.flightDate != null)
                return false;
        } else if (!flightDate.equals(other.flightDate))
            return false;
        if (airlineCode == null) {
            if (other.airlineCode != null)
                return false;
        } else if (!airlineCode.equals(other.airlineCode))
            return false;
        if (dupDepCode == null) {
            if (other.dupDepCode != null)
                return false;
        } else if (!dupDepCode.equals(other.dupDepCode))
            return false;
        if (snapshotId == null) {
            if (other.snapshotId != null)
                return false;
        } else if (!snapshotId.equals(other.snapshotId))
            return false;
        return true;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @SpaceIndex(type = SpaceIndexType.BASIC)
    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public Integer getDupDepCode() {
        return dupDepCode;
    }

    public void setDupDepCode(Integer dupDepCode) {
        this.dupDepCode = dupDepCode;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * Generates the alternate flight key for this flight. It should always be the original flightKey w/ a dupDepCode of zero
     *
     * @return LKAFlightKey with all attributes identical to this, except the dupDepCode is zero
     * @deprecated the alternate flight key now refers to the original flight key for the flight (regardless of diversions and interupts). As such, this generation with no
     *             dupDepCode is no longer accurate.
     */
    @Deprecated
    public LKAFlightKey generateAltFlightKey() {
        return new LKAFlightKey(airlineCode, flightNumber, flightDate, departureStation);
    }

    public String generateFlightKeyString() {
        return airlineCode + flightNumber + flightDate + departureStation + dupDepCode + snapshotId;
    }

    public String generateNonSnapshotFlightKeyString() {
        return airlineCode + flightNumber + flightDate + departureStation + dupDepCode;
    }

    public LKAFlightKey generateNonSnapshotFlightKey() {
        return new LKAFlightKey(airlineCode, flightNumber, flightDate, departureStation, dupDepCode);
    }
}
