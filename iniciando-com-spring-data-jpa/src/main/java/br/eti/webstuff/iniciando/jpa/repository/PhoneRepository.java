package br.eti.webstuff.iniciando.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.webstuff.iniciando.jpa.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
