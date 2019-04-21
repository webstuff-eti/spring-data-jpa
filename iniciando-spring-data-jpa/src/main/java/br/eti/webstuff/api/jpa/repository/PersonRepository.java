package br.eti.webstuff.api.jpa.repository;

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

	//TODO: Permite a buscaq tanto do RG, quanto pelo CPF -Testar
	@Transactional(readOnly = true)
	@Query("FROM Person p WHERE p.document.cpf = :cpf")
	Person findByDocumentCpf(@Param("cpf") String cpf);
	
	@Query("FROM Person p WHERE p.document.rg = :rg")
	@Transactional(readOnly = true)
	Person findByDocumentRg(@Param("rg") String rg);

}
