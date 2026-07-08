package com.university.erp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "marks_obtained", nullable = false)
    private Double marksObtained;

    @Column(name = "exam_date", nullable = false)
    private LocalDate examDate;

    // Default Constructor
    public Exam() {
    }

    // --- GETTERS AND SETTERS (මේවා අනිවාර්යයෙන්ම තිබිය යුතුයි!) ---

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}