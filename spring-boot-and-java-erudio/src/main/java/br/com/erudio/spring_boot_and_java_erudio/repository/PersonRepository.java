package br.com.erudio.spring_boot_and_java_erudio.repository;

import br.com.erudio.spring_boot_and_java_erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//Com apenas esta Interface de "PersonRepository" já possível acessar os métodos básicos de CRUD.
public interface PersonRepository extends JpaRepository<Person, Long> {
}
