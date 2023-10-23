package com.EstoqueTL.Data.Repositorys;

import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Models.Status;
import org.springframework.data.repository.CrudRepository;

import com.EstoqueTL.Data.Models.Requisicao;

import java.util.List;

public interface RequisicaoRepository extends CrudRepository<Requisicao, Long>{
    List<Requisicao> findAllByStatus(Status status);

}
