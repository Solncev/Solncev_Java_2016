package com.solncev.entity.impl;

import com.solncev.entity.Bag;

/**
 * Created by Марат on 18.02.2017.
 */
public class Satchel implements Bag {
    private String color;

    @Override
    public void carry() {
        System.out.println("carry satchel");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
