package br.eti.webstuff.api.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.webstuff.api.jpa.entity.Document;
import br.eti.webstuff.api.jpa.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressService {
	
	@Autowired
	private DocumentRepository repository;
	
	

}
