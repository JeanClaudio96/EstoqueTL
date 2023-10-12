package com.EstoqueTL.Admin.Data.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ESTOQUE")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @NotNull
    @Column(name = "sigla")
    private String sigla;

    @NotBlank
    @NotNull
    @Column(name = "tipo")
    private String tipo;

    @NotBlank
    @NotNull
    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
    
    @NotBlank
    @NotNull
    @Column(name = "unidade_de_medida")
    private String unidadeDeMedida;

    @NotBlank
    @NotNull
    @Column(name = "quantidade")
    private Double quantidade;

    @NotBlank
    @NotNull
    @Column(name = "adicionado_por")
    private String adicionadoPor;

    @NotBlank
    @NotNull
    @Column(name = "atualizado_por")
    private String atualizadoPor;

    @NotBlank
    @NotNull
    @Column(name = "adicionado_em", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date adicionadoEm;

    @NotBlank
    @NotNull
    @Column(name = "atualizado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizadoEm;
    
    @Column(name="ativo", columnDefinition = "DEFAULT true")
    private Boolean ativo;

    @PrePersist
	protected void onCreate() {
		adicionadoEm = (Date) new Date();
	}
}
