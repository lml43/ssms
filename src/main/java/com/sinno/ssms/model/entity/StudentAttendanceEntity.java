package com.sinno.ssms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students_attendance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceEntity {

    @EmbeddedId
    StudentAttendanceId id;

    int count;

}
