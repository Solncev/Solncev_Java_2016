package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class Community {
    private long id;
    private String name;
    private String description;
    private long founderId;
    private String createdAt;

    public Community(long id, String name, String description, long founderId, String createdAt) {
        this(name, description, founderId, createdAt);
        this.id = id;
    }

    public Community(String name, String description, long founderId, String createdAt) {
        this.name = name;
        this.description = description;
        this.founderId = founderId;
        this.createdAt = createdAt;
    }

    public Community() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFounderId() {
        return founderId;
    }

    public void setFounderId(long founderId) {
        this.founderId = founderId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
