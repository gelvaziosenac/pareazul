package bancocrudspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import bancocrudspringboot.model.Estacionamento;
import bancocrudspringboot.repository.EstacionamentoRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
    
	// Listar
	@GetMapping("/estacionamento")
	@ResponseStatus(HttpStatus.OK)
	public List<Estacionamento> getAllCadastros() {
		return this.estacionamentoRepository.findAll();
	}
	
	// Listar
	@GetMapping("/estacionamentoordenado")
	@ResponseStatus(HttpStatus.OK)
	public List<Estacionamento> getAllCadastrosOrdenado() {
		return this.estacionamentoRepository.findAllOrderByIdDesc();
	}
		
	// Inserir
	@PostMapping("/estacionamento")
	@ResponseStatus(HttpStatus.CREATED)
	public Estacionamento createCadastro(@RequestBody Estacionamento cadastro) {
		cadastro.setValorporhora("2");
		return this.estacionamentoRepository.save(cadastro);
	}
}