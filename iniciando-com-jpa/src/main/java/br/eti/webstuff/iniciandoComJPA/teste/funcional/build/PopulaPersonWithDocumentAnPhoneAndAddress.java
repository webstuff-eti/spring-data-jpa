package br.eti.webstuff.iniciandoComJPA.teste.funcional.build;

import java.util.HashSet;
import java.util.Set;

import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Address;
import br.eti.webstuff.iniciandoComJPA.entities.Address.TypeAddress;
import br.eti.webstuff.iniciandoComJPA.entities.Document;
import br.eti.webstuff.iniciandoComJPA.entities.Person;
import br.eti.webstuff.iniciandoComJPA.entities.Phone;
import br.eti.webstuff.iniciandoComJPA.entities.Phone.TypePhone;

public class PopulaPersonWithDocumentAnPhoneAndAddress {

	public static void insertPersonsWithDocumentsAndPhoneAndAddress() {
		
		Address addressHome = new Address();
		addressHome.setCity("Pouso Alegre");
		addressHome.setStreet("Rua xyz, 01");
		addressHome.setType(TypeAddress.RESIDENCIAL);

		Address addressWork = new Address();
		addressWork.setCity("Pouso Alegre");
		addressWork.setStreet("Rua zyx, 02");
		addressWork.setType(TypeAddress.COMERCIAL);
		
		Person joao = new Person();
		joao.setFirstName("João");
		joao.setLastName("Tibães");
		joao.setAge(93);
		joao.setDocument(new Document("333.333.333-33", "MG-11.111.111"));
		
		Phone phone = new Phone(TypePhone.RESIDENCIAL, "3471-3356");
		joao.addPhone(phone);		
		
		Set<Address> ad = new HashSet<Address>();
		ad.add(addressWork);
		ad.add(addressHome);

		joao.setAddresses(ad);

		new PersonDAO().save(joao);
		System.out.println(new PersonDAO().findById(joao.getId()));
	}

}
