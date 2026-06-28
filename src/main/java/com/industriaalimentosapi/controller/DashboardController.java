package com.industriaalimentosapi.controller;

import com.industriaalimentosapi.model.Produto;
import com.industriaalimentosapi.model.Lote;
import com.industriaalimentosapi.model.ControleQualidade;
import com.industriaalimentosapi.model.Recall;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.industriaalimentosapi.repository.ProdutoRepository produtoRepository;

    @Autowired
    private com.industriaalimentosapi.repository.LoteRepository loteRepository;

    @Autowired
    private com.industriaalimentosapi.repository.ControleQualidadeRepository controleQualidadeRepository;

    @Autowired
    private com.industriaalimentosapi.repository.RecallRepository recallRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalProduto", produtoRepository.count());
        resumo.put("totalLote", loteRepository.count());
        resumo.put("somaQuantidadeLote", loteRepository.findAll().stream().filter(e -> e.getQuantidade() != null).mapToLong(e -> e.getQuantidade()).sum());
        resumo.put("totalControleQualidade", controleQualidadeRepository.count());
        resumo.put("totalRecall", recallRepository.count());
        resumo.put("somaQuantidadeRecolhidaRecall", recallRepository.findAll().stream().filter(e -> e.getQuantidadeRecolhida() != null).mapToInt(e -> e.getQuantidadeRecolhida()).sum());
        resumo.put("graficoRecall", recallRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
