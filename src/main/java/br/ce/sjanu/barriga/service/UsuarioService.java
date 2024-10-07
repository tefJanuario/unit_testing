package br.ce.sjanu.barriga.service;

import br.ce.sjanu.barriga.domain.Usuario;
import br.ce.sjanu.barriga.domain.exceptions.ValidationException;
import br.ce.sjanu.barriga.service.repositories.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario salvar(Usuario usuario) {
		repository.getUserByEmail(usuario.getEmail()).ifPresent(user -> {
			throw new ValidationException(String.format("Usuário %s já cadastrado!", usuario.getEmail()));
		});
		return repository.salvar(usuario);	
	}
}
