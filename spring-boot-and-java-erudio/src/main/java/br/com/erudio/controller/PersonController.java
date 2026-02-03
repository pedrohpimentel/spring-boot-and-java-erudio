package br.com.erudio.controller;

import br.com.erudio.dto.PersonDTO;

import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    //Trocando "RequestMapping" por "GetMapping"
    @GetMapping(value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    //Quando não houver parâmetro para a rota, significa que está definido por padrão um findAll.
    //Trocando "RequestMapping" por "GetMapping"
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    //Trocando "RequestMapping" por "PostMapping"
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    //Trocando "RequestMapping" por "PutMapping"
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }

    //Trocando "RequestMapping" por "DeleteMapping"
    //Iremos ajustar o método delete para retornar um "no content"
    @DeleteMapping(value = "/{id}")

    // Passando um coringa no "ResponseEntity<?>"
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        service.delete(id);

        //Ele irá retornar um "204 no content".
        return ResponseEntity.noContent().build();
    }
}

