package br.eti.webstuff.iniciando.jpa.converters;

import br.eti.webstuff.iniciando.jpa.entity.Document;
import br.eti.webstuff.iniciando.jpa.entity.dto.DocumentRequestDto;
import br.eti.webstuff.iniciando.jpa.entity.dto.DocumentResponseDto;

public class ConverterDocument {

	public Document converterDocumentRequestDtoToDocument(DocumentRequestDto documentRequestDto) {
		Document doc = new Document();
		doc.setCpf(documentRequestDto.getCpf());
		doc.setRg(documentRequestDto.getRg());
		return doc;
	}

	public Object converterDocumentToDocumentResponseDto(Document doc) {
		DocumentResponseDto docR = new DocumentResponseDto();
		docR.setCpf(doc.getCpf());
		docR.setRg(doc.getRg());
		return docR;
	}

}
