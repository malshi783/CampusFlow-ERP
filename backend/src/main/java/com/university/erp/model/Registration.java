package com.university.erp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="registrations")
@Getter
@Setter
public class Registration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;


    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student  student;


    @ManyToOne
    @JoinColumn ( name="course_id", nullable=false)
    private Course course;



    private LocalDate registrationDate;

    public Registration(){

    }

    public Registration(Student student, Course course, LocalDate registrationDate){
        this.student = student;
        this.course = course;
        this.registrationDate = registrationDate;

    }


}
