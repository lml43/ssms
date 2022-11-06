package com.sinno.ssms.service.impl;

import com.sinno.ssms.model.dto.AttendanceDTO;
import com.sinno.ssms.model.entity.*;
import com.sinno.ssms.repository.AttendanceRepository;
import com.sinno.ssms.repository.DanceClassRepository;
import com.sinno.ssms.repository.StudentAttendanceRepository;
import com.sinno.ssms.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository tutorRepository;

    @Autowired
    private StudentAttendanceRepository studentRepository;

    @Autowired
    private DanceClassRepository danceClassRepository;

    @Override
    public AttendanceEntity addAttendance(AttendanceDTO attendanceDTO) {
        AttendanceEntity byId = getById(attendanceDTO.getTutorId(), attendanceDTO.getDanceClassId());

        if (byId == null) {
            return null;
        }

        List<LocalDate> dates = byId.getDates();
        dates.add(attendanceDTO.getDateToProcess());

        updateStudentAttendance(attendanceDTO, 1);

        return tutorRepository.save(byId);
    }

    private void updateStudentAttendance(AttendanceDTO attendanceDTO, int increment) {
        DanceClassEntity danceClass = danceClassRepository.findById(attendanceDTO.getDanceClassId()).orElse(null);
        Set<StudentEntity> studentList = danceClass.getStudentList();
        studentList.stream().map(StudentEntity::getId)
                .map(id -> new StudentAttendanceId(id, attendanceDTO.getDanceClassId()))
                .map(id -> studentRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .peek(stu -> stu.setCount(Math.max(stu.getCount() + increment, 0)))
                .forEach(studentRepository::save);
    }

    @Override
    public AttendanceEntity getById(int tutorId, int classId) {
        AttendanceId attendanceId = new AttendanceId(tutorId, classId);
        return tutorRepository.findById(attendanceId).orElse(null);
    }

    @Override
    public AttendanceEntity removeAttendance(AttendanceDTO attendanceDTO) {
        AttendanceEntity byId = getById(attendanceDTO.getTutorId(), attendanceDTO.getDanceClassId());

        if (byId == null) {
            return null;
        }

        List<LocalDate> dates = byId.getDates();
        dates.remove(attendanceDTO.getDateToProcess());

        updateStudentAttendance(attendanceDTO, -1);

        return tutorRepository.save(byId);
    }
}
