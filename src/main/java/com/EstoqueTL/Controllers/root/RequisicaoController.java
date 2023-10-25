package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Services.RequisicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/")
public class RequisicaoController {

	private final RequisicaoService requisicaoService;

	RequisicaoController(RequisicaoService requisicaoService) {
		this.requisicaoService = requisicaoService;
	}

	@PostMapping
	public ResponseEntity<?> RequisicaoPost(@RequestBody RequisicaoDTO requisicaoDTO, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body("Erro ao enviar o formulario");
		}

		requisicaoService.saveRequisicao(requisicaoDTO);

		return ResponseEntity.ok("Requisicao enviada com sucesso");
	}
}
