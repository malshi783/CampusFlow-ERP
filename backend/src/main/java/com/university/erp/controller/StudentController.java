package com.university.erp.controller;

import com.university.erp.model.Student;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // 1. /student පිටුව ලෝඩ් කරලා දෙන GET මෙතඩ් එක
    @GetMapping
    public String showStudentPage(Model model) {
        List<Student> students = studentRepository.findAll();

        model.addAttribute("students", students);
        model.addAttribute("student", new Student());

        return "student";
    }

    // 2. Form දත්ත කියවා MySQL ඩේටාබේස් එකට සේව් කරන POST මෙතඩ් එක
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {

        // 👑 ඔයාගේ Model එකේ තියෙන සැබෑ නම වන 'setEnrollment' ලෙස නිවැරදි කළා යාළුවා:
        if (student.getEnrollmentDate() == null) {
            student.setEnrollment(LocalDate.now());
        }

        studentRepository.save(student);

        return "redirect:/student";
    }
}