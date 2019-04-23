package br.eti.webstuff.api.jpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.api.jpa.builder.DadosComuns;
import br.eti.webstuff.api.jpa.entity.Document;
import br.eti.webstuff.api.jpa.entity.Person;
import br.eti.webstuff.api.jpa.entity.Phone;
import br.eti.webstuff.enumeration.TypePhone;

import br.eti.webstuff.api.jpa.entity.Address;
import br.eti.webstuff.enumeration.TypeAddress;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersonRepositoryTest {

	@Autowired
	PersonRepository repository;

	@Before
	public void setUp() throws Exception {

		Person person = new Person();

		person.setFirstName(DadosComuns.FIRST_NAME);
		person.setLastName(DadosComuns.LAST_NAME);
		person.setAge(DadosComuns.AGE);

		Document document = new Document();
		document.setCpf(DadosComuns.CPF);
		document.setRg(DadosComuns.RG);

		person.setDocument(document);

		Phone phoneCel = new Phone();
		phoneCel.setPhoneNumber("11967549867");
		phoneCel.setType(TypePhone.CELULAR);

		Phone phoneResidencial = new Phone();
		phoneResidencial.setPhoneNumber("1167549867");
		phoneResidencial.setType(TypePhone.RESIDENCIAL);

		Phone phoneComercial = new Phone();
		phoneComercial.setPhoneNumber("1134459834");
		phoneComercial.setType(TypePhone.COMERCIAL);

		person.addPhone(phoneCel);
		person.addPhone(phoneResidencial);
		person.addPhone(phoneComercial);

		Address addressHome = new Address();
		addressHome.setCity("Sorocaba");
		addressHome.setStreet("Rua dfsfsdfdsf, 99");
		addressHome.setType(TypeAddress.RESIDENCIAL);

		Address addressWork = new Address();
		addressWork.setCity("Sorocaba");
		addressWork.setStreet("Rua nhggn, 88");
		addressWork.setType(TypeAddress.COMERCIAL);

		Set<Address> ad = new HashSet<Address>();
		ad.add(addressWork);
		ad.add(addressHome);

		person.setAddresses(ad);

		this.repository.save(person);
	}

	@After
	public final void affterDown() {
		this.repository.deleteAll();
	}

	@Test
	public void buscarPeloPrimeiroNome() {
		Person person = this.repository.findByFirstName(DadosComuns.FIRST_NAME);
		assertEquals(DadosComuns.FIRST_NAME, person.getFirstName());
	}

	@Test
	public void buscarPeloUltimoNome() {
		Person person = this.repository.findByLastName(DadosComuns.LAST_NAME);
		assertEquals(DadosComuns.LAST_NAME, person.getLastName());
	}

	@Test
	public void buscarPelaIdade() {
		Person person = this.repository.findByAge(DadosComuns.AGE);
		assertEquals(DadosComuns.AGE, person.getAge());
	}

	@Test
	public void buscarPeloDocumentoCpf() {
		Optional<Person> person = this.repository.findByDocumentCpf(DadosComuns.CPF);
		assertTrue(person.isPresent());
		assertEquals(DadosComuns.CPF, person.get().getDocument().getCpf());
	}

	@Test
	public void buscarPeloDocumentoRg() {
		Person person = this.repository.findByDocumentRg(DadosComuns.RG);
		assertEquals(DadosComuns.RG, person.getDocument().getRg());
	}

	@Test
	public void buscarPeloId() {
		Person person = this.repository.findOne(DadosComuns.ID);
		assertEquals(DadosComuns.ID, person.getId());
	}

	@Test
	public void buscarPeloParamId() {
		Person person = this.repository.findById(DadosComuns.ID);
		assertEquals(DadosComuns.ID, person.getId());
	}

	// @Test
	// public void alteraPersonPeloId() {
	//
	// Person pessoaBuscada = this.repository.findOne(DadosComuns.ID);
	// assertEquals(DadosComuns.AGE, pessoaBuscada.getAge());
	//
	// pessoaBuscada.setAge(55);
	//
	// this.repository.save(pessoaBuscada);
	// Person p = this.repository.findOne(pessoaBuscada.getId());
	// assertEquals(DadosComuns.NEW_AGE, p.getAge());
	//
	// }

}
