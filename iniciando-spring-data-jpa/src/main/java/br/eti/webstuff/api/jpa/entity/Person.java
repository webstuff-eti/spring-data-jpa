package br.eti.webstuff.api.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "PERSONS", indexes = {
		@Index(columnList = "FIRST_NAME, LAST_NAME", name = "IDX_PERSON_NAME", unique = true) })
public class Person implements Serializable {

	private static final long serialVersionUID = 7460596290825967253L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSON")
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 60)
	private String lastName;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PERSONS_ADDRESSES", joinColumns = @JoinColumn(name = "ID_PERSON"), inverseJoinColumns = @JoinColumn(name = "ID_ADDRESS"))

	private Set<Address> addresses;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Phone> phones;

	public void addPhone(Phone phone) {
		if (phones == null) {
			phones = new ArrayList<Phone>();
		}
		phone.setPerson(this);
		phones.add(phone);
	}

	public void deletePhone(Phone phone) {
		if (phones != null) {
			phones.remove(phone);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	

	

}