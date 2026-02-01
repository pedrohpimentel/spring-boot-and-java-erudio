package br.com.erudio.spring_boot_and_java_erudio.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "person") // com isso já temos a primeira entidade vínculada ao DB.
public class Person {

    private static final long SerialVersionUID = 1L;

    //Iremos mapear os atributos.

    @Id
    //Precisamos dizer qual a forma de geração do "id" que iremos adotar.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Não pode ser nulo e não pode ser uma nome maior que 80.
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    //Não pode ser nulo e não pode ser uma nome maior que 80.
    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    //Quando não passo o nome, ele entende que será o mesmo nome no DB e na entidade.
    @Column(nullable = false, length = 100)
    private String address;

    //Quando não passo o nome, ele entende que será o mesmo nome no DB e na entidade.
    @Column(nullable = false, length = 8)
    private String gender;

    public Person(){}

    public Person(Long id, String firstName, String lastName, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }
}
