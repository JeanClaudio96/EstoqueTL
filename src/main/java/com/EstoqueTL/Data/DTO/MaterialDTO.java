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

    private Long id;

    @NotBlank
    @NotNull(message = "A sigla do material nao pode ser nula")
    private String sigla;

    @NotNull(message = "O tipo do material nao pode ser nula")
    private TipoMaterial tipoMaterial;

    @NotBlank
    @NotNull(message = "O nome do material nao pode ser nula")
    private String nome;

    private String descricao;

    @NotNull(message = "A unidade de medida do material nao pode ser nula")
    private UnidadeDeMedida unidadeDeMedida;

    private Double quantidadeRequisitada;

    private Boolean devolucao;

    private Double quantidadeDevolvida;
}
