package com.sinno.ssms.service.impl;

import com.sinno.ssms.model.entity.PayHistory;
import com.sinno.ssms.repository.PayHistoryRepository;
import com.sinno.ssms.service.PayHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class PayHistoryServiceImpl implements PayHistoryService {

    @Autowired
    PayHistoryRepository historyRepository;

    @Override
    public List<PayHistory> findByTutorId(long tutorId) {
        return historyRepository.findByTutorId(tutorId);
    }

    @Override
    public LocalDate getLastPayDateByTutor(long tutorId) {
        Timestamp lastPayDateByTutor = historyRepository.findLastPayDateByTutor(tutorId);
        return lastPayDateByTutor == null ? null : lastPayDateByTutor.toLocalDateTime().toLocalDate();
    }
}
