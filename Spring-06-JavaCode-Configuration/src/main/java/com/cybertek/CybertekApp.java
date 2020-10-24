package com.cybertek;

import com.cybertek.configs.CybertekAppConfig;
import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

        Course course = container.getBean("java",Course.class);

        course.getTeachingHourse();

        Course courseSelenium = container.getBean("selenium", Course.class);

        courseSelenium.getTeachingHourse();

        System.out.println(course.toString());

        ExtraSessions officeHours = container.getBean("extraSessions", ExtraSessions.class);
        System.out.println(officeHours.getHours());
    }
}
