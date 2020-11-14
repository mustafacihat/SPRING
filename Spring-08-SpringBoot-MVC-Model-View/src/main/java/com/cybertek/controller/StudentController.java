package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "mike");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        //create some random studentid (0-1000) and show it in your UI


        int studentId = new Random().nextInt(1001);

        model.addAttribute("id", studentId);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, 7,200,700));

        model.addAttribute("numbers", numbers);

        LocalDate birthDay = LocalDate.now().minusYears(40);
        model.addAttribute("birthday", birthDay);

        Student student= new Student(1,"Mike","Smith");
        model.addAttribute("student",student);

        List<String> courseList = new ArrayList<>(Arrays.asList("Java","Selenium","Spring","Api"));
        model.addAttribute("list",courseList);

        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2(){
        return "student/register";
    }
}
