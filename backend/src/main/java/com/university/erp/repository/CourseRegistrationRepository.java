package com.university.erp.repository;

import com.university.erp.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    // සරලවම JpaRepository එක Extend කිරීමෙන් SQL Queries ස්වයංක්‍රීයව හැදේ!
}