package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(path = "/minhasRequisicoes")
public class MinhasRequisicoesController {

	private final RequisicaoRepository requisicaoRepository;

	public MinhasRequisicoesController(RequisicaoRepository requisicaoRepository) {
		this.requisicaoRepository = requisicaoRepository;
	}

	@GetMapping(path = "")
	public ResponseEntity<List<Requisicao>> PendentesGet() {
		List<Requisicao> requisicaoList = (List<Requisicao>) requisicaoRepository.findAll();
		return ResponseEntity.ok(requisicaoList);
	}


}
