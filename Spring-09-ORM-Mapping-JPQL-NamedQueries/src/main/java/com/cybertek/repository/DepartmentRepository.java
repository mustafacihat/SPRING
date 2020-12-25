package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentByDivisionIn(List<String> divisions);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String query);















    //Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //Display all departments in the Health Division
    List<Department>findByDivision(String division);

    //Display all departments in the Health Division
    List<Department> findByDivisionIs(String division);

    //Display all departments in the Health Division
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

}
