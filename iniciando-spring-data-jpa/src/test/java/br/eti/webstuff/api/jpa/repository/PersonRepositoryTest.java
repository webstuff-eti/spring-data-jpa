package br.eti.webstuff.api.jpa.repository;

import static org.junit.Assert.assertEquals;

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
		
		//TODO: Criar documento e setar em baixo
		//person.setDocument(document);
		
		//TODO: Criar Lista de Phones e setar em baixo
		//person.setPhones(phones);
		
		//TODO: Criar Lista de Phones e setar em baixo
		//person.setAddresses(addresses);
		
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
		Person person = this.repository.findByDocument(DadosComuns.CPF);
		assertEquals(DadosComuns.CPF, person.getDocument().getCpf());
	}
	
	@Test
	public void buscarPeloDocumentoRg() {
		Person person = this.repository.findByDocument(DadosComuns.RG);
		assertEquals(DadosComuns.RG, person.getDocument().getRg());
	}
	

}
