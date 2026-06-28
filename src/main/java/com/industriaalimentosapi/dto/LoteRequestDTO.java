package com.industriaalimentosapi.dto;

import jakarta.validation.constraints.*;

public class LoteRequestDTO {

    @NotNull(message = "ProdutoId é obrigatório")
    @Positive(message = "ProdutoId deve ser um ID válido (positivo)")
    private Long produtoId;
    @NotBlank(message = "numero não pode estar em branco")
    private String numero;
    @NotNull(message = "data producao não pode ser nulo")
    private java.time.LocalDateTime dataProducao;
    @NotNull(message = "data validade não pode ser nulo")
    private java.time.LocalDateTime dataValidade;
    @Min(value = 0, message = "quantidade não pode ser negativo")
    @NotNull(message = "quantidade não pode ser nulo")
    private Long quantidade;
    @NotBlank(message = "linha não pode estar em branco")
    private String linha;
    @NotBlank(message = "operador não pode estar em branco")
    private String operador;

    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public java.time.LocalDateTime getDataProducao() { return dataProducao; }
    public void setDataProducao(java.time.LocalDateTime dataProducao) { this.dataProducao = dataProducao; }
    public java.time.LocalDateTime getDataValidade() { return dataValidade; }
    public void setDataValidade(java.time.LocalDateTime dataValidade) { this.dataValidade = dataValidade; }
    public Long getQuantidade() { return quantidade; }
    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
    public String getLinha() { return linha; }
    public void setLinha(String linha) { this.linha = linha; }
    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }
}
