package com.EstoqueTL.Requisicao.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EstoqueTL.Requisicao.Data.Models.Requisicao;
import com.EstoqueTL.Requisicao.Data.Models.Status;
import com.EstoqueTL.Requisicao.Data.Repositorys.RequisicaoRepository;

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
		
		return "requisicao/requisicaoPage";
	}
	
	@PostMapping
	public String RequisicaoPost(Model model, @Valid @ModelAttribute Requisicao requisicao, BindingResult bindingResult) {
		
		System.out.println(requisicao.getMateriais().toString() + "\n");
		System.out.println(requisicao + "\n");
		
		if (bindingResult.hasErrors()) {	// FALTA IMPLEMENTAR PARA DADOS INVALIDOS, BUGADO
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "requisicao/requisicaoPage";
			}
		
		requisicao.setStatus(Status.PENDENTE);
		
		requisicao.setRequisitante("Eu mesmo"); // FALTA IMPLEMENTAR PARA RECEBER O NOME DO USUARIO
		
		requisicaoRepository.save(requisicao);
		
		return "redirect:/pendentesPage";
	}
}
