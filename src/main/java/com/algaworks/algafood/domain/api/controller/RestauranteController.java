package com.algaworks.algafood.domain.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;

	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long codigo) {
		Restaurante restaurante = restauranteRepository.buscar(codigo);
		if (restaurante == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(restaurante);
	}

	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return 	ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Restaurante restaurante) {
		try {
			Restaurante restauranteAtual = cadastroRestauranteService.buscar(restaurante.getId());
			if (restauranteAtual != null) {
				BeanUtils.copyProperties(restaurante, restauranteAtual);
				Restaurante restauranteAtualizado = cadastroRestauranteService.salvar(restauranteAtual);
				return ResponseEntity.ok(restauranteAtualizado);
			}

			return ResponseEntity.notFound().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}