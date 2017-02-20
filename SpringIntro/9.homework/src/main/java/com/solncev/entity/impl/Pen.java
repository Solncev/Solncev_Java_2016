package com.solncev.entity.impl;

import com.solncev.entity.Stationery;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Марат on 18.02.2017.
 */
public class Pen implements Stationery {
    private String color;

    @Autowired
    public Pen(String color) {
        this.color = color;
    }

    @Override
    public void write() {
        System.out.println("pen write");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
