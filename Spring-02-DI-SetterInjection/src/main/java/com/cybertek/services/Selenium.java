package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;

@Data
public class Selenium implements Course {

    private ExtraSessions officeHours;



    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+(15 + officeHours.getHours()));
    }
}
