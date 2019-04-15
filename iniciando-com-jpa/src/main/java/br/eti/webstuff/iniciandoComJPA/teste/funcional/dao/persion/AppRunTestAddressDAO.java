package br.eti.webstuff.iniciandoComJPA.teste.funcional.dao.persion;

import java.util.List;

import br.eti.webstuff.iniciandoComJPA.dao.AddressDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Address;
import br.eti.webstuff.iniciandoComJPA.teste.funcional.build.PopulaPersonWithDocumentAnPhoneAndAddress;

public class AppRunTestAddressDAO {

	public static void main(String[] args) {

		// PopulaPersonWithDocumentAnPhoneAndAddress.insertPersonsWithDocumentsAndPhoneAndAddress(); //OK
		 searchListOfPersonByCity();
	}

	private static void searchListOfPersonByCity() {

		List<Address> ads = new AddressDAO().findByListCity("Pouso Alegre");
		
		ads.stream().forEach(a -> System.out.println(a.getCity().toString()));

	}

}
