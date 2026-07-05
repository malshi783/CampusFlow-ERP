package com.university.erp.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="exams")

public class Exam
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long examId;


    @ManyToOne
    @JoinColumn(name="studentId",nullable=false)
    private Student student;

    @ManyToOne
    private Course course;


    @Column(name="marks_obtained",nullable=false)
    private Double markObtained;


    @Column(name="exam_date",nullable=false)
    private LocalDate examDate;

    public Exam(){

    }
    public Exam(Student student, Course course, Double markObtained, LocalDate examDate) {
        this.student = student;
        this.course = course;
        this.markObtained = markObtained;
        this.examDate = examDate;

    }


}
