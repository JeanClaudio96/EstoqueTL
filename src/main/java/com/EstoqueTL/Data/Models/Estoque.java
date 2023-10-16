package com.EstoqueTL.Data.Models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipoMaterial;

    @NotBlank
    @NotNull
    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;
    
    @NotBlank
    @NotNull
    @Column(name = "unidade_de_medida")
    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidadeDeMedida;

    @NotBlank
    @NotNull
    @Column(name = "quantidade")
    private Double quantidade;

    @NotBlank
    @NotNull
    @Column(name = "adicionado_por")
    private String adicionadoPor;

    @Column(name = "atualizado_por", columnDefinition = "VARCHAR(255) DEFAULT 'Null'")
    private String atualizadoPor;

    @CreationTimestamp
    @Column(name = "adicionado_em")
    private LocalDateTime adicionadoEm;

    @Column(name = "atualizado_em")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizadoEm;
    
    @Column(name="ativo")
    private Boolean ativo = true;

}
