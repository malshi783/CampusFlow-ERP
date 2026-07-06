package com.university.erp.controller;


import com.university.erp.model.Student;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;


@Controller
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    //when submitting the html form dta going to the sql database
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {

        if(student.getEnrollmentDate()==null){
            student.setEnrollment(LocalDate.now());

        }
        studentRepository.save(student);

        return "redirect:/student";
    }


}
