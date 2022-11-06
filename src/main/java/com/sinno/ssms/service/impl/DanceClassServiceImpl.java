package com.sinno.ssms.service.impl;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;
import com.sinno.ssms.model.entity.StudentAttendanceEntity;
import com.sinno.ssms.model.entity.StudentAttendanceId;
import com.sinno.ssms.repository.DanceClassRepository;
import com.sinno.ssms.repository.StudentAttendanceRepository;
import com.sinno.ssms.service.DanceClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sinno.ssms.mapper.DanceClassMapper.DANCE_CLASS_MAPPER;

@Service
public class DanceClassServiceImpl implements DanceClassService {

    @Autowired
    DanceClassRepository repository;

    @Autowired
    StudentAttendanceRepository studentAttendanceRepository;

    @Override
    public DanceClassEntity createDanceClass(DanceClassDTO dto) {
        return repository.save(DANCE_CLASS_MAPPER.dto2entity(dto));
    }

    @Override
    public DanceClassDTO getById(int id) {
        DanceClassEntity classEntity = repository.findById(id).orElse(null);
        DanceClassDTO classDTO = DANCE_CLASS_MAPPER.entity2dto(classEntity);

        classDTO.getStudentList()
                .forEach(studentDTO -> {
                    StudentAttendanceEntity studentAttendanceEntity = studentAttendanceRepository.findById(new StudentAttendanceId(studentDTO.getId(), id)).orElse(null);
                    studentDTO.setAttendanceCount(studentAttendanceEntity.getCount());
                });

        return classDTO;
    }

}
