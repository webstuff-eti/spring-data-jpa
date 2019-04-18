package br.eti.webstuff.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.webstuff.api.jpa.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
