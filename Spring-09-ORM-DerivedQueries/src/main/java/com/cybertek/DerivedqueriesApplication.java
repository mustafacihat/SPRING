package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {

        SpringApplication.run(DerivedqueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println("-------Regions Start---------");
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByCountry: " + regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-------Regions End---------");
    }

    @PostConstruct
    public void testDepartments() {

        System.out.println("-------Department Start---------");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Outdoors"));
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContaining: "
                + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("-------Department End---------");
    }

    @PostConstruct
    public void testEmployees() {

        System.out.println("-------Employee Start---------");
        System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());
        System.out.println("-------Employee End---------");

        //System.out.println(employeeRepository.getEmployeeDetail("apaddisonv@lulu.com"));
    }

}
