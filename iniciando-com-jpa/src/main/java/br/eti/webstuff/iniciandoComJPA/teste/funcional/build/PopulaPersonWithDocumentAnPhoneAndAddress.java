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
		addressHome.setCity("Santa Rita do Sapucaí");
		addressHome.setStreet("Rua xyz, 01");
		addressHome.setType(TypeAddress.RESIDENCIAL);

		Address addressWork = new Address();
		addressWork.setCity("São José dos Campos");
		addressWork.setStreet("Rua zyx, 02");
		addressWork.setType(TypeAddress.COMERCIAL);
		
		Person maria = new Person();
		maria.setFirstName("Maria");
		maria.setLastName("Tibães");
		maria.setAge(83);
		maria.setDocument(new Document("777.777.777-77", "MG-55.555.555"));
		
		Phone phone = new Phone(TypePhone.CELULAR, "98257-3423");
		maria.addPhone(phone);		
		
		Set<Address> ad = new HashSet<Address>();
		ad.add(addressWork);
		ad.add(addressHome);

		maria.setAddresses(ad);

		new PersonDAO().save(maria);
		System.out.println(new PersonDAO().findById(maria.getId()));
	}

}
