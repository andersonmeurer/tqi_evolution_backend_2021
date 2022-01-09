package tqi.evolution.backend.tqi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tqi.evolution.backend.tqi.entity.Cliente;
import tqi.evolution.backend.tqi.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}

	public Optional<Cliente> getById(Long id) {
		return repository.findById(id);
	}

	public Optional<Cliente> insert(Cliente cliente) {
		Cliente newCliente = repository.save(cliente);
		return getById(newCliente.getId());
	}
}