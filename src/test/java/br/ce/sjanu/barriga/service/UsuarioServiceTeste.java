package br.ce.sjanu.barriga.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ce.sjanu.barriga.domain.Usuario;
import br.ce.sjanu.barriga.domain.builders.UsuarioBuilder;
import br.ce.sjanu.barriga.infra.UsuarioDummyRepository;

public class UsuarioServiceTeste {
	private UsuarioService service;
	
	@Test
	public void deveSalvarUsuarioComSucesso() {
		service = new UsuarioService(new UsuarioDummyRepository());
		Usuario user = UsuarioBuilder.umUsuario().comId(null).comEmail("outro@email.com").agora();
		Usuario saveUser = service.salvar(user);
		Assertions.assertNotNull(saveUser.getId());
	}
}
