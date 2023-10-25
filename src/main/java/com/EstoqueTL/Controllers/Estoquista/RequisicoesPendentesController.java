package com.EstoqueTL.Controllers.Estoquista;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;
import com.EstoqueTL.Services.EstoqueService;
import com.EstoqueTL.Services.RequisicaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/estoquista/requisicoesPendentes")
public class RequisicoesPendentesController {

    private final RequisicaoService requisicaoService;
    private final EstoqueService estoqueService;

    public RequisicoesPendentesController(RequisicaoService requisicaoService, EstoqueService estoqueService) {
        this.requisicaoService = requisicaoService;
        this.estoqueService = estoqueService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Requisicao>> RequisicoesPendentesGet(){
        List<Requisicao> requisicaoList = requisicaoService.findAllRequisicoesByStatus(Status.PENDENTE);
        return ResponseEntity.ok(requisicaoList);
    }

    @GetMapping(path = "/requisicao/{id}")
    public ResponseEntity<?> RequisicaoGet(@PathVariable Long id){

        Requisicao requisicao = requisicaoService.findRequisicaoById(id);

        if(requisicao != null) {
            return ResponseEntity.ok(requisicao);
        }
        else
            return ResponseEntity.badRequest().body("Requisicao inexistente");
    }

    @PutMapping(path = "/requisicao/{id}")
    public ResponseEntity<?> RequisicoesPendentesHandlePost(@RequestBody RequisicaoDTO requisicaoDTO){
        estoqueService.atualizarEstoque(requisicaoDTO);
        return ResponseEntity.ok().body("Requisicao foi tratada com sucesso!");
    }
}