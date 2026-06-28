package com.industriaalimentosapi.dto;

public class LoteResponseDTO {

    private Long id;
    private Long produtoId;
    private String numero;
    private java.time.LocalDateTime dataProducao;
    private java.time.LocalDateTime dataValidade;
    private Long quantidade;
    private String linha;
    private String operador;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
