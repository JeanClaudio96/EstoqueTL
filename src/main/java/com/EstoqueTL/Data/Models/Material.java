package com.EstoqueTL.Data.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	
	@NotNull(message = "A sigla do material nao pode ser nula")
	@Size(min = 0)
	@Column(name = "sigla")
    private String sigla;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo do material nao pode ser nula")
    @Column(name = "tipo_Material")
    private TipoMaterial tipoMaterial;

    @NotNull(message = "O nome do material nao pode ser nula")
    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;
    
    @NotNull(message = "A unidade de medida do material nao pode ser nula")
    @Enumerated(EnumType.STRING)
    @Column(name = "und_medida")
    private UnidadeDeMedida unidadeDeMedida;
    
    @Column(name = "qtd_requisitada")
	private Double quantidadeRequisitada;

    @Column(name = "devolucao")
    private Boolean devolucao = false;
    
    @Column(name = "qtd_devolvida")
	private Double quantidadeDevolvida = (double) 0;
}
