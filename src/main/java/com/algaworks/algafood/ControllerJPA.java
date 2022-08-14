package com.algaworks.algafood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/jpa")
public class ControllerJPA {

	@Autowired
	private CozinhaRepository cozinhas;

	@Autowired
	private RestauranteRepository restaurantes;

	@Autowired
	private FormaPagamentoRepository formasPagamento;

	@Autowired
	private EstadoRepository estados;

	@Autowired
	private CidadeRepository cidades;

	@Autowired
	private PermissaoRepository permissoes;

	@GetMapping
	private List<Cozinha> mainCozinha() {
		//Consultar
		List<Cozinha> todasCozinhas = cozinhas.listar();
		System.out.println(todasCozinhas.get(0).getNome());
		return todasCozinhas;
	}

	@GetMapping("/restaurantes")
	private List<Restaurante> mainRestaurante() {
		//Consultar
		List<Restaurante> todosRestaurantes = restaurantes.listar();
		System.out.println(todosRestaurantes.get(0).getNome());
		return todosRestaurantes;
	}

	@GetMapping("/formas-pagamento")
	private List<FormaPagamento> mainFormasPagamento() {
		return formasPagamento.listar();
	}

	@GetMapping("/estados")
	private List<Estado> mainEstados() {
		return estados.listar();
	}

	@GetMapping("/cidades")
	private List<Cidade> mainCidades() {
		return cidades.listar();
	}

	@GetMapping("/permissoes")
	private List<Permissao> mainPermissoes() {
		return permissoes.listar();
	}
}

