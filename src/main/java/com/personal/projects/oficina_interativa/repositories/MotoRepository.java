package com.personal.projects.oficina_interativa.repositories;

import com.personal.projects.oficina_interativa.models.Cliente;
import com.personal.projects.oficina_interativa.models.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    Optional<Moto> findByPlaca(String Placa);
    List<Moto> findByCliente(Cliente cliente);
}
