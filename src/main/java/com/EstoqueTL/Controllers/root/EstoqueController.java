package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/estoque")
public class EstoqueController {

	private final EstoqueRepository estoqueRepository;

	public EstoqueController(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	@GetMapping(path = "")
	public String estoqueGet(Model model) {
		model.addAttribute("estoqueList", estoqueRepository.findAll());
		return "root/estoquePage";
	}
}
