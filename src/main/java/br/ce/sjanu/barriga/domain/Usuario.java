package br.ce.sjanu.barriga.domain;

import java.util.Objects;

import br.ce.sjanu.barriga.domain.exceptions.ValidationException;

public class Usuario {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario(Long id, String nome, String email, String senha) {
		if(nome == null) throw new ValidationException("Nome é obrigatório");
		if(email == null) throw new ValidationException("Email é obrigatório");
		if(senha == null) throw new ValidationException("Senha é obrigatória");
			
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
	
}
