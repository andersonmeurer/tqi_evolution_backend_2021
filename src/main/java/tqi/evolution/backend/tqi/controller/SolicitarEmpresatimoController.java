package tqi.evolution.backend.tqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tqi.evolution.backend.tqi.entity.SolicitacaoDeEmprestimo;
import tqi.evolution.backend.tqi.service.ClienteService;
import tqi.evolution.backend.tqi.service.EmprestimoService;
import tqi.evolution.backend.tqi.service.SolicitarEmpresatimoService;

@RestController
@RequestMapping("/solicitaremprestimo")
public class SolicitarEmpresatimoController {

	private SolicitarEmpresatimoService solicitarEmpresatimoService;

	@Autowired
	public SolicitarEmpresatimoController(ClienteService clienteService, EmprestimoService emprestimoService,
			SolicitarEmpresatimoService solicitarEmpresatimoService) {
		this.solicitarEmpresatimoService = solicitarEmpresatimoService;
	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody SolicitacaoDeEmprestimo solicitacaoDeEmprestimo) {
		return solicitarEmpresatimoService.insert(solicitacaoDeEmprestimo);
	}
}