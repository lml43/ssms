package com.sinno.ssms.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity extends BaseEntity {

    @Column(nullable = false)
    String fullName;

    String nickname;

    Date dateOfBirth;

    String email;

    String phoneNumber;

    String parentName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = FeeHistory.class,mappedBy = "student")
    List<FeeHistory> feeHistoryList;

}
