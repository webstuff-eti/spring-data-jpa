package br.eti.webstuff.iniciandoComJPA.teste.funcional.build;


import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Document;
import br.eti.webstuff.iniciandoComJPA.entities.Person;
import br.eti.webstuff.iniciandoComJPA.entities.Phone;
import br.eti.webstuff.iniciandoComJPA.entities.Phone.TypePhone;

public class PopulaPersonWithDocumentAnPhone {
	
public static void insertPersonsWithDocumentsAndPhone() {
		
		Person jaime = new Person();
		jaime.setFirstName("Jaime");
		jaime.setLastName("Fluvio");
		jaime.setAge(41);
		jaime.setDocument(new Document("999.999.999-99", "MG-88.888.888"));

		Phone phone = new Phone(TypePhone.CELULAR, "967886345");
	    jaime.addPhone(phone);
		
		new PersonDAO().save(jaime);
		System.out.println(jaime.toString());
	}

}
