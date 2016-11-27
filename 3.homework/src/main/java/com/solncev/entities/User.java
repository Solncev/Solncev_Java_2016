package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class User {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private String status;

    public User() {

    }

    public User(long id, String name, String surname, String email, String password, String role, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User(String name, String surname, String email, String password, String role, String status) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String toString() {
        return "id=" + this.getId() + "; name=" + this.getName() + "; surname=" + this.getSurname()
                + "; email=" + this.getEmail() + "; password=" + this.getPassword() + "; role=" + this.getRole()
                + "; status= " + this.getStatus();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
