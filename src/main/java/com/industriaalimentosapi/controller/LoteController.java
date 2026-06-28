package com.industriaalimentosapi.controller;

import com.industriaalimentosapi.dto.LoteRequestDTO;
import com.industriaalimentosapi.dto.LoteResponseDTO;
import com.industriaalimentosapi.service.LoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Lote", description = "Gerenciamento de lotes")
@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    @Autowired
    private LoteService service;

    @Operation(summary = "Listar todos os Lote")
    @GetMapping
    public List<LoteResponseDTO> listar(@RequestParam(required = false) String numero, @RequestParam(required = false) Long produtoId) {
        List<LoteResponseDTO> resultado = service.listar();
        if (numero != null && !numero.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNumero() != null &&
                item.getNumero().toLowerCase().contains(numero.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (produtoId != null) {
            resultado = resultado.stream().filter(item -> produtoId.equals(item.getProdutoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Lote por ID")
    @GetMapping("/{id}")
    public LoteResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Lote")
    @PostMapping
    public ResponseEntity<LoteResponseDTO> criar(@Valid @RequestBody LoteRequestDTO lote) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(lote));
    }

    @Operation(summary = "Atualizar Lote")
    @PutMapping("/{id}")
    public LoteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody LoteRequestDTO lote) {
        return service.atualizar(id, lote);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Lote")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
