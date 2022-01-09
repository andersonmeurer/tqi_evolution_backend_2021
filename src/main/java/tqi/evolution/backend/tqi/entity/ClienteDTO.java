//package tqi.evolution.backend.tqi.entity;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.NotNull;
//
//import io.swagger.annotations.Api;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ClienteDTO {
//
//	private Long id;
//
//	@Column
//	@NotNull(message = "não deve ser vazio")
//	private String nome;
//
//	@Column
//	@NotNull
//	private String cpf;
//
//	@Column
//	@NotNull(message = "não deve ser vazio")
//	private String rg;
//
//	@Column
//	@NotNull(message = "não deve ser vazio")
//	private String endereco;
//
//	@Column
//	@NotNull(message = "deve ser um valor maior de 0.1")
//	@DecimalMin(value = "0.1", message = "deve ser um valor maior de 0.1")
//	private BigDecimal renda;
//
//	@Column
//	@NotNull(message = "não deve ser vazio")
//	private String email;
//
//	@Column
//	@NotNull(message = "não deve ser vazia")
//	private String senha;
//
////	public Cliente toObj() {
////		return new Cliente(0L, nome, cpf, rg, endereco, renda, email, senha);
////	}
//}