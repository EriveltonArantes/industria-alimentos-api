package com.industriaalimentosapi.controller;

import com.industriaalimentosapi.dto.RecallRequestDTO;
import com.industriaalimentosapi.dto.RecallResponseDTO;
import com.industriaalimentosapi.service.RecallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Recall", description = "Gerenciamento de recalls")
@RestController
@RequestMapping("/api/recalls")
public class RecallController {

    @Autowired
    private RecallService service;

    @Operation(summary = "Listar todos os Recall")
    @GetMapping
    public List<RecallResponseDTO> listar(@RequestParam(required = false) String motivo, @RequestParam(required = false) Long loteId) {
        List<RecallResponseDTO> resultado = service.listar();
        if (motivo != null && !motivo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getMotivo() != null &&
                item.getMotivo().toLowerCase().contains(motivo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (loteId != null) {
            resultado = resultado.stream().filter(item -> loteId.equals(item.getLoteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Recall por ID")
    @GetMapping("/{id}")
    public RecallResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Recall")
    @PostMapping
    public ResponseEntity<RecallResponseDTO> criar(@Valid @RequestBody RecallRequestDTO recall) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(recall));
    }

    @Operation(summary = "Atualizar Recall")
    @PutMapping("/{id}")
    public RecallResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody RecallRequestDTO recall) {
        return service.atualizar(id, recall);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Recall")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
