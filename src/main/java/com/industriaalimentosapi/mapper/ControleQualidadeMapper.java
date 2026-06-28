package com.industriaalimentosapi.mapper;

import com.industriaalimentosapi.dto.ControleQualidadeRequestDTO;
import com.industriaalimentosapi.dto.ControleQualidadeResponseDTO;
import com.industriaalimentosapi.model.ControleQualidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ControleQualidadeMapper {

    @Mapping(target = "lote", ignore = true)
    ControleQualidade toEntity(ControleQualidadeRequestDTO dto);

    @Mapping(target = "loteId", source = "lote.id")
    ControleQualidadeResponseDTO toResponseDTO(ControleQualidade entity);
}
