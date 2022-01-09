package tqi.evolution.backend.tqi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoDeEmprestimo {

	private static DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// se existir parcelas. eh poque esta aprovado
	private transient boolean isAprovado;

	protected Long idCliente;

	protected Double valorTotal;

	@DecimalMin(value = "1", message = "O número de parcelas deve ser maior que 1.")
	@DecimalMax(value = "60", message = "O número de parcelas deve ser no máximo 60.")
	// máximo 60
	protected int numeroPacelas;

	@NotNull(message = "Data da primeira parcela deve ser uma data no formato dd/MM/yyyy")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Data da primeira parcela deve ser uma data no formato dd/MM/yyyy")
	// máximo 3 meses após o dia atual
	protected String dataPrimeiraParcela;

	@Override
	public String toString() {
		return "SolicitacaoDeEmprestimo [idCliente=" + idCliente + ", valorTotal=" + valorTotal + ", numeroPacelas="
				+ numeroPacelas + ", dataPrimeiraParcela=" + dataPrimeiraParcela + "]";
	}
}