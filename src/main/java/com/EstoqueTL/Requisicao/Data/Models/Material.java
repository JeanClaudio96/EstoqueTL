package com.EstoqueTL.Requisicao.Data.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MATERIAL")
public class Material {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "A sigla nao pode ser nula")
	@Column(name = "sigla", length = 10)
    private String sigla;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoMaterial tipo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "und_medida", nullable = false)
    private UnidadeDeMedida unidadeDeMedida;
    
    @Column(name = "qtd_requisitada", nullable = false)
	private double quantidadeRequisitada;
    
    @Column(name = "devolucao", columnDefinition = "BOOLEAN DEFAULT false NOT NULL")
    private Boolean devolucao;
    
    @Column(name = "qtd_devolvida", nullable = false)
	private double quantidadeDevolvida;
}
