package br.com.erudio.spring_boot_and_java_erudio.service;

import br.com.erudio.spring_boot_and_java_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding one Pérson! ");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLastName("Pimentel");
        person.setAddress("Monte Sião - Minas Gerais");
        person.setGender("Male");

        return person;
    }
}
