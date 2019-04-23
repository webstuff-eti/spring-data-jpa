package br.eti.webstuff.api.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.eti.webstuff.api.jpa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Transactional(readOnly = true)
	Person findByFirstName(String firstName);

	@Transactional(readOnly = true)
	Person findByLastName(String lastName);

	@Transactional(readOnly = true)
	Person findByAge(Integer age);

	@Transactional(readOnly = true)
	@Query("FROM Person p WHERE p.id = :personId")
	Person findById(@Param("personId") Long personId);

	@Transactional(readOnly = true)
	@Query("FROM Person p WHERE p.document.cpf = :cpf")
	Optional<Person> findByDocumentCpf(@Param("cpf") String cpf);
	
	@Query("FROM Person p WHERE p.document.rg = :rg")
	@Transactional(readOnly = true)
	Person findByDocumentRg(@Param("rg") String rg);
	
	@Transactional(readOnly = true)
	@Query("FROM Person p JOIN p.addresses address WHERE address.city = :city")
	Page<Person> findByPeopleByCity(@Param("city") String city, Pageable pageable);

	@Transactional(readOnly = true)
	@Query("FROM Person p JOIN p.phones phone WHERE phone.phoneNumber = :phoneNumber")
	Person findPersonByPhoneNumber(@Param("phoneNumber") String phoneNumber); 
	
	
//	@Transactional(readOnly = true)
//	Person findOne(Long personId);
	
  //public Optional<Person> findByPagesGreaterThan(@Param("pages") int pages);
	
}
