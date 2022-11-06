package com.sinno.ssms.service.impl;

import com.sinno.ssms.model.dto.StudentDTO;
import com.sinno.ssms.model.entity.StudentEntity;
import com.sinno.ssms.repository.StudentRepository;
import com.sinno.ssms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.sinno.ssms.mapper.StudentMapper.STUDENT_MAPPER;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;


    @Override
    public StudentEntity createStudent(StudentDTO dto) {
        StudentEntity entity = STUDENT_MAPPER.dto2entity(dto);
        return repository.save(entity);
    }

    @Override
    public StudentEntity getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<StudentEntity> getAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentEntity> getAllIn(List<Integer> studentIds) {
        return StreamSupport
                .stream(repository.findAllById(studentIds).spliterator(), false)
                .collect(Collectors.toList());
    }

}
