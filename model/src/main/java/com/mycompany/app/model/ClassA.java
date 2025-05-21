package com.mycompany.app.model;


import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.io.Serializable;
import java.util.Date;

@SpaceClass(blobstoreEnabled = false)
public class ClassA  implements Serializable   {
    private String fdpDataKey;
    private Date sourceTimestamp;

    private Date eventGMTStartDate;

    @SpaceId(autoGenerate = false)
    public String getFdpDataKey() {
        return fdpDataKey;
    }

    public void setFdpDataKey(String fdpDataKey) {
        this.fdpDataKey = fdpDataKey;
    }

    public Date getSourceTimestamp() {
        return sourceTimestamp;
    }

    public void setSourceTimestamp(Date sourceTimestamp) {
        this.sourceTimestamp = sourceTimestamp;
    }

    public Date getEventGMTStartDate() {
        return eventGMTStartDate;
    }

    public void setEventGMTStartDate(Date eventGMTStartDate) {
        this.eventGMTStartDate = eventGMTStartDate;
    }
}
