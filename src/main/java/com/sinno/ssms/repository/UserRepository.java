package com.sinno.ssms.repository;

import com.sinno.ssms.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    UserEntity findById(int id);

    UserEntity findByUsername(String username);
}
