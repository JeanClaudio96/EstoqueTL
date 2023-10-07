package com.EstoqueTL.Requisicao.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/pendentes")
public class PendentesController {
	
	@GetMapping
	public String PendentesGet() {
		return "requisicao/pendentes";
	}
}
