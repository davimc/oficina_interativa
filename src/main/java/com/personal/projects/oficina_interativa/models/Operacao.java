package com.personal.projects.oficina_interativa.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "Operacao_Pecas", joinColumns = {
            @JoinColumn(name="operacao_id")},inverseJoinColumns = {
            @JoinColumn(name="peca_id")
    })
    private List<Peca> pecas;
    private String nome;
    private String obs;
    private Calendar dataInicio;
    private Calendar dataFim;
    private Calendar dataPrevista;

    private Double preco;
}
