package com.EstoqueTL.Estoque.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/estoque")
public class EstoqueController {

	@GetMapping
	public String estoqueGet() {
		return "estoque/estoquePage";
	}
}
