package br.eti.webstuff.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DOCUMENTS")
public class Document implements Serializable {

	private static final long serialVersionUID = 4282805585863570118L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CPF", nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(name = "RG", nullable = false, length = 9, unique = true)
	private String rg;

}
