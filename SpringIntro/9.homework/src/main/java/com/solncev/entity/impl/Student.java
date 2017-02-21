package com.solncev.entity.impl;

import com.solncev.entity.Bag;
import com.solncev.entity.Learner;
import com.solncev.entity.Stationery;

/**
 * Created by Марат on 18.02.2017.
 */
public class Student implements Learner {
    private String name;
    private Stationery stationery;
    private Bag bag;

    public Student(String name, Stationery stationery, Bag bag) {
        this.name = name;
        this.stationery = stationery;
        this.bag = bag;
    }

    @Override
    public void learn() {
        System.out.println(name + " learn something");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stationery getStationery() {
        return stationery;
    }

    public void setStationery(Stationery stationery) {
        this.stationery = stationery;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
