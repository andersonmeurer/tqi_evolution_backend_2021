package tqi.evolution.backend.tqi.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.yaml.snakeyaml.constructor.SafeConstructor.ConstructYamlBinary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity(name = "emprestimo")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	protected Cliente cliente;

//	@Column
//	@NotNull(message = "Valor deve ser um valor maior de 0.1")
//	@DecimalMin(value = "0.1", message = "deve ser um valor maior de 0.1")
//	protected Double valorTotal;

	// maximo 60
	// primeira parcela maximo 3 meses apos o dia atual.
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	protected List<Parcela> parcelas;

	public Emprestimo() {
		parcelas = new ArrayList<>();
	}
}