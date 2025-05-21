//package com.mycompany.app.model;
//
////import com.aa.lookahead.dataobjects.crewsequence.read.genericamoc.enums.GenericAMOCRouteEnum;
////import com.aa.lookahead.dataobjects.crewsequence.read.genericamoc.enums.GenericAMOCStatusCodesEnum;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//
//public class GenericAMOCFlightStatus implements Serializable {
//
//    private static final long serialVersionUID = -1668049402658655115L;
//
//    private String uuid;
//
//    private Boolean genericAMOCFlight = false;
//
//    private GenericAMOCRouteEnum amocRoute = GenericAMOCRouteEnum.NONE;
//
//    private List<GenericAMOCStatusCodesEnum> amocFlightStatusCodes = new ArrayList<>();
//
//    public GenericAMOCFlightStatus() {
//        this.genericAMOCFlight =false;
//        this.amocRoute = GenericAMOCRouteEnum.NONE;
//        this.amocFlightStatusCodes = Collections.emptyList();
//    }
//
//    public GenericAMOCFlightStatus(GenericAMOCRouteEnum amocTypeEnum, Boolean isAmocFlight) {
//        this.genericAMOCFlight =isAmocFlight;
//        this.amocRoute =amocTypeEnum;
//        this.amocFlightStatusCodes = Collections.emptyList();
//    }
//
//    public GenericAMOCFlightStatus(Boolean genericAMOCFlight, List<GenericAMOCStatusCodesEnum> amocFlightStatusCodes, GenericAMOCRouteEnum amocRoute) {
//        this.genericAMOCFlight =genericAMOCFlight;
//        this.amocFlightStatusCodes = amocFlightStatusCodes;
//        this.amocRoute =amocRoute;
//    }
//
//    public List<GenericAMOCStatusCodesEnum> getAmocFlightStatusCodes() {
//        return amocFlightStatusCodes;
//    }
//
//    public Boolean getGenericAMOCFlight() {
//        return genericAMOCFlight;
//    }
//
//    public void setGenericAMOCFlight(Boolean isValidAMOCFlight) {
//        this.genericAMOCFlight = isValidAMOCFlight;
//    }
//
//    public void setAmocFlightStatusCodes(List<GenericAMOCStatusCodesEnum> amocFlightStatusCodes) {
//        this.amocFlightStatusCodes = amocFlightStatusCodes;
//    }
//
//    public GenericAMOCRouteEnum getAmocRoute() {
//        return amocRoute;
//    }
//
//    public void setAmocRoute(GenericAMOCRouteEnum amocRoute) {
//        this.amocRoute = amocRoute;
//    }
//
//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
//
//    @Override
//    public String toString() {
//        return "GenericAmocStatus{" +
//                "isValidAMOCFlight=" + genericAMOCFlight +
//                ", amocRoute=" + amocRoute +
//                ", amocFlightErrorCodes" + amocFlightStatusCodes +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        if (!(o instanceof GenericAMOCFlightStatus))
//            return false;
//
//        GenericAMOCFlightStatus that = (GenericAMOCFlightStatus)o;
//
//        if (!Objects.equals(this.genericAMOCFlight, that.genericAMOCFlight))
//            return false;
//        if (!Objects.equals(this.amocRoute, that.amocRoute))
//            return false;
//        if(!Objects.equals(this.amocFlightStatusCodes, that.amocFlightStatusCodes))
//            return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = genericAMOCFlight != null ? genericAMOCFlight.hashCode() : 0;
//        result = 31 * result + (amocRoute != null ? amocRoute.hashCode() : 0);
//        result = 31 * result + (amocFlightStatusCodes != null ? amocFlightStatusCodes.hashCode() : 0);
//        return result;
//    }
//}