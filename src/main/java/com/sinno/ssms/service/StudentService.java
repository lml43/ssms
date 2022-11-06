package com.sinno.ssms.service;

import com.sinno.ssms.model.dto.StudentDTO;
import com.sinno.ssms.model.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity createStudent(StudentDTO dto);

    StudentEntity getById(int id);

    List<StudentEntity> getAll();

    List<StudentEntity> getAllIn(List<Integer> studentIds);

}
