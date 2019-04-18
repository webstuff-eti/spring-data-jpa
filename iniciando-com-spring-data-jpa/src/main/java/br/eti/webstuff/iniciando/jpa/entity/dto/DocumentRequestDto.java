package br.eti.webstuff.iniciando.jpa.entity.dto;

import java.util.Optional;

public class DocumentRequestDto {

	private Optional<Long> id = Optional.empty();
	private String cpf;
	private String rg;

	public DocumentRequestDto() {

	}

	public Optional<Long> getId() {
		return id;
	}

	public void setId(Optional<Long> id) {
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

	@Override
	public String toString() {
		return "DocumentRequestDto [id=" + id + ", cpf=" + cpf + ", rg=" + rg + "]";
	}

}
