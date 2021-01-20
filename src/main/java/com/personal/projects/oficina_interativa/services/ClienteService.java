package com.personal.projects.oficina_interativa.services;

import org.springframework.stereotype.Service;
import java.util.Collection;

import com.personal.projects.oficina_interativa.models.Cliente;



public interface ClienteService {
    public abstract void createCliente(Cliente cliente);
    public abstract void removeCliente(Long id);
    public abstract void updateCliente(Long id, Cliente cliente);
    public abstract Collection<Cliente> getClientes();


}
