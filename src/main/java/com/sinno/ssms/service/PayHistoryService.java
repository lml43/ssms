package com.sinno.ssms.service;

import com.sinno.ssms.model.entity.PayHistory;

import java.time.LocalDate;
import java.util.List;

public interface PayHistoryService {

    List<PayHistory> findByTutorId(long tutorId);

    LocalDate getLastPayDateByTutor(long tutorID);
}
