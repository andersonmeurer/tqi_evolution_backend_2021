package tqi.evolution.backend.tqi.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tqi.evolution.backend.tqi.entity.Cliente;
import tqi.evolution.backend.tqi.entity.Emprestimo;
import tqi.evolution.backend.tqi.entity.Parcela;
import tqi.evolution.backend.tqi.entity.SolicitacaoDeEmprestimo;

@Service
public class SolicitarEmpresatimoService {

	private static DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private EmprestimoService emprestimoService;
	private ClienteService clienteService;

	@Autowired
	public SolicitarEmpresatimoService(ClienteService clienteService, EmprestimoService emprestimoService) {
		this.clienteService = clienteService;
		this.emprestimoService = emprestimoService;
	}

	public ResponseEntity<String> insert(SolicitacaoDeEmprestimo solicitacaoDeEmprestimo) {
		System.out.println(solicitacaoDeEmprestimo);
		LocalDate dataPrimeiraParcela = LocalDate.parse(solicitacaoDeEmprestimo.getDataPrimeiraParcela(), ofPattern);
		System.out.println("\n\n");
		if (!dataPrimeiraParcela.isAfter(LocalDate.now())) {
			return ResponseEntity.badRequest().body("A data da primeira parcela informada '"
					+ solicitacaoDeEmprestimo.getDataPrimeiraParcela() + "' deve ser superior a data atual!");
		}
		if (!dataPrimeiraParcela.isBefore(LocalDate.now().plusMonths(3))) {
			return ResponseEntity.badRequest().body("A data da primeira parcela informada '"
					+ solicitacaoDeEmprestimo.getDataPrimeiraParcela() + "' deve inferior que 3 meses da data atual!");
		}
		if (solicitacaoDeEmprestimo.getNumeroPacelas() <= 0) {
			return ResponseEntity.badRequest().body("A quantidade de parcelas deve ser entre 1 e 60!");
		}
		if (solicitacaoDeEmprestimo.getNumeroPacelas() > 60) {
			return ResponseEntity.badRequest().body("A quantidade de parcelas deve ser entre 1 e 60!");
		}

		Emprestimo emprestimo = new Emprestimo();
//		emprestimo.setValorTotal(solicitacaoDeEmprestimo.getValorTotal());
		Optional<Cliente> cli = clienteService.getById(solicitacaoDeEmprestimo.getIdCliente());
		if (!cli.isPresent()) {
			return ResponseEntity.badRequest()
					.body("Cliente com id=" + solicitacaoDeEmprestimo.getIdCliente() + " não encontrado!");
		}
		emprestimo.setCliente(cli.get());

		Double soma = new Double(0);
		Double v = solicitacaoDeEmprestimo.getValorTotal() / solicitacaoDeEmprestimo.getNumeroPacelas();
		for (int index = 0; index < solicitacaoDeEmprestimo.getNumeroPacelas(); index++) {
			soma += v;
			Parcela parcela = new Parcela();
			parcela.setValor(v);
			parcela.setData(dataPrimeiraParcela.plusMonths(index));
			emprestimo.getParcelas().add(parcela);
		}

		if (soma > solicitacaoDeEmprestimo.getValorTotal()) {
			return ResponseEntity.badRequest()
					.body(soma + " <> " + solicitacaoDeEmprestimo.getValorTotal() + " Rever valores");
		}
		if (soma < solicitacaoDeEmprestimo.getValorTotal()) {
			return ResponseEntity.badRequest()
					.body(soma + " <> " + solicitacaoDeEmprestimo.getValorTotal() + " Rever valores");
		}
		Optional<Emprestimo> newE = emprestimoService.insert(emprestimo);
		return ResponseEntity.ok().body(newE.get().toString());
	}
}