package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class Community {
    private long id;
    private String name;
    private String description;
    private long founder_id;
    private String created_at;

    public Community(long id, String name, String description, long founder_id, String created_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.founder_id = founder_id;
        this.created_at = created_at;
    }

    public Community(String name, String description, long founder_id, String created_at) {
        this.name = name;
        this.description = description;
        this.founder_id = founder_id;
        this.created_at = created_at;
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

    public long getFounder_id() {
        return founder_id;
    }

    public void setFounder_id(long founder_id) {
        this.founder_id = founder_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
