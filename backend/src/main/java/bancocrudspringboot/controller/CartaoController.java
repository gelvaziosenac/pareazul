package bancocrudspringboot.controller;

import bancocrudspringboot.exception.ResourceNotFoundException;
import bancocrudspringboot.model.Cartao;
// import bancocrudspringboot.model.ConsultaPadrao;
// import bancocrudspringboot.model.OperadoresConsulta;
import bancocrudspringboot.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;
    
	// Listar todos os cartões
	@GetMapping("/cartao")
	@ResponseStatus(HttpStatus.OK)
	public List<Cartao> getAllCadastros() {
		return this.cartaoRepository.findAll();
	}
    
	// Listar um cartao pelo usuario
	@GetMapping("/cartaousuario/{usuario}")
	@ResponseStatus(HttpStatus.OK)
	public List<Cartao> getCadastroByUsuario(@PathVariable(value = "usuario") Long usuario)
	throws ResourceNotFoundException {
		return cartaoRepository.findCartaoByUsuario(usuario);
	}

	// Listar um cartao pelo id
	@GetMapping("/cartao/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cartao> getCadastroById(@PathVariable(value = "id") Long cadastroId)
	throws ResourceNotFoundException {
		Cartao cadastro = cartaoRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro de cartão não encontrado para o ID : " + cadastroId));
		
		return ResponseEntity.ok().body(cadastro);
	}
		
	// Inserir cartao
	@PostMapping("/cartao")
	@ResponseStatus(HttpStatus.CREATED)
	public Cartao createCadastro(@RequestBody Cartao cadastro){
		return this.cartaoRepository.save(cadastro);
	}
    
	// alterar cartao    
	@PutMapping("/cartao/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cartao> updateCadastro(@PathVariable(value = "id") Long cadastroId,
												  @Validated 
												  @RequestBody 
                Cartao cadastroCaracteristicas) throws ResourceNotFoundException {
                Cartao cadastro = cartaoRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado para o ID : " + cadastroId));

		cadastro.setNumero(cadastroCaracteristicas.getNumero());
		cadastro.setNome(cadastroCaracteristicas.getNome());
		cadastro.setDataexpiracao(cadastroCaracteristicas.getDataexpiracao());
		cadastro.setCvv(cadastroCaracteristicas.getCvv());

		return ResponseEntity.ok(this.cartaoRepository.save(cadastro));
	}

	// deletar cartao
	@DeleteMapping("/cartao/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> deleteCadastro(@PathVariable(value = "id") Long cadastroId)
			throws ResourceNotFoundException {
                Cartao cadastro = cartaoRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado para o ID : " + cadastroId));

		this.cartaoRepository.delete(cadastro);

		Map<String, Boolean> resposta = new HashMap<>();

		resposta.put("cartão deletado", Boolean.TRUE);

		return resposta;
	}	
}




