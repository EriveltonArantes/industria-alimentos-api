package com.industriaalimentosapi.service;

import com.industriaalimentosapi.dto.ControleQualidadeRequestDTO;
import com.industriaalimentosapi.dto.ControleQualidadeResponseDTO;
import com.industriaalimentosapi.exception.ResourceNotFoundException;
import com.industriaalimentosapi.mapper.ControleQualidadeMapper;
import com.industriaalimentosapi.model.ControleQualidade;
import com.industriaalimentosapi.repository.ControleQualidadeRepository;
import com.industriaalimentosapi.repository.LoteRepository;
import com.industriaalimentosapi.model.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ControleQualidadeService {

    @Autowired
    private ControleQualidadeRepository repository;

    @Autowired
    private ControleQualidadeMapper mapper;

    @Autowired
    private LoteRepository loteRepository;

    @Transactional(readOnly = true)
    public List<ControleQualidadeResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ControleQualidadeResponseDTO buscar(Long id) {
        ControleQualidade entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ControleQualidade não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ControleQualidadeResponseDTO criar(ControleQualidadeRequestDTO dto) {
        ControleQualidade entity = mapper.toEntity(dto);
        Lote lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("Lote não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        ControleQualidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ControleQualidadeResponseDTO atualizar(Long id, ControleQualidadeRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ControleQualidade não encontrado com id: " + id);
        }
        ControleQualidade entity = mapper.toEntity(dto);
        entity.setId(id);
        Lote lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("Lote não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        ControleQualidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ControleQualidade não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
