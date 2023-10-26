package com.EstoqueTL.Services;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.DTO.MaterialDTO;
import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Mappers.EstoqueConverter;
import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final RequisicaoService requisicaoService;
    private final EstoqueConverter estoqueConverter;

    public EstoqueService(EstoqueRepository estoqueRepository, RequisicaoService requisicaoService, EstoqueConverter estoqueConverter) {
        this.estoqueRepository = estoqueRepository;
        this.requisicaoService = requisicaoService;
        this.estoqueConverter = estoqueConverter;
    }

    public EstoqueDTO findBySigla (String sigla) {
        Estoque estoque = estoqueRepository.findBySigla(sigla);
        EstoqueDTO estoqueDTO = estoqueConverter.convertEntityToDto(estoque);
        return estoqueDTO;
    }

    public void atualizarEstoque (RequisicaoDTO requisicaoDTO){
        int count = 0;
        int totalMateriais = requisicaoDTO.getMateriais().size();

        RequisicaoDTO requisicaoAtualizada = requisicaoService.findRequisicaoById(requisicaoDTO.getId());

        List<EstoqueDTO> materialListAtt = new ArrayList<>();

        for(MaterialDTO materialDTO : requisicaoDTO.getMateriais()){

            EstoqueDTO materialEmEstoque = findBySigla(materialDTO.getSigla());
            double quantidadeExistente = materialEmEstoque.getQuantidade();

            double quantidadeAtualizada = quantidadeExistente - materialDTO.getQuantidadeRequisitada();

            if(quantidadeAtualizada>=0){
                materialEmEstoque.setQuantidade(quantidadeAtualizada);
                materialListAtt.add(materialEmEstoque);
                count++;
            }
            else{
                System.out.println("Não existe uma quantidade suficiente do material ");
            }
        }

        System.out.println("Numero de materiais com quantidade ok:" + count);

        if(count == totalMateriais){
            for(EstoqueDTO material : materialListAtt){
                saveMaterial(material);
            }
            System.out.println("Mudando status para aceito");
            requisicaoAtualizada.setStatus(Status.ACEITO);
            requisicaoService.saveRequisicao(requisicaoAtualizada);
        }
        else {
            requisicaoAtualizada.setStatus(Status.RECUSADO);
            requisicaoService.saveRequisicao(requisicaoAtualizada);
        }
    }

    public void saveMaterial(EstoqueDTO estoqueDTO) {
        Estoque estoque = estoqueConverter.convertDtoToEntity(estoqueDTO);
        estoqueRepository.save(estoque);
    }
}