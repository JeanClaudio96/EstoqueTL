package com.EstoqueTL.Data.DTO;

import com.EstoqueTL.Data.Models.TipoMaterial;
import com.EstoqueTL.Data.Models.UnidadeDeMedida;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {

    private Long id;

    @NotBlank
    @NotNull
    private String sigla;

    @NotNull
    private TipoMaterial tipoMaterial;

    @NotBlank
    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private UnidadeDeMedida unidadeDeMedida;

    @NotNull
    private Double quantidade;

    @NotBlank
    @NotNull
    private String adicionadoPor;

    private String atualizadoPor;

    private LocalDateTime adicionadoEm;

    private Date atualizadoEm;

    private Boolean ativo = true;
}
