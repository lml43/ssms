package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.StudentAttendanceEntity;
import com.sinno.ssms.model.entity.StudentAttendanceId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAttendanceRepository extends CrudRepository<StudentAttendanceEntity, StudentAttendanceId> {

}
