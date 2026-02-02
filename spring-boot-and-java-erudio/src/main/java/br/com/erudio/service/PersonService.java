package br.com.erudio.service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    //Injetando a dependência "PersonRepository" no PersonService
    @Autowired
    PersonRepository repository;

    //Quem irá prover o método findAll será o Spring Data.
    public List<Person> findAll(){
        logger.info("Finding all Person! ");

       return repository.findAll();
    }

    //Em findById ele irá retornar um Optional
    public Person findById(Long id){
        logger.info("Finding one Person! ");

        //Em caso de não encontrar id, será lançada a exceção criada "ResourceNotFoundException"
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person){
        logger.info("Creating one Person! ");
        return repository.save(person);
    }

    //O update irá substituir os mocks que foi antigamente.
    public Person update(Person person){
        logger.info("Updating one Person! ");

        //Irá receber a mesma estrutura do "findById", mas ele será um novo "Person" que se chamará entity;
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        //Depois chamaremos os parâmetros pelo entity;
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        //Retornando um novo "person";
        return repository.save(person);
    }

    //Para o delete mesma lógica.
    public void delete(Long id){
        logger.info("Deleting one Person! ");

        //Iremos colocar ele dentro de um "Person" que se chamará entity;
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        //Ao final ele irá deletar (entity).
        repository.delete(entity);
    }
}

