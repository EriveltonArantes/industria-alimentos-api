package com.industriaalimentosapi.mapper;

import com.industriaalimentosapi.dto.ProdutoRequestDTO;
import com.industriaalimentosapi.dto.ProdutoResponseDTO;
import com.industriaalimentosapi.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toResponseDTO(Produto entity);
}
