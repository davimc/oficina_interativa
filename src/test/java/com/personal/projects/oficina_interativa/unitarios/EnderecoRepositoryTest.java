package com.personal.projects.oficina_interativa.unitarios;

import com.personal.projects.oficina_interativa.models.Endereco;

import com.personal.projects.oficina_interativa.repositories.EnderecoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository repository;
    private Endereco e1;

    @BeforeEach
    private void start(){
        e1 = new Endereco("Rua dos prazeres",537,"Centro");
        repository.save(e1);
    }
    @AfterEach
    private void end(){
        repository.deleteAll();
    }
    @Test
    public void encontraEnderecoPeloNome(){
        repository.save(e1);
        Assertions.assertTrue(repository.findAll().size()==1);
        Endereco c2 = repository.findByLogradouroAndNum("Rua dos prazeres",537).get();
        Assertions.assertEquals(1L,c2.getId());
        Assertions.assertTrue(c2.equals(e1));
    }
    @Test
    public void testaSalvarEnderecoSemNome(){
        
        e1.setLogradouro("");
        ConstraintViolationException exception =
                Assertions.assertThrows(ConstraintViolationException.class,()->{
            repository.save(e1);

            },"Deveria lançar um constraintViolationException");
        //Assertions.assertTrue(exception.getMessage().equals("É necessário um nome para a peça"));
    }
/*
    @Test
    public void testaSalvarEnderecoSemCpf(){
        e1.setCpf(null);
        //ConstraintViolationException exception =
                Assertions.assertThrows(ConstraintViolationException.class,()->{
            repository.save(e1);
        });

    }
*/
}
