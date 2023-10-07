package com.EstoqueTL.Requisicao.Data.Models;

import java.util.ArrayList;
import java.util.Date;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REQUISICAO")
public class Requisicao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_requisicao", nullable = false)
	private TipoReq tipoReq;
	
	@Column(name = "requisitante", nullable = false)
	private String requisitante;
	
	@Column(name = "receptor", nullable = false)
	private String receptor;
	
	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name = "destino", nullable = false)
	private String destino;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "requisicao_id", nullable = false)
	@OrderBy("sigla")
	private List<Material> materiais = new ArrayList<>();
	
	@PrePersist
	protected void onCreate() {
		data = (Date) new Date();
	}
	
	public void addMateriais(Material material) {
		getMateriais().add(material);
	}
	
}
