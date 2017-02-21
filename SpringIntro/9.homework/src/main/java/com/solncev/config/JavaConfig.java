package com.solncev.config;

import com.solncev.entity.Bag;
import com.solncev.entity.Learner;
import com.solncev.entity.Pedagogue;
import com.solncev.entity.Stationery;
import com.solncev.entity.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Марат on 18.02.2017.
 */
@Configuration
public class JavaConfig {
    @Bean
    public Bag bag() {
        Satchel satchel = new Satchel();
        return satchel;
    }

    @Bean
    public Textbook book() {
        Textbook textbook = new Textbook("math");
        return textbook;
    }

    @Bean
    public Stationery stationery() {
        Pen pen = new Pen("black");
        return pen;
    }

    @Bean
    public Learner learner() {
        Student student = new Student("abbos", stationery(), bag());
        return student;
    }

    @Bean
    public Pedagogue pedagogue() {
        Teacher teacher = new Teacher("Arslanov", "math");
        return teacher;
    }
}
