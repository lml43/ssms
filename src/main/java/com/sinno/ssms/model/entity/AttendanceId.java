package com.sinno.ssms.model.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceId implements Serializable {

    Integer tutorId;

    Integer danceClassId;

}
