package com.sinno.ssms.controller;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;
import com.sinno.ssms.service.DanceClassService;
import com.sinno.ssms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.sinno.ssms.mapper.DanceClassMapper.DANCE_CLASS_MAPPER;

@RestController
@CrossOrigin
@RequestMapping(path = "/class")
public class DanceClassController
{

    @Autowired
    DanceClassService danceClassService;

    @GetMapping("/{id}")
    public DanceClassDTO getById(@PathVariable int id)
    {
        return danceClassService.getById(id);
    }

}