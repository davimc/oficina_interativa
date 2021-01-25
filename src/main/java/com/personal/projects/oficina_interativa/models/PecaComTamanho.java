package com.personal.projects.oficina_interativa.models;

import javax.persistence.Entity;

@Entity
public class PecaComTamanho extends Peca{
    private double tamanho;

    public PecaComTamanho(String nome, double preco, String marca, boolean generico, double tamanho) {
        super(nome, preco, marca, generico);
        this.tamanho = tamanho;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString()+"PecaComTamanho{" +
                "tamanho=" + tamanho +
                '}';
    }
}
