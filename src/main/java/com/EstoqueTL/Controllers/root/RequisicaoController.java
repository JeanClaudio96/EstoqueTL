package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.DTO.RequisicaoDTO;
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

@Controller
@RequestMapping(value="/")
public class RequisicaoController {

	private final RequisicaoRepository requisicaoRepository;
	private final RequisicaoService requisicaoService;

	RequisicaoController(RequisicaoRepository requisicaoRepository, RequisicaoService requisicaoService) {
        this.requisicaoRepository = requisicaoRepository;
		this.requisicaoService = requisicaoService;
    }

	@GetMapping
	public String RequisicaoGet(Model model) {
		
		Requisicao requisicao = new Requisicao();
		model.addAttribute("requisicao", requisicao);
		
		return "root/requisicaoPage";
	}
	
	@PostMapping
	public String RequisicaoPost(Model model, @Valid @ModelAttribute RequisicaoDTO requisicaoDTO, BindingResult bindingResult) {

		Requisicao requisicao = new Requisicao();

		if (bindingResult.hasErrors()) {	// FALTA IMPLEMENTAR PARA DADOS INVALIDOS, BUGADO
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("requisicao", requisicao);
			return "root/requisicaoPage";
			}

		requisicao = requisicaoService.convertDtoToEntity(requisicaoDTO);

		System.out.println(requisicao.getMateriais().toString() + "\n");
		System.out.println(requisicao + "\n");
		
		requisicaoRepository.save(requisicao);
		
		return "redirect:/pendentes";
	}
}
