package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.AttendanceEntity;
import com.sinno.ssms.model.entity.AttendanceId;
import com.sinno.ssms.model.entity.DanceClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<AttendanceEntity, AttendanceId> {

}
