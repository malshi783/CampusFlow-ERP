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

    // 1. පිටුව මුලින්ම load වන විට ශිෂ්‍ය ලැයිස්තුව සහ අද දිනය ලබාදීම
    @GetMapping
    public String showAttendancePage(Model model) {
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();

        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        model.addAttribute("todayDate", LocalDate.now()); // HTML එකේ th:value="${todayDate}" සඳහා

        return "attendance";
    }

    // 2. 👑 HTML එකෙන් එන dynamic රේඩියෝ බොත්තම් (status_1, status_2) කියවා සේව් කරන මෙතඩ් එක
    @PostMapping("/save")
    public String saveAttendance(
            @RequestParam("courseId") Long courseId,
            @RequestParam("attendanceDate") String dateStr,
            @RequestParam("studentIds") List<Long> studentIds,
            jakarta.servlet.http.HttpServletRequest request) { // HttpServletRequest මඟින් dynamic parameters කියවයි

        Course course = courseRepository.findById(courseId).orElse(null);
        LocalDate date = LocalDate.parse(dateStr);

        if (course != null && studentIds != null) {
            for (Long sId : studentIds) {
                Student student = studentRepository.findById(sId).orElse(null);

                // 👑 HTML එකේ තියෙන 'status_1', 'status_2' අගයන් වෙන වෙනම කියවා ගැනීම
                String currentStatus = request.getParameter("status_" + sId);

                if (student != null && currentStatus != null) {
                    Attendance attendance = new Attendance();
                    attendance.setStudentId(student.getStudentId());
                    attendance.setCourseId(course.getCourseId());
                    attendance.setAttendanceDate(date);
                    attendance.setStatus(currentStatus);

                    attendanceRepository.save(attendance);
                }
            }
        }
        // සාර්ථකව සේව් වූ පසු නැවතත් පිටුවටම හරවා යැවීම
        return "redirect:/attendance?success";
    }
}