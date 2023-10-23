package com.EstoqueTL.Controllers.Estoquista;

import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/estoquista/requisicoesPendentes")
public class RequisicoesPendentesController {

    private final RequisicaoRepository requisicaoRepository;

    public RequisicoesPendentesController(RequisicaoRepository requisicaoRepository) {
        this.requisicaoRepository = requisicaoRepository;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Requisicao>> RequisicoesPendentesGet(){
        List<Requisicao> requisicaoList = (List<Requisicao>) requisicaoRepository.findAllByStatus(Status.PENDENTE);
        return ResponseEntity.ok(requisicaoList);
    }
}
