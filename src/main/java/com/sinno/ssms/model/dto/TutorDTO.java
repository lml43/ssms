package com.sinno.ssms.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sinno.ssms.model.entity.PayHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TutorDTO {

    Integer id;

    String fullName;

    String nickname;

    Date dateOfBirth;

    String email;

    String phoneNumber;

    String citizenId;

    String accountNumber;

    String bankName;

    int salary;

    List<PayHistory> payHistoryList;

    List<DanceClassDTO> classList;

}
