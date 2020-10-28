package com.cybertek;

import com.cybertek.interfaces.Course;
import com.cybertek.services.MockInterviewHours;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring07SpringBootDemoApplication {

	@Bean
	public MockInterviewHours mockInterviewHours(){
		return new MockInterviewHours();
	}
	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(Spring07SpringBootDemoApplication.class, args);

		Course javaCourse = container.getBean("java",Course.class);

		System.out.println("javaCourse.getTeachingHours() = " + javaCourse.getTeachingHours());

		Course seleniumCourse = container.getBean("selenium", Course.class);
		System.out.println("seleniumCourse.getTeachingHours() = " + seleniumCourse.getTeachingHours());

		System.out.println(seleniumCourse.toString());
	}

}
