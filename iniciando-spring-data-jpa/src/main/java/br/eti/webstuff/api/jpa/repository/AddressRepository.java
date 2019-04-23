package br.eti.webstuff.api.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.eti.webstuff.api.jpa.entity.Address;
import br.eti.webstuff.enumeration.TypeAddress;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Transactional(readOnly = true)
	Address findByCity(String city);

	@Transactional(readOnly = true)
	Address findByStreet(String street);

	@Transactional(readOnly = true)
	Address findByType(TypeAddress typeAddress);

	// busca por city or street conforme a igualdade da sequencia de caracteres
	@Transactional(readOnly = true)
	List<Address> findByCityStartingWithOrStreetEndingWith(String city, String street);

	// busca por street conforme o parametro coincida com qualquer parte do campo
	// street
	@Transactional(readOnly = true)
	List<Address> findByStreetContaining(String street);

	// busca por street conforme o termino da palavra
	@Transactional(readOnly = true)
	List<Address> findByStreetEndingWith(String street);

	// busca por city conforme o inicio da palavra
	@Transactional(readOnly = true)
	List<Address> findByCityStartingWith(String city);

}
