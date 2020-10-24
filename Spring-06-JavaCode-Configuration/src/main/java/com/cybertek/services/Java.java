package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    public void getTeachingHourse() {
        System.out.println("Weekly hours is : 30 hours");
    }
}
