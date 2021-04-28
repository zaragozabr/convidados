package br.com.fiap.convidados.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.fiap.convidados.entity.ConvidadoEntity;

public class ConvidadoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String acompanhantes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(String acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public ConvidadoEntity toConvidadoEntity() {
		ConvidadoEntity convidadoEntity = new ConvidadoEntity();
		convidadoEntity.setAcompanhantes(this.acompanhantes);
		convidadoEntity.setNome(this.nome);
		convidadoEntity.setEmail(this.email);
		convidadoEntity.setId(this.id);
		return convidadoEntity;
	}

}
