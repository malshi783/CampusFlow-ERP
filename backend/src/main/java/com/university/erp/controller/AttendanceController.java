package com.university.erp.controller;

import com.university.erp.model.Attendance;
import com.university.erp.model.Course;
import com.university.erp.model.Student;
import com.university.erp.repository.AttendanceRepository;
import com.university.erp.repository.CourseRepository;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public String showAttendancePage(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("todayDate", LocalDate.now());
        model.addAttribute("existingAttendance", attendanceRepository.findByAttendanceDate(LocalDate.now()));
        return "attendance";
    }

    @PostMapping("/save")
    public String saveAttendance(
            @RequestParam("courseId") Long courseId,
            @RequestParam("attendanceDate") String dateStr,
            @RequestParam("studentIds") List<Long> studentIds,
            jakarta.servlet.http.HttpServletRequest request) {

        Course course = courseRepository.findById(courseId).orElse(null);
        LocalDate date = LocalDate.parse(dateStr);

        if (course != null && studentIds != null) {
            for (Long sId : studentIds) {
                Student student = studentRepository.findById(sId).orElse(null);
                String currentStatus = request.getParameter("status_" + sId);

                if (student != null && currentStatus != null) {
                    Attendance attendance = new Attendance(student, course, date, currentStatus);
                    attendanceRepository.save(attendance);
                }
            }
        }
        return "redirect:/attendance?success";
    }
}