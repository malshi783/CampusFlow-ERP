package com.university.erp.controller;

import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private StudentRepository studentRepository;

    // 1. Home Page
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    // 2. Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 3. Main Dashboard
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "dashboard";
    }

    // 4. Student Management
    @GetMapping("/student")
    public String showStudentPage(Model model) {
        model.addAttribute("student", new com.university.erp.model.Student());
        model.addAttribute("students", studentRepository.findAll());
        return "student";
    }

    // 5. Course Registration
    @GetMapping("/course-registration")
    public String showCourseRegistrationForm() {
        return "course-registration";
    }


    // 7. Exam Marks
    @GetMapping("/exam-marks")
    public String showExamMarksForm() {
        return "exam-marks";
    }
}