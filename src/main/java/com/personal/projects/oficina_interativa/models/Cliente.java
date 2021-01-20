package com.personal.projects.oficina_interativa.models;

import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "cliente")
    private Set<Endereco> enderecos = new HashSet<>();
    @ElementCollection
    @CollectionTable(name="TELEFONE")
    private Set<String> telefone = new HashSet<>();

    @NotEmpty(message = "É necessário um nome para o cliente")
    @Size(min = 2, max = 32, message = "Nome deve ter no mínimo 2 até 32 caracteres")
    private String nome;

    @NotNull
    private Integer tipoCliente;

    @NotNull(message = "É necessário um cpfOuCnpj para o cliente")
    @Size(min = 12, max = 14, message = "O tamanho do cpfOuCnpj não é válido")
    private String cpfOuCnpj;


    public Cliente() {
    }

    public Cliente(@NotEmpty(message = "É necessário um nome para o cliente") @Size(min = 2, max = 32, message = "Nome deve ter no mínimo 2 até 32 caracteres") String nome,
                   @NotNull Integer tipoCliente,
                   @NotNull(message = "É necessário um cpfOuCnpj para o cliente") @Size(min = 12, max = 14, message = "O tamanho do cpfOuCnpj não é válido") String cpfOuCnpj) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
    }

    public Set<Endereco> getEndereco() {
        return enderecos;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.enderecos = endereco;
    }
    //TELEFONE
    public Set<String> getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone.add(telefone);
    }

    public void addTelefone(String telefone){
        this.telefone.add(telefone);
    }
    public void removeTelefone(String telefone){
        this.telefone.remove(telefone);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return nome.equals(cliente.nome) && cpfOuCnpj.equals(cliente.cpfOuCnpj) && Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpfOuCnpj, telefone);
    }


}
