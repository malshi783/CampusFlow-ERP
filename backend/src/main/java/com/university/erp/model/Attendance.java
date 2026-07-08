package com.university.erp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Column(name = "status", nullable = false)
    private String status; // 'Present' හෝ 'Absent'

    // 1. 👑 Hibernate (JPA) එකට අනිවාර්යයෙන්ම අවශ්‍ය වන හිස් Constructor එක (No-arg Constructor)
    public Attendance() {
    }

    // 2. AttendanceController එකේදී අලුත් Attendance එකක් හදන්න පාවිච්චි කරන Constructor එක
    public Attendance(Student student, Course course, LocalDate date, String status) {
        this.studentId = student.getStudentId();
        this.courseId = course.getCourseId();
        this.attendanceDate = date;
        this.status = status;
    }

    // --- GETTERS AND SETTERS ---
    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}