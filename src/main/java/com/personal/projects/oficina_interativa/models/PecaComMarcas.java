package com.personal.projects.oficina_interativa.models;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public Set<String> getMarcas() {
        return marcas;
    }

    public void setMarcas(Set<String> marcas) {
        this.marcas = marcas;
    }

    @Override
    public String toString() {

        return super.toString()+"PecaComMarcas{" +
                "marcas=" + marcas +
                '}';
    }
}
