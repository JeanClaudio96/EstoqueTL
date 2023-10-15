package com.EstoqueTL.Controllers.root;

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

	final RequisicaoRepository requisicaoRepository;

    RequisicaoController(RequisicaoRepository requisicaoRepository) {
        this.requisicaoRepository = requisicaoRepository;
    }

	@GetMapping
	public String RequisicaoGet(Model model) {
		
		Requisicao requisicao = new Requisicao();
		model.addAttribute("requisicao", requisicao);
		
		return "root/requisicaoPage";
	}
	
	@PostMapping
	public String RequisicaoPost(Model model, @Valid @ModelAttribute Requisicao requisicao, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {	// FALTA IMPLEMENTAR PARA DADOS INVALIDOS, BUGADO
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "root/requisicaoPage";
			}

		System.out.println(requisicao.getMateriais().toString() + "\n");
		System.out.println(requisicao + "\n");
		
		requisicaoRepository.save(requisicao);
		
		return "redirect:/pendentes";
	}
}
