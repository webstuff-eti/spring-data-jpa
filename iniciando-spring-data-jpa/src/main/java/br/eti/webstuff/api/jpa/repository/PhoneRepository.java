package br.eti.webstuff.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.webstuff.api.jpa.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
