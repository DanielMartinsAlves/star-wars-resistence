package com.letscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.dto.NegociacaoDTO;
import com.letscode.exception.PontuacaoDeItensDiferenteException;
import com.letscode.exception.RebeldeNaoEncontradoException;
import com.letscode.exception.RebeldeTraidorException;
import com.letscode.service.NegociacaoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/negociacoes")
public class NegociacaoController {

	@Autowired
	private NegociacaoService negociacaoService;
	
	
	@ApiOperation(value = "Negocia/troca itens entre 2 rebeldes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Negociação realizada"),
	    @ApiResponse(code = 400, message = "Algum dos 2 rebeldes não foi encontrado"),
	    @ApiResponse(code = 404, message = "Regra de negócio: Ou o rebelde é um traidor ou os itens em troca não possuem o mesmo valor (pontuação)"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public NegociacaoDTO negociar(@RequestBody NegociacaoDTO negociacaoDTO) throws PontuacaoDeItensDiferenteException, RebeldeNaoEncontradoException, RebeldeTraidorException   {
		return negociacaoService.negociar(negociacaoDTO);
	}
}
