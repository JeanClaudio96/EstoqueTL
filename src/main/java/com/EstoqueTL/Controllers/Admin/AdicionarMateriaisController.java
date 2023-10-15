package com.EstoqueTL.Controllers.Admin;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Repositorys.AdicionarMateriaisRepository;

@Controller
@RequestMapping(value="/admin")
public class AdicionarMateriaisController {
	
	final private AdicionarMateriaisRepository adicionarMaterialRepository;

    AdicionarMateriaisController(AdicionarMateriaisRepository adicionarMaterialRepository) {
        this.adicionarMaterialRepository = adicionarMaterialRepository;
    }
	
	@GetMapping(value = "/adicionarMateriais")
	public String AdicionarMateriaisGet(Model model) {
		model.getAttribute(null);
		return "admin/adicionarMateriaisPage";
	}
	
	@PostMapping(value = "/adicionarMateriais")
	public String AdicionarMateriaisPost(Model model, @Valid Estoque estoque, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {	// FALTA IMPLEMENTAR PARA DADOS INVALIDOS, BUGADO
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/adicionarMateriaisPage";
			}
		
		estoque.setAtualizadoEm((Date) new Date());
		estoque.setAdicionadoPor("ADMIN");
		estoque.setAtualizadoPor("ADMIN");
		
		System.out.println(estoque);
		
		adicionarMaterialRepository.save(estoque);
		
		return "redirect:admin/adminPage";
	}
}