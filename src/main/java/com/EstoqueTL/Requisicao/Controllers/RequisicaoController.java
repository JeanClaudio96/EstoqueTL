package com.EstoqueTL.Requisicao.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EstoqueTL.Requisicao.Data.Models.Material;
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
		
		List<Material> materiais = new ArrayList<>();
		
		Requisicao requisicao = new Requisicao();
		
		model.addAttribute("material", materiais);
		model.addAttribute("requisicao", requisicao);
		
		return "requisicao/requisicao";
	}
	
	@PostMapping
	public String RequisicaoPost(@Valid List<Material> material, @Valid Requisicao requisicao, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {	// FALTA IMPLEMENTAR PARA DADOS INVALIDOS, BUGADO
			//StringBuilder errors = new StringBuilder();
            //bindingResult.getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append("\n"));
            
			return "requisicao/requisicao";
			}

		for(Material item : material) {requisicao.addMateriais(item);}
		
		requisicao.setStatus(Status.PENDENTE);
		
		requisicao.setRequisitante("Eu mesmo"); // FALTA IMPLEMENTAR PARA RECEBER O NOME DO USUARIO
		
		requisicaoRepository.save(requisicao);
		
		return "redirect:/pendentes";
	}
}
