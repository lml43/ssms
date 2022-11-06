package com.sinno.ssms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pay_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    TutorEntity tutor;

    LocalDate date;

    int amount;

}
