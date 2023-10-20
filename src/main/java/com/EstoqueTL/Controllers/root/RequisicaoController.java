package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Services.RequisicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/")
public class RequisicaoController {

	private final RequisicaoRepository requisicaoRepository;
	private final EstoqueRepository estoqueRepository;
	private final RequisicaoService requisicaoService;

	RequisicaoController(RequisicaoRepository requisicaoRepository, EstoqueRepository estoqueRepository, RequisicaoService requisicaoService) {
        this.requisicaoRepository = requisicaoRepository;
		this.estoqueRepository = estoqueRepository;
		this.requisicaoService = requisicaoService;
    }

	@GetMapping
	public ResponseEntity<List<Estoque>> RequisicaoGet(Model model) {

		List<Estoque> estoqueList = (List<Estoque>) estoqueRepository.findAll();
		return ResponseEntity.ok(estoqueList);
	}
	
	@PostMapping
	public ResponseEntity<?> RequisicaoPost(Model model, RequisicaoDTO requisicaoDTO, BindingResult bindingResult) {

		Requisicao requisicao = new Requisicao();

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body("Erro ao enviar o formulario");
			}

		requisicao = requisicaoService.convertDtoToEntity(requisicaoDTO);
		requisicaoRepository.save(requisicao);
		
		return ResponseEntity.ok("Requisicao enviada com sucesso");
	}
}
