package com.personal.projects.oficina_interativa.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "É necessário um logradouro")
    private String logradouro;
    private int num;
    private String complemento;
    @NotNull(message = "É necessário um bairro")
    private String bairro;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    public Endereco() {
    }

    public Endereco(@NotEmpty(message = "É necessário uma logradouro") String logradouro, String complemento, @NotNull(message = "É necessário um bairro") String bairro) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public Endereco(@NotEmpty(message = "É necessário uma logradouro") String logradouro, int num, @NotNull(message = "É necessário um bairro") String bairro) {
        this.logradouro = logradouro;
        this.num = num;
        this.bairro = bairro;
    }

    public Endereco(@NotEmpty(message = "É necessário uma logradouro") String logradouro, int num, String complemento, @NotNull(message = "É necessário um bairro") String bairro) {
        this.logradouro = logradouro;
        this.num = num;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
