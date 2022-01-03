package com.letscode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.entidade.Localizacao;
import com.letscode.entidade.Rebelde;
import com.letscode.exception.RebeldeExistenteException;
import com.letscode.exception.RebeldeNaoEncontradoException;
import com.letscode.repository.RebeldeRepository;

@Service
public class RebeldeService {
	private static final String REBELDE_NAO_ENCONTRADO = "Rebelde não encontrado.";
	private static final String REBELDE_EXISTENTE = "Rebelde não pode ser alterado!";
	@Autowired
	private RebeldeRepository rebeldeRepository;

	public Rebelde adicionar(Rebelde rebelde) throws RebeldeExistenteException {
		
		if(rebelde.getId()!=null) {
			throw new RebeldeExistenteException(REBELDE_EXISTENTE);
		}
		return rebeldeRepository.save(rebelde);
	}
	public List<Rebelde> listar(){
		return rebeldeRepository.findAll();
	}
	public Localizacao atualizarLocalizacao(String idRebelde, Localizacao localizacao) throws RebeldeNaoEncontradoException {
		Rebelde rebelde = rebeldeRepository.findById(Long.parseLong(idRebelde)).orElseThrow(() -> new RebeldeNaoEncontradoException(REBELDE_NAO_ENCONTRADO));
		rebelde.getLocalizacao().setNome(localizacao.getNome());
		rebelde.getLocalizacao().setLatitude(localizacao.getLatitude());
		rebelde.getLocalizacao().setLongitude(localizacao.getLongitude());
		return rebeldeRepository.save(rebelde).getLocalizacao();
	}
}
