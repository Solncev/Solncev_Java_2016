package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class Request {
    private long id;
    private long needy_id;
    private long volunteer_id;
    private String address;
    private double latitude;
    private double longitude;
    private String created_at;
    private String service_type;
    private String status;

    public Request(long id, long needy_id, long volunteer_id, String address, double latitude, double longitude, String created_at, String service_type, String status) {
        this.id = id;
        this.needy_id = needy_id;
        this.volunteer_id = volunteer_id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.created_at = created_at;
        this.service_type = service_type;
        this.status = status;
    }

    public Request(long needy_id, long volunteer_id, String address, double latitude, double longitude, String created_at, String service_type, String status) {
        this.needy_id = needy_id;
        this.volunteer_id = volunteer_id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.created_at = created_at;
        this.service_type = service_type;
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

    public long getNeedy_id() {
        return needy_id;
    }

    public void setNeedy_id(long needy_id) {
        this.needy_id = needy_id;
    }

    public long getVolunteer_id() {
        return volunteer_id;
    }

    public void setVolunteer_id(long volunteer_id) {
        this.volunteer_id = volunteer_id;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
