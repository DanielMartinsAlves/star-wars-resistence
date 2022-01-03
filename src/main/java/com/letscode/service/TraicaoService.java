package com.letscode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.entidade.Traicao;
import com.letscode.repository.TraicaoRepository;

@Service
public class TraicaoService {
	
	@Autowired
	private TraicaoRepository traicaoRepository;

	public Traicao adicionar(Traicao traicao) {
		return traicaoRepository.save(traicao); 
	}
	public List<Traicao> listar(){
		return traicaoRepository.findAll();
	}
}
