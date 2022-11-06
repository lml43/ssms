package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.TutorEntity;
import com.sinno.ssms.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends CrudRepository<TutorEntity, Integer> {

}
