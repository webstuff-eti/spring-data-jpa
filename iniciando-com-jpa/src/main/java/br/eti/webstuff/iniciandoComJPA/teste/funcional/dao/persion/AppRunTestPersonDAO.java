package br.eti.webstuff.iniciandoComJPA.teste.funcional.dao.persion;

import java.util.List;

import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Person;
import br.eti.webstuff.iniciandoComJPA.teste.funcional.build.PopulaPerson;


public class AppRunTestPersonDAO {
	
	
    public static void main( String[] args )
    {
        System.out.println( "Populando dados na tabela PERSONS do Banco de dados jpabd" );
        //PopulaPerson.insertPersons();
        //showCountPeople();
        //showPeople();
        //findPersonById();
        showPeopleByCriteria();
        
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
	
	
	
	//findAllByCriteria

	
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
}