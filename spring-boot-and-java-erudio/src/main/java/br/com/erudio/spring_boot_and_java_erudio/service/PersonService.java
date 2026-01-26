package br.com.erudio.spring_boot_and_java_erudio.service;

import br.com.erudio.spring_boot_and_java_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding one Person! ");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLastName("Pimentel");
        person.setAddress("Monte Sião - Minas Gerais");
        person.setGender("Male");

        return person;
    }

    //Lembre-se, o método "findAll" sempre vai retornar uma lista (List<>).
    public List<Person> findAll(){
        logger.info("Finding all Person! ");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname: " + i);
        person.setLastName("Lastname: " + i);
        person.setAddress("Some Address in Brazil " );
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one Person! ");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one Person! ");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person! ");
    }
}
