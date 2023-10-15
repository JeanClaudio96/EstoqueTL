package com.EstoqueTL.Data.DTO;

import com.EstoqueTL.Data.Models.Material;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Models.TipoReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoDTO {

    private TipoReq tipoRequisicao;

    private String requisitante;

    private String receptor;

    private LocalDateTime data;

    private String destino;

    private Status status;

    private List<MaterialDTO> materiais;

}
