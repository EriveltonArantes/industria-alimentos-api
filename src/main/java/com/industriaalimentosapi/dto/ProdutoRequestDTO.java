package com.industriaalimentosapi.dto;

import jakarta.validation.constraints.*;

public class ProdutoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "codigo não pode estar em branco")
    private String codigo;
    @NotBlank(message = "categoria não pode estar em branco")
    private String categoria;
    @NotBlank(message = "unidade não pode estar em branco")
    private String unidade;
    @NotNull(message = "validade não pode ser nulo")
    private java.time.LocalDateTime validade;
    @NotBlank(message = "composicao não pode estar em branco")
    private String composicao;
    @NotBlank(message = "alergenos não pode estar em branco")
    private String alergenos;

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
