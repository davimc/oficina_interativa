package com.personal.projects.oficina_interativa.repositories;

import com.personal.projects.oficina_interativa.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE :nome% ORDER BY c.nome asc" )
    public List<Cliente> findByNome(@Param("nome") String nome);

    public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);
}
