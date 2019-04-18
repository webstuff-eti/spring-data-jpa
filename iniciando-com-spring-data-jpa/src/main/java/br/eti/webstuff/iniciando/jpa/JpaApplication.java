package br.eti.webstuff.iniciando.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.eti.webstuff.iniciando.jpa.repository.DocumentRepository;

@SpringBootApplication
@ComponentScan(basePackageClasses = {DocumentRepository.class})
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
