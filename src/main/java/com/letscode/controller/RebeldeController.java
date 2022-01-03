package com.letscode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.entidade.Localizacao;
import com.letscode.entidade.Rebelde;
import com.letscode.exception.RebeldeExistenteException;
import com.letscode.exception.RebeldeNaoEncontradoException;
import com.letscode.service.RebeldeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rebeldes")
public class RebeldeController {
	
	@Autowired
	private RebeldeService rebeldeService;
	
	@ApiOperation(value = "Lista os rebeldes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Rebeldes listados"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Rebelde> listar(){
		return rebeldeService.listar();
	}
	
	@ApiOperation(value = "Adiciona um rebelde")
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "Rebelde criado"),
	    @ApiResponse(code = 404, message = "Rebelde já existente, não pode ser alterado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Rebelde adicionar(@RequestBody Rebelde rebelde) throws RebeldeExistenteException {
		return rebeldeService.adicionar(rebelde);
	}
	
	
	@ApiOperation(value = "Altera a localização de um rebelde")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Localização alterada"),
	    @ApiResponse(code = 400, message = "Rebelde não encontrado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping("/{idRebelde}/localizacao")
	@ResponseStatus(value = HttpStatus.OK)
	public Localizacao atualizarLocalizacao(@PathVariable String idRebelde, @RequestBody Localizacao localizacao) throws RebeldeNaoEncontradoException {
		return rebeldeService.atualizarLocalizacao(idRebelde, localizacao);
	}
}
