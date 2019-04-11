package br.eti.webstuff.iniciandoComJPA.teste.funcional.dao.persion;

import br.eti.webstuff.iniciandoComJPA.dao.DocumentDAO;
import br.eti.webstuff.iniciandoComJPA.entities.Document;

public class AppRunTestDocumentDAO {

	public static void main(String[] args) {
		
		
		updateDocument();

	}

	private static void updateDocument() {
		
		Document document = new DocumentDAO().findById(2L);
		
		System.out.println(document.toString());
		
		document.setCpf("023.157.189-92");
		
		new DocumentDAO().update(document);
		
		
		
		
		
	}

}
