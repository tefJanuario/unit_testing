package br.ce.sjanu.barriga.domain;

import static br.ce.sjanu.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import br.ce.sjanu.barriga.domain.exceptions.ValidationException;

public class UsuarioTest {

	@Test
	@DisplayName("Deve criar um usuário válido")
	public void deveCriarUsuarioValido() {
		Usuario usuario = umUsuario().agora();
		Assertions.assertAll("Usuario", () -> assertEquals(1L, usuario.getId()),
				() -> assertEquals("Usuário válido", usuario.getNome()),
				() -> assertEquals("user@mail.com", usuario.getEmail()),
				() -> assertEquals("123456", usuario.getSenha())

		);
	}

	@Test
	@DisplayName("Deve rejeitar usuário sem nome")
	public void deveRejeitarUsuarioSemNome() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class,
				() -> umUsuario().comNome(null).agora());
		assertEquals("Nome é obrigatório", ex.getMessage());
	}

	@Test
	@DisplayName("Deve rejeitar usuário sem email")
	public void deveRejeitarUsuarioSemEmail() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class,
				() -> umUsuario().comEmail(null).agora());
		assertEquals("Email é obrigatório", ex.getMessage());
	}

	@Test
	@DisplayName("Deve rejeitar usuário sem senha")
	public void deveRejeitarUsuarioSemSenha() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class,
				() -> umUsuario().comSenha(null).agora());
		assertEquals("Senha é obrigatória", ex.getMessage());
	}
	
	@ParameterizedTest(name = "[{index}] - {4}")
	@CsvSource(value = {
			"1, NULL, user@mail.com, 123456, Nome é obrigatório",
			"1, Usuário válido, NULL, 123456, Email é obrigatório",
			"1, Usuário válido, user@mail.com, NULL, Senha é obrigatória"
	}, nullValues = "NULL")
	public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String mensagem) {
		ValidationException ex = Assertions.assertThrows(ValidationException.class,
				() -> umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
		assertEquals(mensagem, ex.getMessage());
	}
	
//	para usar primeira linha como cabeçalho também  useHeadersInDisplayName = true
	@ParameterizedTest(name = "[{index}] - {4}")
	@CsvFileSource(files = "src\\test\\resources\\camposObrigatorioUsuario.csv", nullValues = "NULL", numLinesToSkip = 1)
	public void deveValidarCamposObrigatoriosOutraOpcao(Long id, String nome, String email, String senha, String mensagem) {
		ValidationException ex = Assertions.assertThrows(ValidationException.class,
				() -> umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
		assertEquals(mensagem, ex.getMessage());
	}
	
	
	
}
