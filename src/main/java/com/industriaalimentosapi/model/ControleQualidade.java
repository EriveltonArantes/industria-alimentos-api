package com.industriaalimentosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "controlequalidades")
public class ControleQualidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
    @Column(nullable = false)
    private String parametro;
    @Column(nullable = false)
    private String valorEsperado;
    @Column(nullable = false)
    private String valorObtido;
    private Boolean aprovado;
    @Column(nullable = false)
    private String analista;
    private java.time.LocalDateTime data;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Lote getLote() { return lote; }
    public void setLote(Lote lote) { this.lote = lote; }
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
