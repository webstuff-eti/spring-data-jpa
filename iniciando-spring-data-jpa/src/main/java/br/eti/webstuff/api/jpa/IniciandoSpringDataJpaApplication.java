package br.eti.webstuff.api.jpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class IniciandoSpringDataJpaApplication {

	@Value("${teste.contexto.dev}")
	private String contextoDev;

	public static void main(String[] args) {
		SpringApplication.run(IniciandoSpringDataJpaApplication.class, args);
	}

	// FIXME: Testando configurações - application.properties
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Teste de contexto: " + this.contextoDev);
		};
	}

}
