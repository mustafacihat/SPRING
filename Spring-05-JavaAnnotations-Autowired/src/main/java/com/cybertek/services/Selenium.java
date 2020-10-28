package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    private ExtraSessions officeHourse;

    public ExtraSessions getOfficeHourse() {
        return officeHourse;
    }

    //Setter injection
    @Autowired
    public void setOfficeHourse(OfficeHours officeHourse) {
        this.officeHourse = officeHourse;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " +  (23 + officeHourse.getHours()));
    }
}
