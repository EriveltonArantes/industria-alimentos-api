package com.industriaalimentosapi.service;

import com.industriaalimentosapi.dto.LoteRequestDTO;
import com.industriaalimentosapi.dto.LoteResponseDTO;
import com.industriaalimentosapi.exception.ResourceNotFoundException;
import com.industriaalimentosapi.mapper.LoteMapper;
import com.industriaalimentosapi.model.Lote;
import com.industriaalimentosapi.repository.LoteRepository;
import com.industriaalimentosapi.repository.ProdutoRepository;
import com.industriaalimentosapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoteService {

    @Autowired
    private LoteRepository repository;

    @Autowired
    private LoteMapper mapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<LoteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LoteResponseDTO buscar(Long id) {
        Lote entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Lote não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public LoteResponseDTO criar(LoteRequestDTO dto) {
        Lote entity = mapper.toEntity(dto);
        Produto produto = produtoRepository.findById(dto.getProdutoId())
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + dto.getProdutoId()));
        entity.setProduto(produto);
        Lote salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public LoteResponseDTO atualizar(Long id, LoteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Lote não encontrado com id: " + id);
        }
        Lote entity = mapper.toEntity(dto);
        entity.setId(id);
        Produto produto = produtoRepository.findById(dto.getProdutoId())
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + dto.getProdutoId()));
        entity.setProduto(produto);
        Lote salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Lote não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
