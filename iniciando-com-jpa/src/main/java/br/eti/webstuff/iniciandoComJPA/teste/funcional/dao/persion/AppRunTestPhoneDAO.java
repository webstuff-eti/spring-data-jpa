package br.eti.webstuff.iniciandoComJPA.teste.funcional.dao.persion;

import java.util.Arrays;

import br.eti.webstuff.iniciandoComJPA.dao.PersonDAO;
import br.eti.webstuff.iniciandoComJPA.dao.PhoneDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Document;
import br.eti.webstuff.iniciandoComJPA.entities.Person;
import br.eti.webstuff.iniciandoComJPA.entities.Phone;
import br.eti.webstuff.iniciandoComJPA.entities.Phone.TypePhone;

public class AppRunTestPhoneDAO {

	public static void main(String[] args) {

		insertPhone();      // - OK
		//updatePhone();      // - OK
		//updatePhoneWithValidator(); // - OK
		// deletePersonOnCascadeAllByPhone();    
		// deletePhoneOfPersonOnCascadeByPhone();	
		
	}
	
	

	private static void deletePhoneOfPersonOnCascadeByPhone() {
		
		PhoneDAO phoneDao = new PhoneDAO();
		Phone phone = phoneDao.findById(2L);
		
		if(phone != null){
			phone.getPerson().deletePhone(phone);
			//FIXME: A pessoa passao a não fazer mais parte do Objeto Phone
			phoneDao.delete(phone);
		}else {
			System.out.println("Telefone inexistente!");
		}
	}



	private static void deletePersonOnCascadeAllByPhone() {
		
		PhoneDAO phoneDao = new PhoneDAO();
		Phone phone = phoneDao.findById(9L);
		if(phone != null){
			phoneDao.delete(phone.getId());
		}else {
			System.out.println("Telefone inexistente!");
		}
	}



	private static void updatePhoneWithValidator() {
		PhoneDAO phoneDao = new PhoneDAO();
		Phone phone = phoneDao.findById(3L);
		if(phone != null){
			if(phone.getType().equals(TypePhone.COMERCIAL)){
				phone.setType(TypePhone.RESIDENCIAL);
				phoneDao.update(phone);
			}else if(phone.getType().equals(TypePhone.RESIDENCIAL)){
				System.out.println("Telefone JÁ É DO tipo RESIDENCIAL!");
			}
		}else{
			System.out.println("Telefone inexistente!");
		}
	}




	private static void updatePhone() {
		
		PersonDAO personDao = new PersonDAO();
		
		Person person = personDao.findById(6L); 
		
		PhoneDAO phoneDao = new PhoneDAO();
		Phone phone = phoneDao.findById(5L);  
		phone.setPerson(person);
		
		phoneDao.update(phone);
		
		phone = phoneDao.findById(phone.getId());
		System.out.println(phone.toString());
	}


	private static void insertPhone() {
		
		Person tiago = new Person();
		tiago.setFirstName("Tiago");
		tiago.setLastName("Tibaes");
		tiago.setAge(26);
		tiago.setDocument(new Document("000.999.135-99", "MG-00.245.789"));

		Phone phone = new Phone(TypePhone.CELULAR, "035987999356");
		phone.setPerson(tiago);
		
		PhoneDAO dao = new PhoneDAO();
		
		dao.save(phone);
		
		phone = dao.findById(phone.getId());
		
		System.out.println(phone.toString());

	}

}
