package com.solncev.entity.impl;

import com.solncev.entity.Pedagogue;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Марат on 18.02.2017.
 */
public class Teacher implements Pedagogue {
    private String name;
    private String subject;

    @Autowired
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void teach() {
        System.out.println(name + " teach someone");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
