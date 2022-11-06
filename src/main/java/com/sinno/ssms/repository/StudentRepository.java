package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.StudentEntity;
import com.sinno.ssms.model.entity.TutorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
