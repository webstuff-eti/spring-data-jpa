package br.eti.webstuff.api.jpa.entity;

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

import br.eti.webstuff.enumeration.TypeAddress;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ADDRESSES")
public class Address implements Serializable {

	private static final long serialVersionUID = -6803083235726659757L;

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
	@JoinTable(name = "PERSONS_ADDRESSES", joinColumns = @JoinColumn(name = "ID_ADDRESS"), inverseJoinColumns = @JoinColumn(name = "ID_PERSON"))
	private Set<Person> persons;

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

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	
	

}

