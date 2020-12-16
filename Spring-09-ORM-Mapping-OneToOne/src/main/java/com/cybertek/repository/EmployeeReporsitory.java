package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReporsitory extends JpaRepository<Employee,String > {
}
