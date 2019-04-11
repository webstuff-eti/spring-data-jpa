package br.eti.webstuff.iniciandoComJPA.dao;


import java.util.List;

import br.eti.webstuff.iniciandoComJPA.entities.Person;



public class PersonDAO extends GenericDAO<Person> {


	public PersonDAO() {
		super(Person.class);
	}

	public List<Person> findByLastName(String lastName) {
		String jpql = "FROM Person p WHERE p.lastName LIKE ?1";
		//FIXME: Também funciona
		//return findT(jpql, lastName);
		return find(jpql, lastName);
	}

	public List<Person> findAgeBetween(int min, int max) {
		String jpql = "from Person p where p.age between ?1 and ?2";
		return find(jpql, min, max);
	}

	public Person findByFullName(String firstName, String lastName) {
		String jpql = "from Person p where p.firstName like ?1 and p.lastName like ?2";
		return findOne(jpql, firstName, lastName);
	}



	public Person findByLastNameOne(String lastName) {
		String jpql = "from Person p where p.lastName like ?1";
		return findOne(jpql, lastName);
	}
	
	
	public Person findByCpf(String cpf){
		String jpql = "select p from Person p, Document d where d.cpf like ?1 and p.document.id = d.id";
		return findOne(jpql, cpf);
	}


}
