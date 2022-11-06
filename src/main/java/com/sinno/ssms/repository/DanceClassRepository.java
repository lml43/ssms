package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.DanceClassEntity;
import com.sinno.ssms.model.entity.TutorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceClassRepository extends CrudRepository<DanceClassEntity, Integer> {

}
