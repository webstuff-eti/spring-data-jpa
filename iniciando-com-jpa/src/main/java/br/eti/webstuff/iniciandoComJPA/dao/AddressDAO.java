package br.eti.webstuff.iniciandoComJPA.dao;

import java.util.List;

import br.eti.webstuff.iniciandoComJPA.entities.Address;

public class AddressDAO extends GenericDAO<Address> {

	public AddressDAO() {
		super(Address.class);
	}

	public List<Address> findByListCity(String city) {

	  String jpql = "FROM Address a WHERE a.city LIKE ?1";
	  
	  return find(jpql, city);
	}

}
