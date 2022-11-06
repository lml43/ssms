package com.sinno.ssms.controller;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.dto.TutorDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;
import com.sinno.ssms.model.entity.PayHistory;
import com.sinno.ssms.model.entity.TutorEntity;
import com.sinno.ssms.service.AttendanceService;
import com.sinno.ssms.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sinno.ssms.mapper.TutorMapper.TUTOR_MAPPER;

@RestController
@CrossOrigin
@RequestMapping(path = "/tutor")
public class TutorController
{

    @Autowired
    TutorService tutorService;

    @GetMapping("/{id}")
    public TutorDTO getUserById(@PathVariable int id)
    {
        TutorEntity byId = tutorService.getById(id);

        TutorDTO tutorDTO = TUTOR_MAPPER.entity2dto(byId);

        List<PayHistory> payHistoryList = tutorDTO.getPayHistoryList();
        if (payHistoryList != null) {
            payHistoryList.forEach(payHistory -> payHistory.setTutor(null));
        }

        List<DanceClassDTO> classList = tutorDTO.getClassList();
        if (classList != null) {
            classList.forEach(cl -> cl.setTutor(null));
        }

        return tutorDTO;
    }

}