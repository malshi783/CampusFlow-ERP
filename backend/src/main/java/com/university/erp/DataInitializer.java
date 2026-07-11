package com.university.erp;

import com.university.erp.model.Course;
import com.university.erp.model.Student;
import com.university.erp.repository.CourseRepository;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        // 1. Initializing Default University Courses
        if (courseRepository.count() == 0) {
            System.out.println("Initializing Default University Courses into MYSQL....");
            courseRepository.save(new Course("SE201", "Algorithms and Complexity", 4));
            courseRepository.save(new Course("SE202", "Introduction Software Engineering", 4));
            courseRepository.save(new Course("SE203", "Operating System", 3));
            System.out.println("Default University Courses Saved Successfully....");
        }

        // 2. Initializing Default Students (ප්‍රසන්ටේෂන් එක ලස්සන කරන්න Mock Data)
        if (studentRepository.count() == 0) {
            System.out.println("Initializing Default Students into MYSQL....");
            studentRepository.save(new Student("Malshi", "Dewmini", "smmdewmini@students.nsbm.ac.lk", LocalDate.now()));
            studentRepository.save(new Student("Sachini", "Senarathna", "sachini@students.nsbm.ac.lk", LocalDate.now()));
            studentRepository.save(new Student("Hiruni", "Weerasinghe", "hiruni@students.nsbm.ac.lk", LocalDate.now()));
            studentRepository.save(new Student("Nimal", "Perera", "nimal@students.nsbm.ac.lk", LocalDate.now()));
            System.out.println("Default Students Saved Successfully....");
        }
    }
}