package com.industriaalimentosapi.dto;

import jakarta.validation.constraints.*;

public class ControleQualidadeRequestDTO {

    @NotNull(message = "LoteId é obrigatório")
    @Positive(message = "LoteId deve ser um ID válido (positivo)")
    private Long loteId;
    @NotBlank(message = "parametro não pode estar em branco")
    private String parametro;
    @NotBlank(message = "valor esperado não pode estar em branco")
    private String valorEsperado;
    @NotBlank(message = "valor obtido não pode estar em branco")
    private String valorObtido;
    @NotNull(message = "aprovado não pode ser nulo")
    private Boolean aprovado;
    @NotBlank(message = "analista não pode estar em branco")
    private String analista;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;

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
