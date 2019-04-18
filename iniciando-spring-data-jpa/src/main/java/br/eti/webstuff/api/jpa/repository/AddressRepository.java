package br.eti.webstuff.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.eti.webstuff.api.jpa.entity.Address;
import br.eti.webstuff.enumeration.TypeAddress;


public interface AddressRepository extends JpaRepository<Address, Long>{
	
	@Transactional(readOnly = true)
	Address findByCity(String city);
	
	@Transactional(readOnly = true)
	Address findByStreet(String street);
	
	@Transactional(readOnly = true)
	Address findByType(TypeAddress typeAddress);

}
