package com.university.erp;

import com.university.erp.model.Course;
import com.university.erp.repository.CourseRepository;
import com.university.erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String...args) {
        //Check the Database Is data Have or No?
        if (courseRepository.count() == 0) {
            System.out.println("Initializing  Default University Courses into MYSQL....");

            courseRepository.save(new Course("SE201", "Algorithms and Complexity", 4));
            courseRepository.save(new Course("SE202", "Introduction Software Engineering", 4));
            courseRepository.save(new Course("SE203", "Operating System", 3));

            System.out.println("Default University Courses Saved Successfully....");
        }
            else{
                System.out.println("Database Already Contains with Data.Skipping Initialization...");
            }

        }
    }


