package com.EstoqueTL.Controllers.Admin;

import com.EstoqueTL.Data.DTO.EstoqueDTO;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import com.EstoqueTL.Services.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import com.EstoqueTL.Data.Models.Estoque;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/admin")
public class AdicionarMateriaisController {
	
	final private EstoqueService estoqueService;

    AdicionarMateriaisController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }
	
	@PostMapping(path = "/adicionarMaterial")
	public ResponseEntity<?> AdicionarMateriaisPost(@Valid @RequestBody EstoqueDTO estoqueDTO) {
		estoqueService.saveMaterial(estoqueDTO);
		return ResponseEntity.ok("Material adicionado ao banco de dados com sucesso!");
	}
}