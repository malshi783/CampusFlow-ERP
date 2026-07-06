package com.university.erp.controller;

import com.university.erp.model.Course;
import com.university.erp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // 1. අලුත් Course එකක් ඩේටාබේස් එකට සේව් කිරීම (POST Mapping)
    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        // Form එකෙන් එන Course Code එක Capital අකුරින්ම සේව් වීමට
        if (course.getCourseCode() != null) {
            course.setCourseCode(course.getCourseCode().toUpperCase().trim());
        }

        courseRepository.save(course);

        // දත්ත සේව් වූ පසු නැවතත් Course Registration පිටුවටම හරවා යැවීම (Redirect)
        return "redirect:/course-registration";
    }

    // 2. අවශ්‍ය නම් Course එකක් මකා දැමීම සඳහා (Optional - Delete Feature)
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long courseId) {
        courseRepository.deleteById(courseId);
        return "redirect:/course-registration";
    }
}