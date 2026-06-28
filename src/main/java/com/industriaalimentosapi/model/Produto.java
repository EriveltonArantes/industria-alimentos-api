package com.industriaalimentosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private String unidade;
    private java.time.LocalDateTime validade;
    @Column(nullable = false)
    private String composicao;
    @Column(nullable = false)
    private String alergenos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    public java.time.LocalDateTime getValidade() { return validade; }
    public void setValidade(java.time.LocalDateTime validade) { this.validade = validade; }
    public String getComposicao() { return composicao; }
    public void setComposicao(String composicao) { this.composicao = composicao; }
    public String getAlergenos() { return alergenos; }
    public void setAlergenos(String alergenos) { this.alergenos = alergenos; }
}
