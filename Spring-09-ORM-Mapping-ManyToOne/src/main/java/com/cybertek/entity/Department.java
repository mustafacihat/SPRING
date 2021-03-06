package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department extends BaseEntity{

    private String department;
    private String division;



    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
