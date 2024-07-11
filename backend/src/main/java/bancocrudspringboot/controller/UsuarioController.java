package bancocrudspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bancocrudspringboot.exception.ResourceNotFoundException;
import bancocrudspringboot.model.Login;
import bancocrudspringboot.model.Usuario;
import bancocrudspringboot.repository.UsuariosRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuariosRepository usuarioRepository;

	@GetMapping("/usuario")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getAllCadastros() {
		return this.usuarioRepository.findAll();
	}

	// Inserir
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario createCadastro(@RequestBody Usuario cadastro) {
		return this.usuarioRepository.save(cadastro);
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