package com.mycompany.app.model;

//import com.aa.lookahead.dataobjects.LKAFlightKey;
//import com.aa.lookahead.utils.common.MirrorConstants;
//import com.aa.lookahead.utils.common.annotations.MirrorColumn;
import java.io.Serializable;

public class CrewFlightKey extends CrewDutyKey implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6589849499229385772L;
//    @MirrorColumn(name = MirrorConstants.FLIGHT_KEY, type = MirrorConstants.NVARCHAR)
    private LKAFlightKey flightKey;

    public CrewFlightKey() {
    }

    /**
     * Creates a new <code>CrewFlightKey</code>.
     *
     * @param sequenceNumber          <code>String</code> sequence number
     * @param sequenceOrignDate       <code>String</code> sequence origination date as yyyy-MM-dd
     * @param crewBase                <code>String</code> crew base (DFW/ORD/MIA)
     * @param crewType                <code>String</code> crew type (F/P)
     * @param airlineCode             <code>String</code> airline code
     * @param domesticOrInternational <code>String</code> domestic or international
     *                                indicator (D/I)
     * @param employeeNumber          <code>String</code> employee number
     * @param dutyPeriodNumber        <code>Integer</code> duty period number
     * @param flightKey               <code>LKAFlightKey</code> flight key
     * @param position                <code>String</code> sequence position (CA/FO/01..09)
     */
    public CrewFlightKey(String sequenceNumber, String sequenceOrignDate, String crewBase, String crewType,
                         String airlineCode, String domesticOrInternational, String employeeNumber, Integer dutyPeriodNumber,
                         LKAFlightKey flightKey, String position) {
        super(sequenceNumber, sequenceOrignDate, crewBase, crewType, airlineCode, domesticOrInternational,
                employeeNumber, dutyPeriodNumber, position);
        this.flightKey = flightKey;
    }

    /**
     * Creates a new <code>CrewFlightKey</code> using the crew duty key and flight key.
     *
     * @param dutyKey <code>CrewDutyKey</code> crew duty key
     * @param fltKey  <code>LKAFlightKey</code> flight key
     */
    public CrewFlightKey(CrewDutyKey dutyKey, LKAFlightKey fltKey) {
        super(dutyKey, dutyKey.getDutyPeriodNumber());
        this.flightKey = fltKey;
    }

    public LKAFlightKey getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(LKAFlightKey flightKey) {
        this.flightKey = flightKey;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + flightKey.getAirlineCode() + flightKey.getFlightNumber()
                + flightKey.getFlightDate() + flightKey.getDepartureStation() + flightKey.getDupDepCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        CrewFlightKey that = (CrewFlightKey) o;

        return flightKey != null ? flightKey.equals(that.flightKey) : that.flightKey == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flightKey != null ? flightKey.hashCode() : 0);
        return result;
    }
}
