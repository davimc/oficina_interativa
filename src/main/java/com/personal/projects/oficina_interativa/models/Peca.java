package com.personal.projects.oficina_interativa.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
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
}
