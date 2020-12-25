package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.email = 'acurwood6@1und1.de'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='acurwood6@1und1.de'")
    Integer getEmployeeSalary();

    //single bind parameter
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);

    //multiple bind parameter
    @Query("select e from Employee e where e.email = ?1 and e.salary=?2")
    Optional<Employee> getEmployeeByEmailAndSalary(String email, Integer salary);

    //signle named parameter
    @Query("select e from Employee e where e.salary =: salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //multiple named parameters
    @Query("select e from Employee e where e.firstName=:name or e.salary=: salary ")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String firstName, @Param("salary") int salary);

    //not Equal

    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //Like / Contains / Startswith / Ends with
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //Less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    //Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    //Before
    @Query("select e from Employee e where e.hireDate > ?1 ")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();

    //Sort salary in ascending order
    @Query("select e from Employee e order by e.salary asc ")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //Sort Salary in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeBySalaryOrderByDesc();




















/*    //Display all employees with email address ''
    List<Employee> findByEmail(String email);

    //Display all employees with first name '' and last name '', also show all employees with a email address ''
    List<Employee>findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees with first name is not ''
    List<Employee>findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ''
    List<Employee>findByLastNameStartingWith(String lastName);

    //Display all employees salaries higher than ''
    List<Employee>findBySalaryGreaterThan(Integer salary);

    //Display all employees salaries less and equal than ''
    List<Employee>findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee>findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to '' in order
    List<Employee>findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee>findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee>findByEmailIsNull();*/

    /*@Query("SELECT e from Employee  e WHERE e.email = ?1")
    Employee getEmployeeDetail(String email);*/
}
