package br.eti.webstuff.iniciando.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.webstuff.iniciando.jpa.entity.Document;
import br.eti.webstuff.iniciando.jpa.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;

	public Document persistir(Document document) {
		return this.repository.save(document);
	}

}
