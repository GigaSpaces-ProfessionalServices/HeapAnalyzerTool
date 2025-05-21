package com.mycompany.app.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.io.Serializable;

@SpaceClass
public class ClassC implements Serializable {
    private String id;
    private String arrivalStatus;
    private String previousArrivalStatus;

    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArrivalStatus() {
        return arrivalStatus;
    }

    public void setArrivalStatus(String arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    public String getPreviousArrivalStatus() {
        return previousArrivalStatus;
    }

    public void setPreviousArrivalStatus(String previousArrivalStatus) {
        this.previousArrivalStatus = previousArrivalStatus;
    }


    public ClassC() {
    }

    public ClassC(String id, String arrivalStatus, String previousArrivalStatus) {
        this.id = id;
        this.arrivalStatus = arrivalStatus;
        this.previousArrivalStatus = previousArrivalStatus;
    }
}
