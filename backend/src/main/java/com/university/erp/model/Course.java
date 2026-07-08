package com.university.erp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CourseId;

    @Column(name="course_code",unique=true,nullable=false)
    private String CourseCode;

    @Column(name="course_name",unique=true,nullable=false)
    private String CourseName;

    @Column(name="credits",nullable=false)
    private Integer credits;

    //Default Constructer
    public Course() {

    }

    public Course(String CourseCode, String CourseName, Integer credits) {
        this.CourseCode = CourseCode;
        this.CourseName = CourseName;
        this.credits = credits;

    }

}
