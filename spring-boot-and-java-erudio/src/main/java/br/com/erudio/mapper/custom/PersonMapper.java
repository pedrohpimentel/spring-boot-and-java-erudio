package br.com.erudio.mapper.custom;

import br.com.erudio.DTO.v2.PersonDTOv2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDto(Person person){
        PersonDTOv2 dto = new PersonDTOv2();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDtoToEntity(PersonDTOv2 person){
        Person entity = new Person();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }

}
