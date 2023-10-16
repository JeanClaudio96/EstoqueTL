package com.EstoqueTL.Services;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.Models.Estoque;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    public Estoque convertDtoToEntity(EstoqueDTO estoqueDTO) {
        Estoque estoque = new Estoque();
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
}