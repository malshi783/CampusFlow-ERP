package com.university.erp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "course_registrations")
@Getter
@Setter
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "semester", nullable = false)
    private String semester;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // Default Constructor (JPA එකට අනිවාර්යයි)
    public CourseRegistration() {
    }

    // Overloaded Constructor (Controller එකේ පාවිච්චි කරන එක)
    public CourseRegistration(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.registrationDate = LocalDate.now();
    }
}