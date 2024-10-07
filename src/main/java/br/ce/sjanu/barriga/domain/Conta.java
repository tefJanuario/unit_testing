package br.ce.sjanu.barriga.domain;

import br.ce.sjanu.barriga.domain.exceptions.ValidationException;

public class Conta {
	private Long id;
	private String nome;
	private Usuario usuario;

	public Conta(Long id, String nome, Usuario usuario) {
		if(nome == null) throw new ValidationException("Nome é obrigatório");
		if(usuario == null) throw new ValidationException("Usuário é obrigatório");
		
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
