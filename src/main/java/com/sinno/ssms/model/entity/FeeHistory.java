package com.sinno.ssms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "fee_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeeHistory extends BaseEntity {

    StudentEntity student;
    Date date;
    int amount;
    int classId;

}
