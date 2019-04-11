package br.eti.webstuff.iniciandoComJPA.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENTS")
public class Document implements Serializable {
	
	private static final long serialVersionUID = 4282805585863570118L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CPF", nullable = false, length = 14, unique = true)
	private String cpf;

	@Column(name = "RG", nullable = false, length = 14, unique = true)
	private String rg;
	
	/*
	  Regra JPA: ToOne  - >  FetchType.EAGER [é default]
	             ToMany - >  FetchType.LAZY
	*/
	
	//@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;

	public Document() {
		super();
	}

	public Document(String cpf, String rg) {
		this.cpf = cpf;
		this.rg = rg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", cpf=" + cpf + ", rg=" + rg + ", document=" + document + "]";
	}

}
