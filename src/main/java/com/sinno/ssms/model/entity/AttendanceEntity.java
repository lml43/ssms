package com.sinno.ssms.model.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendances")
public class AttendanceEntity implements Serializable {

    @EmbeddedId
    AttendanceId id;

    @ElementCollection
    @CollectionTable(name="attendance_dates")
    @Column(name="attendance_date")
    List<LocalDate> dates;

    int base;

}
