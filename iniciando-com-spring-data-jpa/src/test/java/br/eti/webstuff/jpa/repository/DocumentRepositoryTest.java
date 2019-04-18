package br.eti.webstuff.jpa.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.iniciando.jpa.entity.Document;
import br.eti.webstuff.iniciando.jpa.repository.DocumentRepository;
import br.eti.webstuff.jpa.builder.DadosComuns;
import br.eti.webstuff.jpa.builder.DocumentBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DocumentRepositoryTest {
	
	@Autowired
	private DocumentRepository  documentRepository;

	@Before
	public void setUp() throws Exception {
		this.documentRepository.save(DocumentBuilder.createDocument());
	}
	
	@After
	public final void affterDown() {
		this.documentRepository.deleteAll();
	}

	@Test
	public void buscarPorCPF() {
		Document document = this.documentRepository.findByCpf(DadosComuns.CPF);
		Assert.assertEquals(DadosComuns.CPF, document.getCpf());
	}

	@Test
	public void buscarPorRG() {
		Document document = this.documentRepository.findByRg(DadosComuns.RG);
		Assert.assertEquals(DadosComuns.RG, document.getRg());
	}

	

}
