package com.industriaalimentosapi.dto;

public class ControleQualidadeResponseDTO {

    private Long id;
    private Long loteId;
    private String parametro;
    private String valorEsperado;
    private String valorObtido;
    private Boolean aprovado;
    private String analista;
    private java.time.LocalDateTime data;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLoteId() { return loteId; }
    public void setLoteId(Long loteId) { this.loteId = loteId; }
    public String getParametro() { return parametro; }
    public void setParametro(String parametro) { this.parametro = parametro; }
    public String getValorEsperado() { return valorEsperado; }
    public void setValorEsperado(String valorEsperado) { this.valorEsperado = valorEsperado; }
    public String getValorObtido() { return valorObtido; }
    public void setValorObtido(String valorObtido) { this.valorObtido = valorObtido; }
    public Boolean getAprovado() { return aprovado; }
    public void setAprovado(Boolean aprovado) { this.aprovado = aprovado; }
    public String getAnalista() { return analista; }
    public void setAnalista(String analista) { this.analista = analista; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
}
