package com.EstoqueTL.Data.Mappers;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.Models.Estoque;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConverter {

    public Estoque convertDtoToEntity(EstoqueDTO estoqueDTO) {
        if(estoqueDTO == null) return null;

        Estoque estoque = new Estoque();
        estoque.setId(estoqueDTO.getId());
        estoque.setSigla(estoqueDTO.getSigla());
        estoque.setTipoMaterial(estoqueDTO.getTipoMaterial());
        estoque.setNome(estoqueDTO.getNome());
        estoque.setDescricao(estoqueDTO.getDescricao());
        estoque.setUnidadeDeMedida(estoqueDTO.getUnidadeDeMedida());
        estoque.setQuantidade(estoqueDTO.getQuantidade());
        estoque.setAdicionadoPor(estoqueDTO.getAdicionadoPor());
        estoque.setAtualizadoPor(estoqueDTO.getAtualizadoPor());
        estoque.setAtivo(estoqueDTO.getAtivo());

        return estoque;
    }

    public EstoqueDTO convertEntityToDto(Estoque estoque) {
        if (estoque == null) return null;

        EstoqueDTO estoqueDTO = new EstoqueDTO();
        estoqueDTO.setId(estoque.getId());
        estoqueDTO.setSigla(estoque.getSigla());
        estoqueDTO.setTipoMaterial(estoque.getTipoMaterial());
        estoqueDTO.setNome(estoque.getNome());
        estoqueDTO.setDescricao(estoque.getDescricao());
        estoqueDTO.setUnidadeDeMedida(estoque.getUnidadeDeMedida());
        estoqueDTO.setQuantidade(estoque.getQuantidade());
        estoqueDTO.setAdicionadoPor(estoque.getAdicionadoPor());
        estoqueDTO.setAtualizadoPor(estoque.getAtualizadoPor());
        estoqueDTO.setAtivo(estoque.getAtivo());

        return estoqueDTO;
    }

}
