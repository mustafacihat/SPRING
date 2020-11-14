package com.cybertek.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value= "/java")
    public String getRequestMapping2() {
        return "java-features";
    }

    @RequestMapping(method = RequestMethod.POST, value= "/ozzy")
    public String getRequestMapping3() {
        return "home";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "home";
    }

    @PostMapping("/spring")
    public String postMappingEx(){
        return "java-features";
    }

    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){

        System.out.println("name is: " + name );
        return "java-features";
    }
    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name") String name, @PathVariable("email") String email){

        System.out.println("name is: " + name );
        System.out.println("email is " + email);
        return "java-features";
    }

    @GetMapping("home/course")
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("name is : " + course);
        return "home";
    }

    @GetMapping(value = "/home/course2")
    public String requestParam2(@RequestParam(value = "course2", required = false,defaultValue = "Cybertek") String name){
        System.out.println("name is: " + name);
        return "home";
    }

}
