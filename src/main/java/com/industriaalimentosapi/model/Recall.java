package com.industriaalimentosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recalls")
public class Recall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
    @Column(nullable = false)
    private String motivo;
    private java.time.LocalDateTime dataInicio;
    @Column(nullable = false)
    private String abrangencia;
    private Integer quantidadeRecolhida;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Lote getLote() { return lote; }
    public void setLote(Lote lote) { this.lote = lote; }
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
