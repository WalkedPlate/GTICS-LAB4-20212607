package com.example.gticslab420212607.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobHistory {

    @Id
    @Column(name="job_history_id",nullable = false)
    private Integer departmentId;

    @Id
    @Column(name="start_date",nullable = false)
    private String startDate;


    @Column(name="start_date",nullable = true)
    private String departmentName;


    @ManyToOne
    @JoinColumn(name = "dapartments")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "jobs")
    private Jobs jobs;

    @ManyToOne
    @JoinColumn(name = "employees")
    private Employees employee;
}
