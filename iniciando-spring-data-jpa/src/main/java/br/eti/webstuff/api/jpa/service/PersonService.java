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
	
	
	//FIXME: CREATE
	public Person persistirPessoa(Person person) {
		//TODO: Validar se pessoa já existe na base de dados
		log.info("Persistindo person: {}", person);
		return this.personRepository.save(person);
	}
	
	
	//TODO: BUSCAS
	public Optional<Optional<Person>> buscarPessoaPorCpf(String cpf) {
		log.info("Buscando uma Pessoa pelo o CPF {}", cpf);
		return Optional.ofNullable(personRepository.findByDocumentCpf(cpf));
	}

	public Optional<Person> buscarPessoaPorId(Long id) {
		log.info("Buscando um lançamento pelo ID {}", id);
		return Optional.ofNullable(this.personRepository.findOne(id));
	}
	
	public Optional<Person> buscarPessoaPeloNumeroDeTelefone(String numeroTelefone) {
		log.info("Busca uma pessoa pelo número de telefone {}", numeroTelefone);
		return Optional.ofNullable(this.personRepository.findPersonByPhoneNumber(numeroTelefone));
	}
	
	//FIXME: UPDATES
	public Person alterarPessoa(Person person) {
		//TODO: Validar se pessoa já existe na base de dados
		Optional<Person> personSearch = personRepository.findByDocumentCpf(person.getDocument().getCpf());
		log.info("Alterando person: {}", person);
		return this.personRepository.save(personSearch.get());
	}
	
	public Person alterarNumeroTelefoneDaPessoaPeloCpfTipoENumTel(String cpf, String  tipoTelefone, String numNovo, String numAntigo) {
		//TODO: Validar se pessoa existe na base de dados
		//TODO: Validar se número antigo existe na base de dados
		//TODO: Validar se número novo existe na base de dados
		//TODO: Validar se tipo informado é o mesmo cadasatrado na base de dados
		Optional<Person> personSearch = personRepository.findByDocumentCpf(cpf);
		personSearch.get().getPhones().stream().filter(p -> p.getType().equals(tipoTelefone) && p.getPhoneNumber().equals(numAntigo)).forEach(p -> p.setPhoneNumber(numNovo));	
		log.info("Alterando número de Telefone da Pessoa Através do tipo do numero e CPF: {}", personSearch);
		return this.personRepository.save(personSearch.get());
	}
	
	
	//TODO: DELETE 
	public void removerPessoaPorId(Long id) {
		log.info("Excluindo a Pessoa pelo ID {}", id);
		this.personRepository.delete(id);
	}
	
	
	/*TODO: Ordena Lista de Pessoas
	public List<Person> ordenaListaDePessoas(){
		log.info("Início de Ordenação - Lista de pessoas pelo Sobrenome {}");
		
		Sort sort = OrderList.ordenaListaPorParametro("lastName");
		
		List<Person> persons = this.personRepository.findAll(sort);
		
		return persons;
	}
	*/

	
}
