package com.mycompany.app.model;

import com.gigaspaces.annotation.pojo.*;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@CompoundSpaceIndexes({
//   @CompoundSpaceIndex(paths = {
//      "sequenceKey.sequenceNumber", "sequenceKey.sequenceOrignDate"
//   })
//})
@SpaceClass
public class CrewSequencePositionDetail implements Serializable
{
   private static final long serialVersionUID = -641510287416648675L;
   private CrewSequenceKey sequenceKey;
   private Date actualSequenceStartDate;
   private Date actualSequenceEndDate;
   private Date eventDate;
   private Integer flownSequenceMinutes;
   private List<CrewPositionDetail> positions;
   private String sequenceInd;

   public CrewSequencePositionDetail() {
   }

   public CrewSequencePositionDetail(CrewSequenceKey sequenceKey) {
      this.sequenceKey = sequenceKey;
   }

   @SpaceId(autoGenerate = false)
   @SpaceRouting
   public CrewSequenceKey getSequenceKey()
   {
      return sequenceKey;
   }

   public void setSequenceKey(CrewSequenceKey sequenceKey)
   {
      this.sequenceKey = sequenceKey;
   }

   @SpaceIndex(type = SpaceIndexType.EXTENDED)
   public Date getActualSequenceStartDate()
   {
      return actualSequenceStartDate;
   }

   public void setActualSequenceStartDate(Date actualSequenceStartDate)
   {
      this.actualSequenceStartDate = actualSequenceStartDate;
   }

   public Date getActualSequenceEndDate()
   {
      return actualSequenceEndDate;
   }

   public void setActualSequenceEndDate(Date actualSequenceEndDate)
   {
      this.actualSequenceEndDate = actualSequenceEndDate;
   }

   public Date getEventDate()
   {
      return eventDate;
   }

   public void setEventDate(Date eventDate)
   {
      this.eventDate = eventDate;
   }

   public Integer getFlownSequenceMinutes()
   {
      return flownSequenceMinutes;
   }

   public void setFlownSequenceMinutes(Integer flownSequenceMinutes)
   {
      this.flownSequenceMinutes = flownSequenceMinutes;
   }

   @SpaceIndex(path = "[*].employeeNumber", type = SpaceIndexType.BASIC)
   public List<CrewPositionDetail> getPositions()
   {
      return positions;
   }

   public void setPositions(List<CrewPositionDetail> positions)
   {
      this.positions = positions;
   }

   public String getSequenceInd() {
      return sequenceInd;
   }

   public void setSequenceInd(String sequenceInd) {
      this.sequenceInd = sequenceInd;
   }

@Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (!(o instanceof CrewSequencePositionDetail))
         return false;

      CrewSequencePositionDetail that = (CrewSequencePositionDetail)o;

      if (sequenceKey != null ? !sequenceKey.equals(that.sequenceKey) : that.sequenceKey != null)
         return false;
      if (actualSequenceStartDate != null ? !actualSequenceStartDate.equals(that.actualSequenceStartDate) :
         that.actualSequenceStartDate != null)
         return false;
      if (actualSequenceEndDate != null ? !actualSequenceEndDate.equals(that.actualSequenceEndDate) :
         that.actualSequenceEndDate != null)
         return false;
      if (eventDate != null ? !eventDate.equals(that.eventDate) : that.eventDate != null)
         return false;
      return flownSequenceMinutes != null ? flownSequenceMinutes.equals(that.flownSequenceMinutes) :
         that.flownSequenceMinutes == null;
   }

   @Override
   public int hashCode()
   {
      int result = sequenceKey != null ? sequenceKey.hashCode() : 0;
      result = 31 * result + (actualSequenceStartDate != null ? actualSequenceStartDate.hashCode() : 0);
      result = 31 * result + (actualSequenceEndDate != null ? actualSequenceEndDate.hashCode() : 0);
      result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
      result = 31 * result + (flownSequenceMinutes != null ? flownSequenceMinutes.hashCode() : 0);
      return result;
   }
}
