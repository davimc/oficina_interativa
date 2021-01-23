package com.personal.projects.oficina_interativa.models;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import java.util.HashSet;
import java.util.Set;

public class PecaComMarcas extends Peca{
    @ElementCollection
    @CollectionTable(name="MARCAS")
    private Set<String> marcas = new HashSet<>();

    public PecaComMarcas() {
    }
    public PecaComMarcas(String nome, double preco, String marca, boolean generico, Set<String> marcas) {
        super(nome, preco, marca, generico);
        this.marcas = marcas;
    }
}
