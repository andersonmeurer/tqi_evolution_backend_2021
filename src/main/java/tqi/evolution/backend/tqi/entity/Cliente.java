package tqi.evolution.backend.tqi.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Size(min = 3, message = "Nome deve ter no minimo 3 caracteres")
	@NotNull(message = "Nome não deve ser vazio")
	private String nome;

	@Column
	@NotNull(message = "CPF não deve ser vazio")
	private String cpf;

	@Column
	@NotNull(message = "RG não deve ser vazio")
	private String rg;

	@Column
	@NotBlank
	@Size(min = 3, message = "Endereço deve ter no minimo 3 caracteres")
	@NotNull(message = "Endereço não deve ser vazio")
	private String endereco;

	@Column
	@NotNull(message = "Renda deve ser um valor maior de 0.1")
	@DecimalMin(value = "0.1", message = "Renda deve ser um valor maior de 0.1")
	private BigDecimal renda;

	@Column
	@Size(min = 3, message = "Email deve ser um email válido")
	@NotNull(message = "não deve ser vazio")
	private String email;

	@Column
	@NotNull(message = "não deve ser vazia")
	private String senha;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Emprestimo> emprestimo;

}