package br.ce.sjanu.barriga.service.repositories;

import java.util.Optional;

import br.ce.sjanu.barriga.domain.Usuario;

public interface UsuarioRepository {

	Usuario salvar(Usuario usuario);
	
	Optional<Usuario> getUserByEmail(String email);
}
