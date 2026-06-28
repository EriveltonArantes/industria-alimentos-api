package com.industriaalimentosapi.dto;

import jakarta.validation.constraints.*;

public class RecallRequestDTO {

    @NotNull(message = "LoteId é obrigatório")
    @Positive(message = "LoteId deve ser um ID válido (positivo)")
    private Long loteId;
    @NotBlank(message = "motivo não pode estar em branco")
    private String motivo;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @NotBlank(message = "abrangencia não pode estar em branco")
    private String abrangencia;
    @Min(value = 0, message = "quantidade recolhida não pode ser negativo")
    @NotNull(message = "quantidade recolhida não pode ser nulo")
    private Integer quantidadeRecolhida;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getLoteId() { return loteId; }
    public void setLoteId(Long loteId) { this.loteId = loteId; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public String getAbrangencia() { return abrangencia; }
    public void setAbrangencia(String abrangencia) { this.abrangencia = abrangencia; }
    public Integer getQuantidadeRecolhida() { return quantidadeRecolhida; }
    public void setQuantidadeRecolhida(Integer quantidadeRecolhida) { this.quantidadeRecolhida = quantidadeRecolhida; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
