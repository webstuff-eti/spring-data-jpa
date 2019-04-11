package br.eti.webstuff.iniciandoComJPA.teste.funcional.build;

import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Document;
import br.eti.webstuff.iniciandoComJPA.entities.Person;

public class PopulaPersonWithDocument {

	public static void insertPersonsWithDocuments() {
		
		Person rodrigo = new Person();
		rodrigo.setFirstName("Rodrigo");
		rodrigo.setLastName("Paiva");
		rodrigo.setAge(26);
		rodrigo.setDocument(new Document("023.345.135-79", "MG-34.245.125"));

		new PersonDAO().save(rodrigo);
		System.out.println(rodrigo.toString());
		
		
		Person sabrina = new Person();
		sabrina.setFirstName("Sabrina");
		sabrina.setLastName("Paiva");
		sabrina.setAge(39);
		sabrina.setDocument(new Document("127.349.135-78", "MG-99.245.123"));

		new PersonDAO().save(sabrina);
		System.out.println(sabrina.toString());
	}
}
