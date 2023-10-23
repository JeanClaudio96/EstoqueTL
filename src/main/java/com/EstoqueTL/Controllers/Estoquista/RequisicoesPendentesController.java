package com.EstoqueTL.Controllers.Estoquista;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Models.Status;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;
import com.EstoqueTL.Services.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/estoquista/requisicoesPendentes")
public class RequisicoesPendentesController {

    private final RequisicaoRepository requisicaoRepository;
    private final EstoqueService estoqueService;

    public RequisicoesPendentesController(RequisicaoRepository requisicaoRepository, EstoqueService estoqueService) {
        this.requisicaoRepository = requisicaoRepository;
        this.estoqueService = estoqueService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Requisicao>> RequisicoesPendentesGet(){
        List<Requisicao> requisicaoList = (List<Requisicao>) requisicaoRepository.findAllByStatus(Status.PENDENTE);
        return ResponseEntity.ok(requisicaoList);
    }

    @GetMapping(path = "/requisicao")
    public ResponseEntity<?> RequisicaoGet(@RequestParam Long id){
        Optional<Requisicao> requisicaoOptional = requisicaoRepository.findById(id);
        if(requisicaoOptional.isPresent()){
            Requisicao requisicao = requisicaoOptional.get();
            return ResponseEntity.ok(requisicao);
        }
        else
            return ResponseEntity.badRequest().body("Requisicao inexistente");

    }

    @PostMapping(path = "/")
    public ResponseEntity<?> RequisicoesPendentesHandlePost(@RequestBody RequisicaoDTO requisicaoDTO){
        estoqueService.atualizarEstoque(requisicaoDTO);
        return ResponseEntity.ok().body("Requisicao foi tratada com sucesso!");
    }
}
