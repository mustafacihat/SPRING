package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@ToString

@NamedQueries({@NamedQuery(name = "Department.findAllDepartment", query = "select d from Department d order by d.department desc "),
        @NamedQuery(name = "Department.findOzzyDepartment", query = "select d from Department d where d.division =?1")})
@NamedNativeQueries({@NamedNativeQuery(name = "Department.getAllDepartments",
        query = "select * from departments", resultClass = Department.class), @NamedNativeQuery(name = "Department.countAllDepartments", query = "select count(*) from departments")})
public class Department {

    @Id
    private String department;

    private String division;

}
