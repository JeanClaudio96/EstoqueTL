package com.EstoqueTL.Data.Mappers;

import com.EstoqueTL.Data.DTO.MaterialDTO;
import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Material;
import com.EstoqueTL.Data.Models.Requisicao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequisicaoConverter {

    public Requisicao convertDtoToEntity(RequisicaoDTO requisicaoDTO) {
        if (requisicaoDTO == null) return null;
        Requisicao requisicao = new Requisicao();
        requisicao.setId(requisicaoDTO.getId());
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

    public RequisicaoDTO convertEntityToDto(Requisicao requisicao) {
        if (requisicao == null) return null;
        RequisicaoDTO requisicaoDTO = new RequisicaoDTO();
        requisicaoDTO.setId(requisicao.getId());
        requisicaoDTO.setTipoRequisicao(requisicao.getTipoRequisicao());
        requisicaoDTO.setRequisitante(requisicao.getRequisitante());
        requisicaoDTO.setReceptor(requisicao.getReceptor());
        requisicaoDTO.setDestino(requisicao.getDestino());
        requisicaoDTO.setStatus(requisicao.getStatus());

        // Converte a lista de materiais da Requisicao para a lista de materiais do DTO
        List<MaterialDTO> materiaisDTO = requisicao.getMateriais().stream()
                .map(this::convertMaterialEntityToDto)
                .collect(Collectors.toList());

        requisicaoDTO.setMateriais(materiaisDTO); // Adiciona a lista de materiais ao DTO

        return requisicaoDTO;
    }

    private MaterialDTO convertMaterialEntityToDto(Material material) {
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setId(material.getId());
        materialDTO.setSigla(material.getSigla());
        materialDTO.setTipoMaterial(material.getTipoMaterial());
        materialDTO.setNome(material.getNome());
        materialDTO.setDescricao(material.getDescricao());
        materialDTO.setUnidadeDeMedida(material.getUnidadeDeMedida());
        materialDTO.setQuantidadeRequisitada(material.getQuantidadeRequisitada());
        materialDTO.setDevolucao(material.getDevolucao());
        materialDTO.setQuantidadeDevolvida(material.getQuantidadeDevolvida());
        return materialDTO;
    }

}
