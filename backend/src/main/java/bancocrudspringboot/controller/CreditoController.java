package bancocrudspringboot.controller;

import bancocrudspringboot.exception.ResourceNotFoundException;
import bancocrudspringboot.model.Credito;
import bancocrudspringboot.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CreditoController {

	@Autowired
	private CreditoRepository creditoRepository;
    
	// Listar todos os cartões
	@GetMapping("/credito")
	@ResponseStatus(HttpStatus.OK)
	public List<Credito> getAllCadastros() {
		return this.creditoRepository.findAll();
	}
    
	// Listar um cartao pelo usuario
	@GetMapping("/creditousuario/{usuario}")
	@ResponseStatus(HttpStatus.OK)
	public Credito getCadastroByUsuario(@PathVariable(value = "usuario") Long usuario)
	throws ResourceNotFoundException {
		return creditoRepository.findCreditoByUsuario(usuario);
	}

	// alterar credito pelo id
	@PutMapping("/atualizasaldo/{credito_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Credito> updateCadastro(@PathVariable(value = "credito_id") Long cadastroId,
												  @RequestBody 
                								  Credito cadastroCaracteristicas) throws ResourceNotFoundException {

					Credito cadastro = creditoRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro não encontrado para o ID : " + cadastroId));

		cadastro.setValor(cadastroCaracteristicas.getValor());

		return ResponseEntity.ok(this.creditoRepository.save(cadastro));
	}

	// Atualiza saldo do usuario
	@PostMapping("/atualizasaldo")
	@ResponseStatus(HttpStatus.CREATED)
	public Credito atualizaSaldo(@RequestBody Credito cadastroFrontend) {		
		long usuario = cadastroFrontend.getUsuario();
		
		// Atualizando o saldo
		Credito creditoAtualBancoDados = creditoRepository.findCreditoByUsuario(usuario);		
		if(creditoAtualBancoDados != null){
			// Atualizar o saldo existente
			creditoAtualBancoDados.setValor(cadastroFrontend.getValor());

			return this.creditoRepository.save(creditoAtualBancoDados);
		}

		// Insere um novo saldo, quando nao existe nenhum saldo no banco de dados
		return this.creditoRepository.save(cadastroFrontend);
	}
}
