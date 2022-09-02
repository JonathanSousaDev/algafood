package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Cidade> listar() {
		return cidadeRepository.listar();
	}

	public Cidade buscar(Long cidadeId) {
		return cidadeRepository.buscar(cidadeId);
	}

	public Cidade salvar(Cidade cidade) {
		Estado estado = estadoRepository.buscar(cidade.getEstado().getId());
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com código %d", cidade.getEstado().getId()));
		}
		return cidadeRepository.salvar(cidade);
	}

	public void remover(Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);	
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", cidadeId));
		}
	}
}