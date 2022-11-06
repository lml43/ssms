package com.sinno.ssms.mapper;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DanceClassMapper {

    DanceClassMapper DANCE_CLASS_MAPPER = Mappers.getMapper( DanceClassMapper.class );
    
    DanceClassEntity dto2entity(DanceClassDTO dto);

    @Mappings({
            @Mapping(target = "tutor.classList", ignore = true),
            @Mapping(target = "tutor.payHistoryList", ignore = true)
    })
    DanceClassDTO entity2dto(DanceClassEntity entity);
}
