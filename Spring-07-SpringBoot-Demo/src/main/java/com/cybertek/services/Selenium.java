package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    @Value("${instructor}")
    private String instructorName;

    @Override
    public String toString() {
        return "Selenium{" +
                "instructor='" + instructorName + '\'' +
                '}';
    }

    @Autowired
    @Qualifier("mockInterviewHours")
    private ExtraSession extraSession;

    @Override
    public int getTeachingHours() {
        return 5 + extraSession.getHours();
    }
}
