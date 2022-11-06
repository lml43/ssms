package com.sinno.ssms.model.dto;

import com.sinno.ssms.model.entity.BaseEntity;
import com.sinno.ssms.model.entity.StudentEntity;
import com.sinno.ssms.model.entity.TutorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DanceClassDTO extends BaseEntity {

    TutorDTO tutor;

    String className;

    Set<StudentDTO> studentList;

}
