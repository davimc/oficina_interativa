package com.personal.projects.oficina_interativa.repositories;

import com.personal.projects.oficina_interativa.models.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

}
