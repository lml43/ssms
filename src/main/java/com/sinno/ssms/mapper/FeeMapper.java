package com.sinno.ssms.mapper;

import com.sinno.ssms.model.dto.FeeHistoryDTO;
import com.sinno.ssms.model.entity.FeeHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface FeeMapper {

    FeeMapper FEE_MAPPER = Mappers.getMapper(FeeMapper.class);

    FeeHistory dto2entity(FeeHistoryDTO userDTO);

    FeeHistoryDTO entity2dto(FeeHistory entity);
}
