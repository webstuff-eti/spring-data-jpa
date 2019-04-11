package br.eti.webstuff.iniciandoComJPA.dao;

import br.eti.webstuff.iniciandoComJPA.entities.Address;

public class AddressDAO extends GenericDAO<Address> {

	public AddressDAO() {
		super(Address.class);
	}

}
