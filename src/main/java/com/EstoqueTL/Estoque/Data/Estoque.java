package com.EstoqueTL.Estoque.Data;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ESTOQUE")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "sigla", nullable = false)
    private String sigla;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;
    
    @Column(name = "unidade_de_medida", nullable = false)
    private String unidadeDeMedida;

    @Column(name = "quantidade", nullable = false)
    private Double quantidade;

    @Column(name = "adicionado_por", nullable = false)
    private String adicionadoPor;

    @Column(name = "atualizado_por", nullable = false)
    private String atualizadoPor;

    @Column(name = "adicionado_em", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date adicionadoEm;

    @Column(name = "atualizado_em", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizadoEm;

}
