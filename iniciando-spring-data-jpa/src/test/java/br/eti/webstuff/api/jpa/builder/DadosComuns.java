package br.eti.webstuff.api.jpa.builder;

import br.eti.webstuff.enumeration.TypeAddress;

public class DadosComuns {

	public static final Long ID = Long.valueOf(1);

	//FIXEME: DOCUMENTS
	public static final String CPF = "98824135055";
	public static final String RG = "243588255";
	
	//FIXEME: ADDRESSES
	public static final String CITY = "Rio de Janeiro";
	public static final String STREET = "Rua do Melão";
	public static final TypeAddress TYPE_ADDRESS = TypeAddress.RESIDENCIAL;

	//FIXEME: PERSONS
	public static final String FIRST_NAME = "Rodrigo";
	public static final String LAST_NAME = "Tibães";
	public static final Integer AGE = 30;

	public static final Object NEW_AGE = 37;
	
	

}
