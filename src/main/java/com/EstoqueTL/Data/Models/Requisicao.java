package com.EstoqueTL.Data.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REQUISICAO")
public class Requisicao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull(message = "Tipo de requisicao nao pode ser nulo")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_requisicao")
	private TipoReq tipoRequisicao;

	@NotBlank
	@NotNull(message = "Requisitante nao pode ser nulo")
	@Column(name = "requisitante")
	private String requisitante;

	@NotBlank
	@NotNull(message = "Receptor nao pode ser nulo")
	@Column(name = "receptor")
	private String receptor;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime data;

	@NotBlank
	@NotNull(message = "Destino nao pode ser nulo")
	@Column(name = "destino")
	private String destino;

	@NotNull(message = "Status nao pode ser nulo")
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "requisicao_id")
	@OrderBy("sigla")
	private List<Material> materiais = new ArrayList<>();
}
