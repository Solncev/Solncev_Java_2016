package com.solncev.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Марат on 19.02.2017.
 */
@Component
public class User {
    private String name;
    private String surname;
    private String patronymic;
    private Date date;
    private String gender;

    public User(String name, String surname, String patronymic, Date date, String gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date = date;
        this.gender = gender;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
