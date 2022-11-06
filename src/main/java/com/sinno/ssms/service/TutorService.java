package com.sinno.ssms.service;

import com.sinno.ssms.model.dto.TutorDTO;
import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.model.entity.TutorEntity;

import java.util.List;

public interface TutorService {
    TutorEntity createTutor(TutorDTO dto);

    TutorEntity getById(int id);

    List<TutorEntity> getAll();
}
