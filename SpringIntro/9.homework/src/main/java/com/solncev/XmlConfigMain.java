package com.solncev;

import com.solncev.entity.impl.Pen;
import com.solncev.entity.impl.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Марат on 18.02.2017.
 */
public class XmlConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Pen pen = context.getBean("pen", Pen.class);
        pen.write();
        Student student = context.getBean("student", Student.class);
    }
}
