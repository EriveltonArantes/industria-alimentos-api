package com.industriaalimentosapi.service;

import com.industriaalimentosapi.dto.RecallRequestDTO;
import com.industriaalimentosapi.dto.RecallResponseDTO;
import com.industriaalimentosapi.exception.ResourceNotFoundException;
import com.industriaalimentosapi.mapper.RecallMapper;
import com.industriaalimentosapi.model.Recall;
import com.industriaalimentosapi.repository.RecallRepository;
import com.industriaalimentosapi.repository.LoteRepository;
import com.industriaalimentosapi.model.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecallService {

    @Autowired
    private RecallRepository repository;

    @Autowired
    private RecallMapper mapper;

    @Autowired
    private LoteRepository loteRepository;

    @Transactional(readOnly = true)
    public List<RecallResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RecallResponseDTO buscar(Long id) {
        Recall entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recall não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public RecallResponseDTO criar(RecallRequestDTO dto) {
        Recall entity = mapper.toEntity(dto);
        Lote lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("Lote não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        Recall salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public RecallResponseDTO atualizar(Long id, RecallRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recall não encontrado com id: " + id);
        }
        Recall entity = mapper.toEntity(dto);
        entity.setId(id);
        Lote lote = loteRepository.findById(dto.getLoteId())
            .orElseThrow(() -> new ResourceNotFoundException("Lote não encontrado com id: " + dto.getLoteId()));
        entity.setLote(lote);
        Recall salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recall não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
