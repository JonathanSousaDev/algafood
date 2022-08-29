package com.algaworks.algafood.domain.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long codigo) {
		Cozinha cozinha = cozinhaRepository.buscar(codigo);
		//return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		return ResponseEntity.ok(cozinha);
	}
}
