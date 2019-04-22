package br.eti.webstuff.api.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.webstuff.api.jpa.entity.Person;
import br.eti.webstuff.api.jpa.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	public Optional<Person> buscarPessoaPorCpf(String cpf) {
		log.info("Buscando uma Pessoa pelo o CPF {}", cpf);
		return Optional.ofNullable(personRepository.findByDocumentCpf(cpf));
	}

	public Person persistirPessoa(Person person) {
		log.info("Persistindo person: {}", person);
		return this.personRepository.save(person);
	}
	
	
	public Person alterarPessoa(Person person) {
		log.info("Persistindo person: {}", person);
		return this.personRepository.save(person);
	}
	
	
	public Optional<Person> buscarPessoaPorId(Long id) {
		log.info("Buscando um lançamento pelo ID {}", id);
		return Optional.ofNullable(this.personRepository.findOne(id));
	}

	public void removerPessoaPorId(Long id) {
		log.info("Excluindo a Pessoa pelo ID {}", id);
		this.personRepository.delete(id);
	}

	
}
