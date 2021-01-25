package com.personal.projects.oficina_interativa.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    //private List<String> modelos;
    private String marca;
    private boolean generico;

    public Peca() {
    }

    public Peca(String nome, double preco, String marca, boolean generico) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.generico = generico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isGenerico() {
        return generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    @Override
    public String toString() {
        return "Peca{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", marca='" + marca + '\'' +
                ", generico=" + generico +
                '}';
    }
}
