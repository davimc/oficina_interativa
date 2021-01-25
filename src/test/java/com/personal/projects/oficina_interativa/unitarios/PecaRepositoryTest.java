package com.personal.projects.oficina_interativa.unitarios;

import com.personal.projects.oficina_interativa.models.Peca;
import com.personal.projects.oficina_interativa.models.PecaComMarcas;
import com.personal.projects.oficina_interativa.models.PecaComTamanho;
import com.personal.projects.oficina_interativa.repositories.PecaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PecaRepositoryTest {
    @Autowired
    private PecaRepository repository;
    @Test
    public void saveAPecaComTamanho(){
        Peca peca = new PecaComTamanho("Parafuso",1.0,"Pirelli",false,15.0);
        repository.save(peca);
        System.out.println(peca+"Foi escrito");
    }
    @Test
    public void saveAPecaComMarcas(){
        Set<String> marcas = new HashSet<>();
        marcas.addAll(Arrays.asList("XR","XL","Fan 150"));
        Peca peca = new PecaComMarcas("Parafuso",1.0,"Pirelli",true,marcas);
        repository.save(peca);
        System.out.println(peca+"Foi escrito");
    }
}
