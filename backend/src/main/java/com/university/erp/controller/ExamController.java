package com.university.erp.controller;

import com.university.erp.model.Course;
import com.university.erp.model.Exam;
import com.university.erp.model.Student;
import com.university.erp.repository.CourseRepository;
import com.university.erp.repository.ExamRepository;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/exams") // 👑 /exams ලෙස නිවැරදිව map කර ඇත
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public String showExamMarksPage(Model model) {
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();

        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        model.addAttribute("examDate", LocalDate.now());

        return "exams"; // 👑 Rename කරන ලද exams.html පිටුව ලෝඩ් කරයි
    }

    @PostMapping("/save") // 👑 /exams/save ලෙස නිවැරදිව වැඩ කරයි
    public String saveExamMarks(
            @RequestParam("courseId") Long courseId,
            @RequestParam("examDate") String examDateStr,
            @RequestParam("studentIds") List<Long> studentIds,
            @RequestParam("marks") List<Double> marksList) {

        Course course = courseRepository.findById(courseId).orElse(null);
        LocalDate examDate = LocalDate.parse(examDateStr);

        if (course != null && studentIds != null && marksList != null && studentIds.size() == marksList.size()) {
            for (int i = 0; i < studentIds.size(); i++) {
                Student student = studentRepository.findById(studentIds.get(i)).orElse(null);

                if (student != null) {
                    Exam exam = new Exam();
                    exam.setStudent(student);
                    exam.setCourse(course);
                    exam.setExamDate(examDate);
                    exam.setMarksObtained(marksList.get(i));

                    examRepository.save(exam);
                }
            }
        }

        // 👑 සාර්ථකව සේව් වූ පසු ?success කෑල්ල සහිතව පිටුවට හරවා යැවීම (Success Banner එක වැඩ කරන්න)
        return "redirect:/exams?success";
    }
}