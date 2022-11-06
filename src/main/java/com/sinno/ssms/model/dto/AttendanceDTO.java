package com.sinno.ssms.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class AttendanceDTO implements Serializable {

    Integer tutorId;

    Integer danceClassId;

    List<LocalDate> dates;

    int base;

    LocalDate dateToProcess;

}
