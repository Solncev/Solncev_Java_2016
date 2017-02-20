package com.solncev.entity.impl;

import com.solncev.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Марат on 18.02.2017.
 */
public class Textbook implements Book {
    private String name;

    @Autowired
    public Textbook(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("read textbook");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
