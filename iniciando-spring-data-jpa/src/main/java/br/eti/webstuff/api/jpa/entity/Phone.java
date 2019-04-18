package br.eti.webstuff.api.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.eti.webstuff.enumeration.TypePhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@AllArgsConstructor
@EqualsAndHashCode
@Data
@ToString
@Entity
@Table(name = "PHONES")
public class Phone implements Serializable {
	
	private static final long serialVersionUID = 5139306366940135770L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PHONE")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_PHONE", nullable = false)
	private TypePhone type;

	@Column(name = "NUMBER", nullable = false)
	private String number;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "PERSON_ID")
	private Person person;
	
	
//	public Phone() {
//		super();
//	}
//
//	public Phone(TypePhone type, String number) {
//		this.type = type;
//		this.number = number;
//	}

}
