package com.university.erp.controller;

import com.university.erp.model.Attendance;
import com.university.erp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/attendance")
class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping("/add")
    public String markAttendance(@ModelAttribute Attendance attendance) {
        attendanceRepository.save(attendance);
        return "redirect:/attendance";
    }
}