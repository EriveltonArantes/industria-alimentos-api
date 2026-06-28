package com.industriaalimentosapi.dto;

public class RecallResponseDTO {

    private Long id;
    private Long loteId;
    private String motivo;
    private java.time.LocalDateTime dataInicio;
    private String abrangencia;
    private Integer quantidadeRecolhida;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
