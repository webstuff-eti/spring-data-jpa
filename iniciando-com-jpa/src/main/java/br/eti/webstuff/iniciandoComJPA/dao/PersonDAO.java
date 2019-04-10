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

		String jpql = "from Person p where p.age between ? and ?";

		return find(jpql, min, max);
	}

	public Person findByFullName(String firstName, String lastName) {

		String jpql = "from Person p where p.firstName like ? and p.lastName like ?";

		return findOne(jpql, firstName, lastName);
	}



	public Person findByLastNameOne(String lastName) {
		String jpql = "from Person p where p.lastName like ?";
		return findOne(jpql, lastName);
	}

}
