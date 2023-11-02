package com.EstoqueTL.Data.Repositorys;

import com.EstoqueTL.Data.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import com.EstoqueTL.Data.Models.Requisicao;

import java.util.List;

public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {
    List<Requisicao> findAllByStatus(Status status);
}
