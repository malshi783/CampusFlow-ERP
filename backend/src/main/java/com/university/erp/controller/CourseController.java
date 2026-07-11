package com.university.erp.controller;

import com.university.erp.model.Course;
import com.university.erp.model.CourseRegistration;
import com.university.erp.model.Student;
import com.university.erp.repository.CourseRepository;
import com.university.erp.repository.CourseRegistrationRepository;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course-registration")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @GetMapping
    public String showRegistrationPage(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "course-registration";
    }

    @PostMapping("/register")
    public String registerCourses(
            @RequestParam("studentId") Long studentId,
            @RequestParam("semester") String semester,
            @RequestParam(value = "selectedCourses", required = false) List<Long> selectedCourses) {

        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null && selectedCourses != null) {
            for (Long cId : selectedCourses) {
                Course course = courseRepository.findById(cId).orElse(null);
                if (course != null) {
                    CourseRegistration reg = new CourseRegistration(student, course, semester);
                    courseRegistrationRepository.save(reg);
                }
            }
        }
        return "redirect:/course-registration?success";
    }
}