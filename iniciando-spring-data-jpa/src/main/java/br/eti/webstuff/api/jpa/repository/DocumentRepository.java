package br.eti.webstuff.api.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.eti.webstuff.api.jpa.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{
	
	@Transactional(readOnly = true)
	Document findByCpf(String cpj);
	
	@Transactional(readOnly = true)
	Document findByRg(String rg);

}
