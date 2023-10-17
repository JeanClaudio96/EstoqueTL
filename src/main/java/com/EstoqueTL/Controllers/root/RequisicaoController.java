package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Services.RequisicaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EstoqueTL.Data.Models.Requisicao;
import com.EstoqueTL.Data.Repositorys.RequisicaoRepository;

import jakarta.validation.Valid;

import java.util.List;

@Controller
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
	public String RequisicaoGet(Model model) {

		List<Estoque> estoqueList = (List<Estoque>) estoqueRepository.findAll();
		model.addAttribute("estoqueList", estoqueList);
		
		return "root/requisicaoPage";
	}
	
	@PostMapping
	public String RequisicaoPost(Model model, @Valid @ModelAttribute RequisicaoDTO requisicaoDTO, BindingResult bindingResult) {

		Requisicao requisicao = new Requisicao();

		if (bindingResult.hasErrors()) {
			return "root/requisicaoPage";
			}

		requisicao = requisicaoService.convertDtoToEntity(requisicaoDTO);
		
		requisicaoRepository.save(requisicao);
		
		return "redirect:/minhasRequisicoes";
	}
}
