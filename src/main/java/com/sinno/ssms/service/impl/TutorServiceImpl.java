package com.sinno.ssms.service.impl;

import com.sinno.ssms.mapper.TutorMapper;
import com.sinno.ssms.model.dto.TutorDTO;
import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.model.entity.TutorEntity;
import com.sinno.ssms.repository.TutorRepository;
import com.sinno.ssms.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sinno.ssms.mapper.TutorMapper.TUTOR_MAPPER;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    TutorRepository repository;

    @Override
    public TutorEntity createTutor(TutorDTO dto) {
        return repository.save(TUTOR_MAPPER.dto2entity(dto));
    }

    @Override
    public TutorEntity getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<TutorEntity> getAll() {
        return null;
    }

}
