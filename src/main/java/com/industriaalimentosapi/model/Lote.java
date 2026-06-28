package com.industriaalimentosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lotes")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column(nullable = false)
    private String numero;
    private java.time.LocalDateTime dataProducao;
    private java.time.LocalDateTime dataValidade;
    private Long quantidade;
    @Column(nullable = false)
    private String linha;
    @Column(nullable = false)
    private String operador;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
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
