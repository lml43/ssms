package com.sinno.ssms.controller;

import com.sinno.ssms.model.dto.AttendanceDTO;
import com.sinno.ssms.model.entity.AttendanceEntity;
import com.sinno.ssms.service.AttendanceService;
import com.sinno.ssms.service.PayHistoryService;
import com.sinno.ssms.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sinno.ssms.mapper.AttendanceMapper.ATTENDANCE_MAPPER;

@RestController
@CrossOrigin
@RequestMapping(path = "/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    PayHistoryService payHistoryService;

    @GetMapping("/{tutorId}/{classId}")
    public ResponseEntity<AttendanceDTO> getUserById(@PathVariable int tutorId, @PathVariable int classId) {
        AttendanceEntity byId = attendanceService.getById(tutorId, classId);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }

        LocalDate lastPayDate = payHistoryService.getLastPayDateByTutor(tutorId);

        AttendanceDTO dto = ATTENDANCE_MAPPER.entity2dto(byId);
        filterAttendance(lastPayDate, dto);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/")
    public ResponseEntity<AttendanceDTO> addAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        AttendanceEntity attendanceEntity = attendanceService.addAttendance(attendanceDTO);
        if (attendanceEntity == null) {
            return ResponseEntity.notFound().build();
        }

        LocalDate lastPayDate = payHistoryService.getLastPayDateByTutor(attendanceDTO.getTutorId());
        AttendanceDTO dto = ATTENDANCE_MAPPER.entity2dto(attendanceEntity);
        filterAttendance(lastPayDate, dto);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{tutorId}/{classId}/{dateStr}")
    public ResponseEntity<AttendanceDTO> deleteAttendance(@PathVariable int tutorId,
                                                          @PathVariable int classId, @PathVariable String dateStr
    ) {
        LocalDate date = DateTimeUtil.getDate(dateStr);
        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setTutorId(tutorId);
        attendanceDTO.setDanceClassId(classId);
        attendanceDTO.setDateToProcess(date);

        AttendanceEntity attendanceEntity = attendanceService.removeAttendance(attendanceDTO);
        if (attendanceEntity == null) {
            return ResponseEntity.notFound().build();
        }

        LocalDate lastPayDate = payHistoryService.getLastPayDateByTutor(attendanceDTO.getTutorId());
        AttendanceDTO dto = ATTENDANCE_MAPPER.entity2dto(attendanceEntity);
        filterAttendance(lastPayDate, dto);

        return ResponseEntity.ok(dto);
    }

    private void filterAttendance(LocalDate lastPayDate, AttendanceDTO dto) {
        if (lastPayDate == null) {
            return;
        }

        List<LocalDate> attendanceAfterLastPayDate = dto.getDates().stream()
                .filter(onlyAfter(lastPayDate))
                .collect(Collectors.toList());

        dto.setDates(attendanceAfterLastPayDate);
    }

    private Predicate<LocalDate> onlyAfter(LocalDate localDate) {
        return date -> date.isAfter(localDate);
    }

}