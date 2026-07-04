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


    @GetMapping("/")
    public String viewDashboard(Model model) {

        //Fetch all students from database and send them to the UI
        model.addAttribute("students", studentRepository.findAll());
        return "dashboard";
    }


}
