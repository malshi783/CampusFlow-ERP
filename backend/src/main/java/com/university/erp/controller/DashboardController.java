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

    // 1. Home Application Hub Portal
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    // 2. Core Login Gateway
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 3. Main Board View
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "dashboard";
    }

    // 👑 ගැටුම ඇති කරපු /exams mapping එක මෙතනින් සම්පූර්ණයෙන්ම ඉවත් කළා!
    // දැන් ඒ පිටුව සහ දත්ත සියල්ලම ExamController එක හරහා නිවැරදිව පාලනය වේවි.
}