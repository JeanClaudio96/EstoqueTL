package com.EstoqueTL.Controllers.Admin;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Services.EstoqueService;
import org.springframework.http.ResponseEntity;
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

    AdicionarMateriaisController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }
	
	@PostMapping(value = "/adicionarMaterial")
	public ResponseEntity<String> AdicionarMateriaisPost(@Valid EstoqueDTO estoqueDTO) {
		estoqueService.saveMaterial(estoqueDTO);
		return ResponseEntity.ok().build();
	}
}