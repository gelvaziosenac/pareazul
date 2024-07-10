package bancocrudspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import bancocrudspringboot.exception.ResourceNotFoundException;
import bancocrudspringboot.model.Cartao;
import bancocrudspringboot.model.Perfil;
import bancocrudspringboot.model.Veiculo;
import bancocrudspringboot.repository.PerfilRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PerfilController {

	@Autowired
	private PerfilRepository perfilRepository;
    
	// Listar
	@GetMapping("/perfil")
	@ResponseStatus(HttpStatus.OK)
	public List<Perfil> getAllCadastros() {
		return this.perfilRepository.findAll();
	}
		
	// Inserir
	@PostMapping("/perfil")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil createCadastro(@RequestBody Perfil cadastro) {
		return this.perfilRepository.save(cadastro);
	}

	// Listar um perfil pelo telefone
	@GetMapping("/perfil/{telefone}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Perfil> getCadastroByTelefone(@PathVariable(value = "telefone") String telefone)
	throws ResourceNotFoundException {
		Perfil cadastro = perfilRepository.findPerfilByTelefone(telefone)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado para o telefone : " + telefone));
		
		return ResponseEntity.ok().body(cadastro);
	}
}