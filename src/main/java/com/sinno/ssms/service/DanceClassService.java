package com.sinno.ssms.service;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;

import java.util.List;

public interface DanceClassService {
    DanceClassEntity createDanceClass(DanceClassDTO dto);

    DanceClassDTO getById(int id);

}
