package com.personal.projects.oficina_interativa.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name="Servico_Operacao", joinColumns = {
            @JoinColumn(name="servico_id")}, inverseJoinColumns = {
            @JoinColumn(name="operacao_id")
    })
    private List<Operacao> operacoes;
    @ManyToOne
    @JoinColumn(name="moto_id", nullable = false)
    private Moto moto;


    private Calendar dataInicio;
    private Calendar dataPrevista;
    private Calendar dataFinalizacao;
    private Double orcamento;
    private double valorFinal;

    public Servico() {
    }

    public Servico(Moto moto, Calendar dataInicio, Calendar dataPrevista, Calendar dataFinalizacao, Double orcamento, double valorFinal) {
        this.moto = moto;
        this.dataInicio = dataInicio;
        this.dataPrevista = dataPrevista;
        this.dataFinalizacao = dataFinalizacao;
        this.orcamento = orcamento;
        this.valorFinal = valorFinal;
    }

    public Long getId() {
        return id;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Calendar dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
