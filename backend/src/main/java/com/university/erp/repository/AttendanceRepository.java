package com.university.erp.repository;

import com.university.erp.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List; // 👑 නිවැරදි ජාවා ලිස්ට් එක ඉම්පෝර්ට් කළා

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // 👑 Spring Data JPA එකට අද දිනට අදාළ දත්ත හොයන්න 'findBy' කෑල්ල නිවැරදිව එකතු කළා:
    List<Attendance> findByAttendanceDate(LocalDate attendanceDate);
}