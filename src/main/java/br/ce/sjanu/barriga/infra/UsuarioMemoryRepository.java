package br.ce.sjanu.barriga.infra;

import java.awt.desktop.UserSessionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.ce.sjanu.barriga.domain.Usuario;
import br.ce.sjanu.barriga.service.repositories.UsuarioRepository;

public class UsuarioMemoryRepository implements UsuarioRepository {
	private List<Usuario> users;
	private Long currentId;
	
	public UsuarioMemoryRepository() {
		currentId = 0L;
		users = new ArrayList<>();
		salvar(new Usuario(null, "User #1", "user1@mail.com", "123456"));
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		Usuario newUser = new Usuario(nextId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
		users.add(newUser);
		return newUser;
	}

	@Override
	public Optional<Usuario> getUserByEmail(String email) {
		return users.stream()
				.filter(user -> user.getEmail().equalsIgnoreCase(email))
				.findFirst();
	}
	
	public void printUsers() {
		System.out.println(users);
	}

	private Long nextId() {
		return ++currentId;
	}
	
	public static void main(String[] args) {
		UsuarioMemoryRepository repo = new UsuarioMemoryRepository();
		repo.salvar(new Usuario(null, "User #2", "user2@mail.com", "654321"));
		repo.salvar(new Usuario(null, null, "user2@mail.com", "654321"));
		repo.printUsers();
	}
}
