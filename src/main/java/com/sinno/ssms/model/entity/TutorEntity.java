package com.sinno.ssms.model.entity;

import com.fasterxml.jackson.annotation.*;
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
@Table(name = "tutors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","classList"})
public class TutorEntity extends BaseEntity {

    @Column(nullable = false)
    String fullName;

    String nickname;

    Date dateOfBirth;

    String email;

    String phoneNumber;

    int salary;

    String citizenId;

    String accountNumber;

    String bankName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = PayHistory.class, mappedBy = "tutor",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<PayHistory> payHistoryList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = DanceClassEntity.class, mappedBy = "tutor",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<DanceClassEntity> classList;
}
