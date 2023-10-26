package com.EstoqueTL.Data.DTO;

import com.EstoqueTL.Data.Models.Material;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Models.TipoReq;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoDTO {

    private Long id;

    @NotNull(message = "Tipo de requisicao nao pode ser nulo")
    private TipoReq tipoRequisicao;

    @NotBlank
    @NotNull(message = "Requisitante nao pode ser nulo")
    private String requisitante;

    @NotBlank
    @NotNull(message = "Receptor nao pode ser nulo")
    private String receptor;

    private LocalDateTime data;

    @NotBlank
    @NotNull(message = "Destino nao pode ser nulo")
    private String destino;

    @NotNull(message = "Status nao pode ser nulo")
    private Status status;

    private List<MaterialDTO> materiais;

}
