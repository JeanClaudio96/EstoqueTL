package com.EstoqueTL.Data.DTO;

import com.EstoqueTL.Data.Models.TipoMaterial;
import com.EstoqueTL.Data.Models.UnidadeDeMedida;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private String sigla;

    private TipoMaterial tipoMaterial;

    private String nome;

    private String descricao;

    private UnidadeDeMedida unidadeDeMedida;

    private Double quantidadeRequisitada;

    private Boolean devolucao;

    private Double quantidadeDevolvida;
}
