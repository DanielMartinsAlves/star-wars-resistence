package com.letscode.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.dto.NegociacaoDTO;
import com.letscode.entidade.Item;
import com.letscode.entidade.Rebelde;
import com.letscode.exception.PontuacaoDeItensDiferenteException;
import com.letscode.exception.RebeldeNaoEncontradoException;
import com.letscode.exception.RebeldeTraidorException;
import com.letscode.repository.RebeldeRepository;
import com.letscode.repository.TraicaoRepository;

@Service
public class NegociacaoService {
	
	private static final String REBELDE1_NAO_ENCONTRADO = "Rebelde 1 não encontrado.";
	private static final String REBELDE2_NAO_ENCONTRADO = "Rebelde 2 não encontrado.";
	private static final String SOMA_PONTUACAO_DIFERENTE = "A soma da pontuação dos itens de negociação são diferentes entre as duas partes. Favor rever.";
	private static final String REBELDE1_TRAIDOR = "Rebelde 1 não pode negociar itens pois é um traidor!";
	private static final String REBELDE2_TRAIDOR = "Rebelde 2 não pode negociar itens pois é um traidor!";

	@Autowired
	private RebeldeRepository rebeldeRepository;
	
	@Autowired
	private TraicaoRepository traicaoRepository;
	
	public NegociacaoDTO negociar(NegociacaoDTO negociacaoDTO) throws PontuacaoDeItensDiferenteException, RebeldeNaoEncontradoException, RebeldeTraidorException   {
		Rebelde rebelde1 = rebeldeRepository.findById(negociacaoDTO.getIdNegociador1()).orElseThrow(() -> new RebeldeNaoEncontradoException(REBELDE1_NAO_ENCONTRADO));
		if(traicaoRepository.isTraidor(rebelde1.getId())) {
			throw new RebeldeTraidorException(REBELDE1_TRAIDOR);
		}
		Rebelde rebelde2 = rebeldeRepository.findById(negociacaoDTO.getIdNegociador2()).orElseThrow(() -> new RebeldeNaoEncontradoException(REBELDE2_NAO_ENCONTRADO));
		if(traicaoRepository.isTraidor(rebelde2.getId())) {
			throw new RebeldeTraidorException(REBELDE2_TRAIDOR);
		}
		List<Item> itensnegociador1 = retiraItensIventario(negociacaoDTO.getIdsItensNegociador1(), rebelde1.getInventario());
		List<Item> itensnegociador2 = retiraItensIventario(negociacaoDTO.getIdsItensNegociador2(), rebelde2.getInventario());
		
		Integer somaPontosItensNegociador1 = itensnegociador1.stream().mapToInt(item->item.getPontuacao()).sum();
		Integer somaPontosItensNegociador2 = itensnegociador2.stream().mapToInt(item->item.getPontuacao()).sum();
		
		if(somaPontosItensNegociador1!=somaPontosItensNegociador2) {
			throw new PontuacaoDeItensDiferenteException(SOMA_PONTUACAO_DIFERENTE);
		}else {
			rebelde1.getInventario().addAll(itensnegociador2);
			rebelde2.getInventario().addAll(itensnegociador1);
			rebeldeRepository.saveAll(Arrays.asList(rebelde1, rebelde2));
		}
		
		return negociacaoDTO;
	}
	private List<Item> retiraItensIventario(Long[] idItensRetirar, List<Item> inventario){
		List<Item> itensretirados = new ArrayList<>();
		for(Long item:idItensRetirar) {
			for(int i = 0; i<inventario.size();i++) {
				if(inventario.get(i).getId()==item) {
					itensretirados.add(inventario.get(i));
					inventario.remove(i);
					break;
				}
			}
		}
		return itensretirados;
	}
}
