package tqi.evolution.backend.tqi.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tqi.evolution.backend.tqi.entity.Emprestimo;
import tqi.evolution.backend.tqi.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	private EmprestimoRepository repository;

	@Autowired
	public EmprestimoService(EmprestimoRepository repository) {
		this.repository = repository;
	}

	public Optional<Emprestimo> getById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Optional<Emprestimo> insert(Emprestimo emprestimo) {
		Emprestimo newe = repository.save(emprestimo);
		return getById(newe.getId());
	}
}