package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.Data;

@Data
public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : 15");
    }

    public void myInitMethod(){
        System.out.println("Executing init method for Selenium class");
    }

    public void myDestroyMethod(){
        System.out.println("Executing destroy method for Selenium class");
    }
}
