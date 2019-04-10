package br.eti.webstuff.iniciandoComJPA.teste.funcional.dao.persion;

import java.util.List;

import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Person;


public class AppRunTestPersonDAO {
	
	

    public static void main( String[] args ){
    	
        System.out.println( "Populando dados na tabela PERSONS do Banco de dados jpabd" );
        //PopulaPerson.insertPersons(); //- OK
        //showCountPeople();            //- OK
        //showPeople();                 //- OK
        //findPersonById();             //- OK
        //showPeopleByCriteria();       //- OK
        //findByLastName();             //- OK
        //findByLastNameOne();          //- OK  
        //findByAge();                  //- OK
        //findByFullName();             //- OK
        //updatePerson();               //- OK
        //deletePerson();               //- OK
    }
    
    

    
    private static void deletePerson() {
		new PersonDAO().delete(1L);
	}

	private static void updatePerson() {
    	
    	Person personFullName = new PersonDAO().findByFullName("Tiago", "Tibães");
    	System.out.println("Antes UPDATE: " + personFullName.toString());
    	
    	personFullName.setLastName("Poliano");
    	new PersonDAO().update(personFullName);
    	
    	Person person = new PersonDAO().findByFullName("Tiago", "Poliano");
    	System.out.println("Após UPDATE: " + person.toString());
	}




	private static void findByAge() {
    	
    	List<Person> people = new PersonDAO().findAgeBetween(25, 37);
		for(Person p : people){
			System.out.println(p.toString());	
		}
	}




	private static void findByLastName() {
    	List<Person> pessoas =  new PersonDAO().findByLastName("Oliveira");//dao.findByLastName("Tibães");
    	for(Person person: pessoas){
    		System.out.println(person.toString());
    	}
	}
    
    
    private static void findByLastNameOne() {
    	PersonDAO dao = new PersonDAO();
    	Person person = dao.findByLastNameOne("Tibães");
    	System.out.println(person.toString());
	}


	private static void showCountPeople() {
		long total = new PersonDAO().count();
		System.out.println("Total of Persons: " + total);		
	}

    
	private static void showPeople() {
    	List<Person> persons = new PersonDAO().findAllByJPQL();
    	for (Person p : persons) {
	    	System.out.println(p.toString());
		}
	}
	
	
	//TODO: findAllByCriteria

	
	public static void findPersonById() {
    	Person p1 = new PersonDAO().searchById(2L);
    	Person p2 = new PersonDAO().searchById(3L);
    	System.out.println(p1.toString());
    	System.out.println(p2.toString());
    }
	
	private static void showPeopleByCriteria() {
    	List<Person> persons = new PersonDAO().findAllByCriteria();
    	for (Person p : persons) {
	    	System.out.println(p.toString());
		}
	}
	
	private static void findByFullName(){
		Person person = new PersonDAO().findByFullName("Rafael", "Godoy");
		System.out.println(person.toString());
	}
	
	
}
