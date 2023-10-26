package com.EstoqueTL.Controllers.Admin;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Services.EstoqueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import com.EstoqueTL.Data.Models.Estoque;

@Controller
@RequestMapping(value="/admin")
public class AdicionarMateriaisController {
	
	final private EstoqueService estoqueService;
	final private EstoqueRepository estoqueRepository;

    AdicionarMateriaisController(EstoqueService estoqueService, EstoqueRepository estoqueRepository ) {
        this.estoqueService = estoqueService;
		this.estoqueRepository = estoqueRepository;
    }
	
	@GetMapping(value = "/adicionarMateriais")
	public String AdicionarMateriaisGet() {
		return "admin/adicionarMateriaisPage";
	}
	
	@PostMapping(value = "/adicionarMateriais")
	public String AdicionarMateriaisPost(Model model, @Valid EstoqueDTO estoqueDTO, BindingResult bindingResult) {
		estoqueService.saveMaterial(estoqueDTO);
		return "redirect:admin/adminPage";
	}
}