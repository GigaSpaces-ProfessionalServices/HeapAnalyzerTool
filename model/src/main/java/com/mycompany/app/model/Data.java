//package com.mycompany.app.model;
//
//import com.gigaspaces.annotation.pojo.SpaceClass;
//import com.gigaspaces.annotation.pojo.SpaceId;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.Table;
//import java.util.Objects;
//
//@Entity
//@Table(name = "t2")
//@SpaceClass(blobstoreEnabled = true)
//public class Data implements java.io.Serializable {
//
//    private static final long serialVersionUID = 0L;
//
//    private Integer id;
//
//    @Column(name = "message", length = 255)
//    private String message;
//
//    @Column(name = "payload", length = 1024)
//    @Lob
//    private byte[] payload;
//
//    @Column(name = "processed")
//    private Boolean processed;
//
//
//    public Data() {
//    }
//
//    @Id
//    @SpaceId
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public byte[] getPayload() {
//        return payload;
//    }
//
//    public void setPayload(byte[] payload) {
//        this.payload = payload;
//    }
//
//    public Boolean getProcessed() {
//        return processed;
//    }
//
//    public void setProcessed(Boolean processed) {
//        this.processed = processed;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Data data = (Data) o;
//        return Objects.equals(id, data.id) && Objects.equals(message, data.message);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, message);
//    }
//
//    @Override
//    public String toString() {
//        return "Data{" +
//                "id=" + id +
//                ", message='" + message + '\'' +
//                ", processed=" + processed +
//                '}';
//    }
//}
