package tqi.evolution.backend.tqi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tqi.evolution.backend.tqi.Constants;
import tqi.evolution.backend.tqi.entity.Cliente;
import tqi.evolution.backend.tqi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteService service;

	@Autowired
	public ClienteController(ClienteService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Cliente> getClientes() {
		return ResponseEntity.ok(new Cliente());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		Optional<Cliente> retorno = service.getById(id);
		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
		Optional<Cliente> retorno = service.insert(cliente);
		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}