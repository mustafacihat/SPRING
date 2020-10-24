package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //field injection
    @Autowired
    private ExtraSessions officeHourse;

    //Constructor injection
   /* @Autowired
    public Java(OfficeHourse officeHourse) {
        this.officeHourse = officeHourse;
    }*/

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " +  (30 + officeHourse.getHours()));
    }
}
