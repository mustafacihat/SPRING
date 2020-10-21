package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

    private ExtraSessions officeHours;

    public ExtraSessions getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(ExtraSessions officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+(20 + officeHours.getHours()));
    }
}
