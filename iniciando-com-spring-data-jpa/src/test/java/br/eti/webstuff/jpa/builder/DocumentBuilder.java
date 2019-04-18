package br.eti.webstuff.jpa.builder;

import br.eti.webstuff.iniciando.jpa.entity.Document;

public class DocumentBuilder {

	public static Document createDocument() {
		Document document = new Document();
		document.setCpf(DadosComuns.CPF);
		document.setRg(DadosComuns.RG);
		return document;
	}

}
