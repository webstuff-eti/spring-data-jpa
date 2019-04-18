package br.eti.webstuff.iniciando.jpa.entity.dto;

public class DocumentResponseDto {

	private Long id;
	private String cpf;
	private String rg;

	public DocumentResponseDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return "DocumentResponseDto [id=" + id + ", cpf=" + cpf + ", rg=" + rg + "]";
	}

}
