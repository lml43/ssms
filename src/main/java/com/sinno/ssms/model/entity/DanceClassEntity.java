package com.sinno.ssms.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dance_class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DanceClassEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tutor", referencedColumnName = "id")
    TutorEntity tutor;

    String className;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = StudentEntity.class)
    Set<StudentEntity> studentList;

}
