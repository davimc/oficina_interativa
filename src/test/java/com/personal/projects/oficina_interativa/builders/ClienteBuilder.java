package com.personal.projects.oficina_interativa.builders;

import com.personal.projects.oficina_interativa.models.Cliente;
import com.personal.projects.oficina_interativa.models.Endereco;
import com.personal.projects.oficina_interativa.models.TipoCliente;

public class ClienteBuilder {

    private Cliente cliente;

    public static ClienteBuilder umCliente(){
        ClienteBuilder builder = new ClienteBuilder();
        builder.cliente = new Cliente();
        builder.cliente.setCpfOuCnpj("607.272.893-65");
        builder.cliente.setNome("Davi");
        builder.cliente.setTelefone("982186943");
        builder.cliente.setTipoCliente(TipoCliente.PESSOAFISICA);
        return builder;
    }
    /*public ClienteBuilder comEndereco(Endereco endereco){
        cliente.setEndereco(endereco);
        return this;
    }*/
    public ClienteBuilder comNome(String nome){
        cliente.setNome(nome);
        return this;
    }
    public Cliente constroi(){
        return cliente;
    }
}
