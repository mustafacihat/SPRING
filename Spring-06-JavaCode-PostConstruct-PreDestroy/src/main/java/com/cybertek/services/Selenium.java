package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Teaching hours : 20");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("post construct for selenium class");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("pre destroy for selenium class");
    }
}
