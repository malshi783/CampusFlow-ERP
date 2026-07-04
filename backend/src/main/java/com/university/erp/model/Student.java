package com.university.erp.model;


import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long studentId;

    @Setter
    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Setter
    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Setter
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    //  Constructors
    public Student() {
    }

    public Student(String firstName, String lastName, String email, LocalDate enrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;

    }

    //Getters  and Setters
    public Long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollment(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

}



