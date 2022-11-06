package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.PayHistory;
import com.sinno.ssms.model.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PayHistoryRepository extends CrudRepository<PayHistory, Long> {
    List<PayHistory> findByTutorId(long tutorId);

    @Query(value = "select max(ph.\"date\") \n" +
            "from pay_history ph \n" +
            "where tutor_id = :tutorId",
            nativeQuery = true)
    Timestamp findLastPayDateByTutor(@Param("tutorId") Long tutorId);
}
