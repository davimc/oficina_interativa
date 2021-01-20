package com.personal.projects.oficina_interativa.unitarios;

import com.personal.projects.oficina_interativa.builders.ClienteBuilder;
import com.personal.projects.oficina_interativa.models.Cliente;
import com.personal.projects.oficina_interativa.models.Endereco;
import com.personal.projects.oficina_interativa.repositories.ClienteRepository;
import com.personal.projects.oficina_interativa.repositories.EnderecoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repository;
    private Cliente c1;
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @BeforeEach
    private void start(){
        c1 = ClienteBuilder.umCliente().constroi();
        repository.save(c1);
    }
    @AfterEach
    private void end(){
        repository.deleteAll();
    }

    //NOME
    @Test
    public void findClienteByNome(){
        Cliente c2 = repository.findByNome("Davi").get(0);
        Assertions.assertEquals(1L,c2.getId());
        Assertions.assertTrue(c2.equals(c1));
    }
    @Test
    public void findClientesByPartOfNome(){
        repository.save(ClienteBuilder.umCliente().comNome("Danilo").constroi());
        List<Cliente> clientes = repository.findByNome("Da");
        Assertions.assertEquals(2,clientes.size());
        for(Cliente c: clientes) {
            System.out.println(c.getNome());
            System.out.println(c.getId());
        }

       /* Assertions.assertTrue(clientes.get(0).getNome().equals("Davi"));
        Assertions.assertTrue(clientes.get(1).getNome().equals("Danilo"));*/
    }
    @Test
    public void whenNomeIsBlank(){
        Cliente c2 = new Cliente("",1,"607.272.893-65");
        //ConstraintViolationException exception =
        Set<ConstraintViolation<Cliente>>   violations = validator.validate(c2);
        Assertions.assertTrue(violations.size()==2);
    }
    //DOCUMENTS
    @Test
    public void whenCpfOuCnpjIsUnderLimit(){
        Cliente c2 = new Cliente("Davi",1,"607.272.893");
        Set<ConstraintViolation<Cliente>>   violations = validator.validate(c2);
        Assertions.assertTrue(violations.size()==1);
    }
    @Test
    public void whenCpfOuCnpjIsAboveLimit(){
        Cliente c2 = new Cliente("Davi",1,"607.272.893--65");
        Set<ConstraintViolation<Cliente>>   violations = validator.validate(c2);
        Assertions.assertTrue(violations.size()==1);
    }

    //TELEFONE
    @Test
    public void testTelefone(){
        Assertions.assertDoesNotThrow(()->{
            c1.addTelefone("982186943");
            repository.save(c1);
        });
    }
    @Test
    public void testRemoveTelefone(){
        c1.addTelefone("982186943");
        repository.save(c1);
        Assertions.assertDoesNotThrow(()->{
            c1.removeTelefone("982186943");
            repository.save(c1);
        });
    }
    @Test
    public void addTelefoneWhenItExist(){
        c1.addTelefone("982186943");
        repository.save(c1);
        Assertions.assertDoesNotThrow(()->{
            c1.addTelefone("982186943");
            repository.save(c1);
            Assertions.assertTrue(c1.getTelefone().size()==1);
        });
    }
    @Test
    public void removeTelefoneWhenItDoesntExist(){
        Assertions.assertDoesNotThrow(()->{
            c1.removeTelefone("982186943");
            repository.save(c1);
            Assertions.assertTrue(c1.getTelefone().size()==0);
        });
    }
}
