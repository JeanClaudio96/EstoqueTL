package com.EstoqueTL.Controllers.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/minhasRequisicoes")
public class PendentesController {
	
	@GetMapping(path = "")
	public String PendentesGet() {
		return "root/minhasRequisicoesPage";
	}
}
