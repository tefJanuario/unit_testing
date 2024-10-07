package br.ce.sjanu.barriga.infra;

import static br.ce.sjanu.barriga.domain.builders.UsuarioBuilder.umUsuario;

import java.util.Optional;

import br.ce.sjanu.barriga.domain.Usuario;
import br.ce.sjanu.barriga.service.repositories.UsuarioRepository;

public class UsuarioDummyRepository implements UsuarioRepository {
	
	
	@Override
	public Usuario salvar(Usuario usuario) {
		return umUsuario()
				.comNome(usuario.getNome())
				.comEmail(usuario.getEmail())
				.comSenha(usuario.getSenha())
			.agora();
	}

	@Override
	public Optional<Usuario> getUserByEmail(String email) {
		if(email.equals("user@mail.com"))
			return Optional.of(umUsuario().comEmail(email).agora());
		return Optional.empty();
	}

}
