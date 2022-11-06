package com.sinno.ssms.service;

import com.sinno.ssms.model.dto.AttendanceDTO;
import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.entity.AttendanceEntity;
import com.sinno.ssms.model.entity.DanceClassEntity;

public interface AttendanceService {
    AttendanceEntity addAttendance(AttendanceDTO attendanceDTO);

    AttendanceEntity getById(int tutorId, int classId);

    AttendanceEntity removeAttendance(AttendanceDTO attendanceDTO);
}
