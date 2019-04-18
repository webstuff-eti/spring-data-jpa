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
import br.eti.webstuff.api.jpa.entity.Address;
import br.eti.webstuff.api.jpa.entity.Document;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AddressRepositoryTest {
	
	
	@Autowired
	private AddressRepository repository;
	
	@Before
	public void setUp() throws Exception {
		Address address = new Address();
		
		address.setCity(DadosComuns.CITY);
		address.setStreet(DadosComuns.STREET);
		address.setType(DadosComuns.TYPE_ADDRESS);	
		
		this.repository.save(address);
	}
	
	@After
	public final void affterDown() {
		this.repository.deleteAll();
	}
	
	@Test
	public void buscarPorRua() {
		Address address = this.repository.findByStreet(DadosComuns.STREET);
		assertEquals(DadosComuns.STREET, address.getStreet());
	}
	
	@Test
	public void buscarPorCidade() {
		Address address = this.repository.findByCity(DadosComuns.CITY);
		assertEquals(DadosComuns.CITY, address.getCity());
	}
	
	@Test
	public void buscarPorTipoDeEndereco() {
		Address address = this.repository.findByType(DadosComuns.TYPE_ADDRESS);
		assertEquals(DadosComuns.TYPE_ADDRESS, address.getType());
	}

}
