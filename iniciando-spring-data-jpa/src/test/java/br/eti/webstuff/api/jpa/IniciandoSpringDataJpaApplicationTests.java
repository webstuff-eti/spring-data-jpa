package br.eti.webstuff.api.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class IniciandoSpringDataJpaApplicationTests {
	
	@Value("${teste.contexto.test}")
	private String contextoTest;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testeCarregarContextoDeTestes() {
		log.info("Conteto de Teste sucesso: " + contextoTest);
		assertEquals("Contexto de Testes", contextoTest);
	}

}
