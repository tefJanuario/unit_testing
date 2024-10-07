package br.ce.sjanu.barriga.infra;

import static br.ce.sjanu.barriga.domain.builders.UsuarioBuilder.umUsuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.ce.sjanu.barriga.domain.Usuario;
import br.ce.sjanu.barriga.domain.exceptions.ValidationException;
import br.ce.sjanu.barriga.service.UsuarioService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {
	private static UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());
	
	@Test
	@Order(1)
	public void deveSalvarUsuarioValido() {
		Usuario user = service.salvar(umUsuario().comId(null).agora());
		Assertions.assertNotNull(user.getId());
	}
	
	@Test
	@Order(2)
	public void deveRejeitarUsuarioExistente() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
			service.salvar(umUsuario().comId(null).agora());
		});
		Assertions.assertEquals("Usuário user@mail.com já cadastrado!", ex.getMessage());
	}
}
