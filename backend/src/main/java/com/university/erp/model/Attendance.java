package com.university.erp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="attendance")
@Getter
@Setter

public class Attendance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name="student_id",nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id",nullable=false)
    private Course course;

    @Column(name="attendance_date",nullable=false)
    private LocalDate attendanceDate;

    @Column(name="status",nullable=false)
    private String status;
    //Store Present and Absent

    public Attendance(){

    }

    public Attendance(Student student, Course course, LocalDate attendanceDate, String status){
        this.student = student;
        this.course = course;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }
}
