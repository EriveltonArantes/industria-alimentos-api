package com.industriaalimentosapi.controller;

import com.industriaalimentosapi.dto.ControleQualidadeRequestDTO;
import com.industriaalimentosapi.dto.ControleQualidadeResponseDTO;
import com.industriaalimentosapi.service.ControleQualidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "ControleQualidade", description = "Gerenciamento de controlequalidades")
@RestController
@RequestMapping("/api/controlequalidades")
public class ControleQualidadeController {

    @Autowired
    private ControleQualidadeService service;

    @Operation(summary = "Listar todos os ControleQualidade")
    @GetMapping
    public List<ControleQualidadeResponseDTO> listar(@RequestParam(required = false) String parametro, @RequestParam(required = false) Long loteId) {
        List<ControleQualidadeResponseDTO> resultado = service.listar();
        if (parametro != null && !parametro.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getParametro() != null &&
                item.getParametro().toLowerCase().contains(parametro.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (loteId != null) {
            resultado = resultado.stream().filter(item -> loteId.equals(item.getLoteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar ControleQualidade por ID")
    @GetMapping("/{id}")
    public ControleQualidadeResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar ControleQualidade")
    @PostMapping
    public ResponseEntity<ControleQualidadeResponseDTO> criar(@Valid @RequestBody ControleQualidadeRequestDTO controleQualidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(controleQualidade));
    }

    @Operation(summary = "Atualizar ControleQualidade")
    @PutMapping("/{id}")
    public ControleQualidadeResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ControleQualidadeRequestDTO controleQualidade) {
        return service.atualizar(id, controleQualidade);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir ControleQualidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
