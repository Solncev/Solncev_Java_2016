package com.solncev;

import com.solncev.config.JavaConfig;
import com.solncev.entity.Bag;
import com.solncev.entity.Learner;
import com.solncev.entity.impl.Satchel;
import com.solncev.entity.impl.Student;
import com.solncev.entity.impl.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Марат on 18.02.2017.
 */
public class JavaConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Bag bag = context.getBean(Satchel.class);
        bag.carry();
        System.out.println();
        Learner learner = context.getBean(Student.class);
        Teacher teacher = context.getBean(Teacher.class);
        teacher.teach();
    }
}
