package br.eti.webstuff.iniciando.jpa.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.iniciando.jpa.converters.ConverterDocument;
import br.eti.webstuff.iniciando.jpa.entity.Document;
import br.eti.webstuff.iniciando.jpa.entity.dto.DocumentRequestDto;
import br.eti.webstuff.iniciando.jpa.entity.dto.DocumentResponseDto;
import br.eti.webstuff.iniciando.jpa.service.DocumentService;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class DocumentController {
	
	private static final Logger log = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService service;
	
	
	@PostMapping
	public ResponseEntity<DocumentResponseDto> cadastrar(@Valid 
			                                             @RequestBody DocumentRequestDto documentRequestDto, 
			                                             BindingResult result)
			                                             throws NoSuchAlgorithmException {
		
		log.info("Cadastro de Documento apenas como Test: {}", documentRequestDto.toString());
		
		ConverterDocument converter = new ConverterDocument();
		

		
		Document docP = converter.converterDocumentRequestDtoToDocument(documentRequestDto);
		
	
		
		Document doc = this.service.persistir(docP);
		
		DocumentResponseDto dtoR = (DocumentResponseDto) converter.converterDocumentToDocumentResponseDto(doc);
		
		
		return ResponseEntity.ok(dtoR);
	}

}
