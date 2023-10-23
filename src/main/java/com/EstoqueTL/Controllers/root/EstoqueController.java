package com.EstoqueTL.Controllers.root;

import com.EstoqueTL.Data.Models.Estoque;
import com.EstoqueTL.Data.Repositorys.EstoqueRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/estoque")
public class EstoqueController {

	private final EstoqueRepository estoqueRepository;

	public EstoqueController(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	@GetMapping(path = "")
	public ResponseEntity<List<Estoque>> EstoqueGet() {
		List<Estoque> estoqueList = (List<Estoque>) estoqueRepository.findAll();
		return ResponseEntity.ok(estoqueList);
	}
}