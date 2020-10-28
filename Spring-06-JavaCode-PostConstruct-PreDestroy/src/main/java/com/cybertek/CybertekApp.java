package com.cybertek;

import com.cybertek.config.CybertekAppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

        Course javaCourse = container.getBean("java", Course.class);
        javaCourse.getTeachingHours();

        Course seleniumCourse = container.getBean("selenium",Course.class);
        seleniumCourse.getTeachingHours();

        ((AnnotationConfigApplicationContext)container).close();
    }
}
