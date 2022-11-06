package com.sinno.ssms.mapper;

import com.sinno.ssms.model.dto.DanceClassDTO;
import com.sinno.ssms.model.dto.StudentDTO;
import com.sinno.ssms.model.dto.TutorDTO;
import com.sinno.ssms.model.entity.DanceClassEntity;
import com.sinno.ssms.model.entity.StudentEntity;
import com.sinno.ssms.model.entity.TutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import static com.sinno.ssms.mapper.DanceClassMapper.DANCE_CLASS_MAPPER;

@Mapper
public interface StudentMapper {

    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentEntity dto2entity(StudentDTO dto);

    StudentDTO entity2dto(StudentEntity entity);
}
