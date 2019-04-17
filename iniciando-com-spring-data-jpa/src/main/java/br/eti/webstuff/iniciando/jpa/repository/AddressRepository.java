package br.eti.webstuff.iniciando.jpa.repository;



import br.eti.webstuff.iniciando.jpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{ 

}
