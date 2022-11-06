package com.sinno.ssms.mapper;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.dto.TutorDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;
import com.sinno.ssms.model.entity.PayHistory;
import com.sinno.ssms.model.entity.StudentEntity;
import com.sinno.ssms.model.entity.TutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.sinno.ssms.mapper.DanceClassMapper.DANCE_CLASS_MAPPER;

@Mapper
public interface TutorMapper {

    TutorMapper TUTOR_MAPPER = Mappers.getMapper(TutorMapper.class);

    TutorEntity dto2entity(TutorDTO dto);

    @Mappings({
            @Mapping(target = "payHistoryList.tutor", ignore = true)
    })
    TutorDTO entity2dto(TutorEntity entity);

    default DanceClassEntity danceClassDTOToDanceClassEntity(DanceClassDTO danceClassDTO) {
        return DANCE_CLASS_MAPPER.dto2entity(danceClassDTO);
    }

    default List<DanceClassEntity> danceClassDTOListToDanceClassEntityList(List<DanceClassDTO> list) {
        return list.stream()
                .map(TUTOR_MAPPER::danceClassDTOToDanceClassEntity)
                .collect(Collectors.toList());
    }

    default DanceClassDTO danceClassEntityToDanceClassDTO(DanceClassEntity danceClassEntity) {
        return DANCE_CLASS_MAPPER.entity2dto(danceClassEntity);
    }

    default List<DanceClassDTO> danceClassEntityListToDanceClassDTOList(List<DanceClassEntity> list) {
        return list.stream()
                .map(TUTOR_MAPPER::danceClassEntityToDanceClassDTO)
                .collect(Collectors.toList());
    }

}
