package com.industriaalimentosapi.mapper;

import com.industriaalimentosapi.dto.RecallRequestDTO;
import com.industriaalimentosapi.dto.RecallResponseDTO;
import com.industriaalimentosapi.model.Recall;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecallMapper {

    @Mapping(target = "lote", ignore = true)
    Recall toEntity(RecallRequestDTO dto);

    @Mapping(target = "loteId", source = "lote.id")
    RecallResponseDTO toResponseDTO(Recall entity);
}
