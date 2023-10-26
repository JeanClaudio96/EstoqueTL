package com.EstoqueTL.Services;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Mappers.RequisicaoConverter;
import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequisicaoService {

    private final RequisicaoRepository requisicaoRepository;
    private final RequisicaoConverter requisicaoConverter;

    public RequisicaoService(RequisicaoRepository requisicaoRepository, RequisicaoConverter requisicaoConverter) {
        this.requisicaoRepository = requisicaoRepository;
        this.requisicaoConverter = requisicaoConverter;
    }

    public void saveRequisicao(RequisicaoDTO requisicaoDTO) {
        Requisicao requisicao = requisicaoConverter.convertDtoToEntity(requisicaoDTO);
        requisicaoRepository.save(requisicao);
    }

    public RequisicaoDTO findRequisicaoById(Long id) {
        Optional<Requisicao> optionalRequisicao = requisicaoRepository.findById(id);
        if (optionalRequisicao.isPresent()) {
            Requisicao requisicao = optionalRequisicao.get();
            RequisicaoDTO requisicaoDTO = requisicaoConverter.convertEntityToDto(requisicao);
            return requisicaoDTO;
        }
        else {
            RequisicaoDTO requisicaoDTO = null;
            return requisicaoDTO;
        }
    }

    public List<RequisicaoDTO> findAllRequisicoesByStatus (Status status) {
        List<RequisicaoDTO> requisicaoDTOList = new ArrayList<>();
        List<Requisicao> requisicaoList = requisicaoRepository.findAllByStatus(status);
        for(Requisicao requisicao : requisicaoList) {
            requisicaoDTOList.add(requisicaoConverter.convertEntityToDto(requisicao));
        }
        return requisicaoDTOList;
    }
}
