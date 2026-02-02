package br.com.erudio.service;

import br.com.erudio.DTO.PersonDTO;
import br.com.erudio.exception.ResourceNotFoundException;
import static br.com.erudio.mapper.ObjectMapper.parseListObjects;
import static br.com.erudio.mapper.ObjectMapper.parseObject;
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
    public List<PersonDTO> findAll(){
        logger.info("Finding all Person! ");

       return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    //Em findById ele irá retornar um Optional
    public PersonDTO findById(Long id){
        logger.info("Finding one Person! ");

        //Em caso de não encontrar id, será lançada a exceção criada "ResourceNotFoundException"
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity,PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person! ");
        var entity = parseObject(person,Person.class);
        return parseObject(repository.save(entity),PersonDTO.class);
    }

    //O update irá substituir os mocks que foi antigamente.
    public PersonDTO update(PersonDTO person){
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
        return parseObject(repository.save(entity),PersonDTO.class);
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

