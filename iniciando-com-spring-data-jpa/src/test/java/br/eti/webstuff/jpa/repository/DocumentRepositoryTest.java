package br.eti.webstuff.jpa.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.webstuff.iniciando.jpa.entity.Document;
import br.eti.webstuff.iniciando.jpa.repository.DocumentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DocumentRepositoryTest {

	private static final Object CPF = "98824135013";
	private static final String RG = "243588203";
	
	@Autowired
	private DocumentRepository repository;

	@Before
	public void setUp() throws Exception {
		Document document = new Document();

		this.repository.save(document);
	}

	@Test
	public void buscarPorCPF() {
		Document document = this.repository.findByCpf((String) CPF);
		assertEquals(CPF, document.getCpf());
	}

	@Test
	public void buscarPorRG() {
		Document document = this.repository.findByRg(RG);
		assertEquals(RG, document.getRg());
	}

	@After
	public final void affterDown() {
		this.repository.deleteAll();
	}

}
