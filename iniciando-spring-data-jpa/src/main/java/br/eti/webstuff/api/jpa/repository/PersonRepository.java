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

	// busca por age igual ao parametro fornecido
	@Transactional(readOnly = true)
	Person findByAge(Integer age);

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

	@Transactional(readOnly = true)
	Person findOne(Long personId);

	// busca por firstName maior que o valor informado
	@Transactional(readOnly = true)
	List<Person> findByFirstNameGreaterThan(String firstName);

	// busca age menor que e igual ao parametro
	@Transactional(readOnly = true)
	List<Person> findByAgeLessThanEqual(Integer age);

	// busca por age maior que e igual ao parametro
	@Transactional(readOnly = true)
	List<Person> findByAgeGreaterThanEqual(Integer age);

	// busca por age menor que parametro
	@Transactional(readOnly = true)
	List<Person> findByAgeLessThan(Integer age);

	// busca por age maior que o parametro
	@Transactional(readOnly = true)
	List<Person> findByAgeGreaterThan(Integer age);

	// busca por lastName And age between
	@Transactional(readOnly = true)
	List<Person> findByLastNameAndAgeBetween(String lastName, int min, int max);

	// busca por age usando between
	@Transactional(readOnly = true)
	List<Person> findByAgeBetween(int min, int max);

	// busca por age OR firstName via parametros
	@Transactional(readOnly = true)
	List<Person> findByAgeOrFirstName(Integer age, String firstName);

	// busca por firstName AND lastName via parametros
	@Transactional(readOnly = true)
	Person findByFirstNameAndLastName(String firstName, String lastName);

	// busca por firstName igual a parametro
	@Transactional(readOnly = true)
	List<Person> findByFirstNameLike(String firstName);

	// busca por firstName diferente do parametro
	@Transactional(readOnly = true)
	List<Person> findByFirstNameNotLike(String firstName);

	// busca por age diferente do parametro fornecido
	@Transactional(readOnly = true)
	List<Person> findByAgeNot(Integer age);

	// public Optional<Person> findByPagesGreaterThan(@Param("pages") int pages);

}
