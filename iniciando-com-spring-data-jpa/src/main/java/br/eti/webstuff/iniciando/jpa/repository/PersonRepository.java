package br.eti.webstuff.iniciando.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.webstuff.iniciando.jpa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
