package com.personal.projects.oficina_interativa.unitarios;


import com.personal.projects.oficina_interativa.builders.ClienteBuilder;
import com.personal.projects.oficina_interativa.models.Moto;
import com.personal.projects.oficina_interativa.models.Cliente;
import com.personal.projects.oficina_interativa.repositories.ClienteRepository;
import com.personal.projects.oficina_interativa.repositories.MotoRepository;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MotoRepositoryTest {

    @Autowired
    private MotoRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;
    private Cliente c;
    private Moto m1;

    @BeforeEach
    private void start(){
        c = ClienteBuilder.umCliente().constroi();
        clienteRepository.save(c);
        m1 = new Moto(c, "XR","HONDA","GCD-2356",2000,"Vermelha");
        repository.save(m1);
    }
    @AfterEach
    private void end(){
        repository.deleteAll();
    }

  /*  @Test
    public void withoutCliente() throws Exception{
        //Assertions.assertThrows(JdbcSQLIntegrityConstraintViolationException.class,()-> {

            m1.setCliente(null);

            repository.save(m1);

        //});
    }*/
    @Test
    public void findByPlaca(){
        Assertions.assertDoesNotThrow(()->{
            m1 = repository.findByPlaca("GCD-2356").get();
            Assertions.assertEquals(1L,m1.getId());
        });
    }
    @Test
    public void findByPlacaWhenNotExist(){
        Assertions.assertThrows(NoSuchElementException.class,()->{
            m1 = repository.findByPlaca("GCD-2357").get();
        });
    }
    @Test
    public void findByCliente(){
        Assertions.assertDoesNotThrow(()->{
            c = clienteRepository.findById(1L).get();
            m1 = repository.findByCliente(c).get(0);
            Assertions.assertEquals(1L,m1.getId());
        });
    }

}
