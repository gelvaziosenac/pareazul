package bancocrudspringboot.controller;

import bancocrudspringboot.exception.ResourceNotFoundException;
import bancocrudspringboot.model.Login;
import bancocrudspringboot.model.Usuario;
import bancocrudspringboot.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getAllCadastros() {
		return this.usuarioRepository.findAll();
	}

	// Login
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public Usuario login(@Validated @RequestBody Login cadastro) throws ResourceNotFoundException {

		String telefone = cadastro.getTelefone();
		String senha = cadastro.getSenha();

		Usuario usuario = this.usuarioRepository.findUsuarioByTelefoneAndSenha(telefone, senha)
			.orElseThrow(() -> new ResourceNotFoundException("Usuario ou senha inválido!"));

		return usuario;
	}
}