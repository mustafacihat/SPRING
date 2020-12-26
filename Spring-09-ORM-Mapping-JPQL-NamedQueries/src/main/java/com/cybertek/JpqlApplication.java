package com.cybertek;

import com.cybertek.entity.Region;
import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RegionRepository regionRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpqlApplication.class, args);
    }

    @PostConstruct
    public void testEmployee(){
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("abendelowg@google.com.hk"));
        employeeRepository.updateEmployeeJPQL(5L);

        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));
        System.out.println( regionRepository.findAllRegionsByCountry("Canada"));
        System.out.println(regionRepository.findAllRegions());

        System.out.println(departmentRepository.findAllDepartment());

        System.out.println(departmentRepository.findOzzyDepartment("Kids"));

        System.out.println(departmentRepository.countAllDepartments());



    }

}
