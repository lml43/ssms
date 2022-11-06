package com.sinno.ssms.controller;

import com.sinno.ssms.model.dto.StudentDTO;
import com.sinno.ssms.model.entity.PayHistory;
import com.sinno.ssms.model.entity.StudentEntity;
import com.sinno.ssms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.sinno.ssms.mapper.StudentMapper.STUDENT_MAPPER;

@RestController
@CrossOrigin
@RequestMapping(path = "/student")
public class StudentController
{

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        List<StudentEntity> students = studentService.getAll();
        List<StudentDTO> studentDTOS = students.stream()
                .map(STUDENT_MAPPER::entity2dto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(studentDTOS);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity student = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(STUDENT_MAPPER.entity2dto(student));
    }

}