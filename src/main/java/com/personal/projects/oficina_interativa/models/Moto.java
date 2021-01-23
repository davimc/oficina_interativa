package com.personal.projects.oficina_interativa.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "moto")
    private List<Servico> servicos = new ArrayList<>();
    private String modelo;
    private String marca;
    private String placa;
    private int ano;
    private String cor;

    public Moto() {
    }

    public Moto(Cliente cliente, String modelo, String marca, String placa, int ano, String cor) {
        this.cliente = cliente;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
