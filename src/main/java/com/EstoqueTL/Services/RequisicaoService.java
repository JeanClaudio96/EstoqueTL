package com.EstoqueTL.Services;

import com.EstoqueTL.Data.DTO.MaterialDTO;
import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Material;
import com.EstoqueTL.Data.Models.Requisicao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequisicaoService {

    public Requisicao convertDtoToEntity(RequisicaoDTO requisicaoDTO) {
        Requisicao requisicao = new Requisicao();
        requisicao.setTipoRequisicao(requisicaoDTO.getTipoRequisicao());
        requisicao.setRequisitante(requisicaoDTO.getRequisitante());
        requisicao.setReceptor(requisicaoDTO.getReceptor());
        requisicao.setDestino(requisicaoDTO.getDestino());
        requisicao.setStatus(requisicaoDTO.getStatus());
        requisicao.setData(LocalDateTime.now()); // ou obtenha a data de outra fonte, se necessário

        // Converte os materiais do DTO para a lista de materiais da Requisicao
        List<Material> materiais = requisicaoDTO.getMateriais().stream()
                .map(this::convertMaterialDtoToEntity)
                .collect(Collectors.toList());

        requisicao.setMateriais(materiais); // Adiciona a lista de materiais à requisicao

        return requisicao;
    }

    private Material convertMaterialDtoToEntity(MaterialDTO materialDTO) {
        Material material = new Material();
        material.setSigla(materialDTO.getSigla());
        material.setTipoMaterial(materialDTO.getTipoMaterial());
        material.setNome(materialDTO.getNome());
        material.setDescricao(materialDTO.getDescricao());
        material.setUnidadeDeMedida(materialDTO.getUnidadeDeMedida());
        material.setQuantidadeRequisitada(materialDTO.getQuantidadeRequisitada());
        material.setDevolucao(materialDTO.getDevolucao());
        material.setQuantidadeDevolvida(materialDTO.getQuantidadeDevolvida());
        return material;
    }
}
