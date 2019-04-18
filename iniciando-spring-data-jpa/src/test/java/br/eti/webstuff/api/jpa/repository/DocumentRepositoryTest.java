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

import br.eti.webstuff.api.jpa.entity.Document;
import br.eti.webstuff.api.jpa.builder.DadosComuns;



@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DocumentRepositoryTest {
	
	@Autowired
	private DocumentRepository repository;
	
	@Before
	public void setUp() throws Exception {
		Document document = new Document();
		document.setCpf(DadosComuns.CPF);
		document.setRg(DadosComuns.RG);
		this.repository.save(document);
	}
	
	@After
	public final void affterDown() {
		this.repository.deleteAll();
	}
	
	@Test
	public void buscarPorCPF() {
		Document document = this.repository.findByCpf(DadosComuns.CPF);
		assertEquals(DadosComuns.CPF, document.getCpf());
	}
	
	@Test
	public void buscarPorRG() {
		Document document = this.repository.findByRg(DadosComuns.RG);
		assertEquals(DadosComuns.RG, document.getRg());
	}

}
