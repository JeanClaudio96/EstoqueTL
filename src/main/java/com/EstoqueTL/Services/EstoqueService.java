package com.EstoqueTL.Services;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.DTO.MaterialDTO;
import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final RequisicaoRepository requisicaoRepository;

    public EstoqueService(EstoqueRepository estoqueRepository, RequisicaoRepository requisicaoRepository) {
        this.estoqueRepository = estoqueRepository;
        this.requisicaoRepository = requisicaoRepository;
    }

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

    public void atualizarEstoque (RequisicaoDTO requisicaoDTO){
        int count = 0;

        Optional<Requisicao> optionalRequisicao = requisicaoRepository.findById(requisicaoDTO.getId());
        if (optionalRequisicao.isPresent()){
            Requisicao requisicao = optionalRequisicao.get();

            List<Estoque> materialListAtt = new ArrayList<>();

            for(MaterialDTO materialDTO : requisicaoDTO.getMateriais()){
                String siglaMaterial = materialDTO.getSigla();
                Double quantidadeRequisitada = materialDTO.getQuantidadeRequisitada();
                Estoque materialEmEstoque = estoqueRepository.findBySigla(siglaMaterial);
                Double quantidadeExistente = materialEmEstoque.getQuantidade();

                Double quantidadeAtualizada = quantidadeExistente-quantidadeRequisitada;

                if(quantidadeAtualizada>0){
                    materialEmEstoque.setQuantidade(quantidadeAtualizada);
                    materialListAtt.add(materialEmEstoque);
                    count++;
                }
                else{
                    System.out.println("Não existe uma quantidade suficiente do material ");
                }
            }

            System.out.println("Numero de materiais com quantidade ok:" + count);

            if(count == requisicaoDTO.getMateriais().size()){
                for(Estoque material : materialListAtt){
                    estoqueRepository.save(material);
                }
                requisicao.setStatus(Status.ACEITO);
            }
            else {
                requisicao.setStatus(Status.RECUSADO);
            }
        }
    }
}