package br.ce.sjanu.barriga.domain;

import static br.ce.sjanu.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ce.sjanu.barriga.domain.exceptions.ValidationException;

public class UsuarioTest {

	@Test
	@DisplayName("Deve criar um usuário válido")
	public void deveCriarUsuarioValido() {
		Usuario usuario = umUsuario().agora();
		Assertions.assertAll("Usuario",
				() -> assertEquals(1L, usuario.getId()),
				() -> assertEquals("Usuário válido", usuario.getNome()),
				() -> assertEquals("user@mail.com", usuario.getEmail()),
				() -> assertEquals("123456", usuario.getSenha())

		);
	}
	
	@Test
	@DisplayName("Deve rejeitar usuário sem nome")
	public void deveRejeitarUsuarioSemNome() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
			umUsuario().comNome(null).agora());
		assertEquals("Nome é obrigatório", ex.getMessage());
	}
}
