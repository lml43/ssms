package com.sinno.ssms.mapper;

import com.sinno.ssms.model.dto.AttendanceDTO;
import com.sinno.ssms.model.entity.AttendanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttendanceMapper {

    AttendanceMapper ATTENDANCE_MAPPER = Mappers.getMapper( AttendanceMapper.class );

    @Mapping(source = "tutorId", target = "id.tutorId")
    @Mapping(source = "danceClassId", target = "id.danceClassId")
    AttendanceEntity dto2entity(AttendanceDTO dto);

    @Mapping(source = "id.tutorId", target = "tutorId")
    @Mapping(source = "id.danceClassId", target = "danceClassId")
    AttendanceDTO entity2dto(AttendanceEntity entity);
}
