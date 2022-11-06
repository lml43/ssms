package com.sinno.ssms.model.dto;

import com.sinno.ssms.model.entity.FeeHistory;
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
public class StudentDTO {

    Integer id;

    String fullName;

    String nickname;

    Date dateOfBirth;

    String email;

    String phoneNumber;

    String parentName;

    List<FeeHistoryDTO> feeHistoryList;

    Integer attendanceCount;

}
