package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class Request {
    private long id;
    private long needyId;
    private long volunteerId;
    private String address;
    private double latitude;
    private double longitude;
    private String createdAt;
    private String serviceType;
    private String status;

    public Request(long id, long needyId, long volunteerId, String address, double latitude, double longitude, String createdAt, String serviceType, String status) {
        this(needyId, volunteerId, address, latitude, longitude, createdAt, serviceType, status);
        this.id = id;
    }

    public Request(long needyId, long volunteerId, String address, double latitude, double longitude, String createdAt, String serviceType, String status) {
        this.needyId = needyId;
        this.volunteerId = volunteerId;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.serviceType = serviceType;
        this.status = status;
    }

    public Request() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNeedyId() {
        return needyId;
    }

    public void setNeedyId(long needyId) {
        this.needyId = needyId;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
