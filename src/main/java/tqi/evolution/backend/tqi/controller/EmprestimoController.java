package tqi.evolution.backend.tqi.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tqi.evolution.backend.tqi.entity.Cliente;
import tqi.evolution.backend.tqi.entity.Emprestimo;
import tqi.evolution.backend.tqi.service.ClienteService;
import tqi.evolution.backend.tqi.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmprestimoService service;
	@Autowired
	private ClienteService clienteService;

	public EmprestimoController(EmprestimoService service, ClienteService clienteService) {
		this.service = service;
		this.clienteService = clienteService;
	}

	@GetMapping("{id}")
	public ResponseEntity<Emprestimo> getById(@PathVariable Long id) {
		log.info("/emprestimo/{id}=" + id);

		Optional<Emprestimo> retorno = service.getById(id);
		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<List<Emprestimo>> getEmprestimosPorClienteById(@PathVariable Long id) {
		log.info("/emprestimo/cliente/{id}=" + id);

		Optional<Cliente> retorno = clienteService.getById(id);
		if (!retorno.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(retorno.get().getEmprestimo());
	}
}