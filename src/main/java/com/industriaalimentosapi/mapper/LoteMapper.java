package com.industriaalimentosapi.mapper;

import com.industriaalimentosapi.dto.LoteRequestDTO;
import com.industriaalimentosapi.dto.LoteResponseDTO;
import com.industriaalimentosapi.model.Lote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoteMapper {

    @Mapping(target = "produto", ignore = true)
    Lote toEntity(LoteRequestDTO dto);

    @Mapping(target = "produtoId", source = "produto.id")
    LoteResponseDTO toResponseDTO(Lote entity);
}
