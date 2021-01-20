package com.personal.projects.oficina_interativa.repositories;

import com.personal.projects.oficina_interativa.models.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    public Optional<Endereco> findByLogradouroAndNum(String rua, int num);
}
