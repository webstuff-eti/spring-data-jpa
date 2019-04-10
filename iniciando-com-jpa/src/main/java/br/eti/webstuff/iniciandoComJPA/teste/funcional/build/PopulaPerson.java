package br.eti.webstuff.iniciandoComJPA.teste.funcional.build;

import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Person;

public class PopulaPerson {

	public static void insertPersons() {

<<<<<<< HEAD
		Person tiago = new Person();
		tiago.setFirstName("Tiago");
		tiago.setLastName("Tibães");
		tiago.setAge(37);

		new PersonDAO().save(tiago);
		System.out.println(tiago.toString());

		Person cristina = new Person();
		cristina.setFirstName("Cristina");
		cristina.setLastName("Oliveira");
		cristina.setAge(36);

		new PersonDAO().save(cristina);
		System.out.println(cristina.toString());

		Person nilva = new Person();
		nilva.setFirstName("Nilva");
		nilva.setLastName("Tânia");
		nilva.setAge(40);

		new PersonDAO().save(nilva);
		System.out.println(nilva.toString());
=======
//		Person tiago = new Person();
//		tiago.setFirstName("Tiago");
//		tiago.setLastName("Tibães");
//		tiago.setAge(37);
//
//		new PersonDAO().save(tiago);
//		System.out.println(tiago.toString());
//
//		Person cristina = new Person();
//		cristina.setFirstName("Cristina");
//		cristina.setLastName("Oliveira");
//		cristina.setAge(36);
//
//		new PersonDAO().save(cristina);
//		System.out.println(cristina.toString());
//
//		Person nilva = new Person();
//		nilva.setFirstName("Nilva");
//		nilva.setLastName("Tânia");
//		nilva.setAge(40);
//
//		new PersonDAO().save(nilva);
//		System.out.println(nilva.toString());
		
		
//		Person jose = new Person();
//		jose.setFirstName("José");
//		jose.setLastName("Oliveira");
//		jose.setAge(36);
//
//		new PersonDAO().save(jose);
//		System.out.println(jose.toString());
		
		
		Person rafael = new Person();
		rafael.setFirstName("Rafael");
		rafael.setLastName("Godoy");
		rafael.setAge(39);

		new PersonDAO().save(rafael);
		System.out.println(rafael.toString());

>>>>>>> aula-10

	}
}
