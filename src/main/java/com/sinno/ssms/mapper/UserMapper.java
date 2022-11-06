package com.sinno.ssms.mapper;

import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserEntity dto2entity(UserDTO userDTO);

    @Mapping(target = "password", ignore = true)
    UserDTO entity2dto(UserEntity entity);
}
