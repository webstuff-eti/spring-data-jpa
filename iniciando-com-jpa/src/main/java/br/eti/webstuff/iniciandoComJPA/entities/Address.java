package br.eti.webstuff.iniciandoComJPA.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESSES")
public class Address implements Serializable {

	private static final long serialVersionUID = -6283231834726046256L;

	public enum TypeAddress {
		COMERCIAL, RESIDENCIAL
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADDRESS")
	private Long id;

	@Column(name = "CITY", nullable = false)
	private String city;

	@Column(name = "STREET", nullable = false)
	private String street;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_ADDRESS", nullable = false)
	private TypeAddress type;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PERSONS_ADDRESSES", joinColumns = @JoinColumn(name = "ID_ADDRESS"), // ,
																							// referencedColumnName="id"
			inverseJoinColumns = @JoinColumn(name = "ID_PERSON") // ,
																	// referencedColumnName="id"
	)

	private Set<Person> persons; // = new HashSet();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public TypeAddress getType() {
		return type;
	}

	public void setType(TypeAddress type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", type=" + type + ", persons=" + persons
				+ "]";
	}

}
