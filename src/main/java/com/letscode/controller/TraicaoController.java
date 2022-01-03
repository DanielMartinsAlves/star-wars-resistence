package com.letscode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.entidade.Traicao;
import com.letscode.service.TraicaoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/traicoes")
public class TraicaoController {

	@Autowired
	private TraicaoService traicaoService;
	
	@ApiOperation(value = "Lista avisos de traição")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Traições listadas"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Traicao> listar(){
		return traicaoService.listar();
	}
	@ApiOperation(value = "Avisa/informa uma traição")
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "Traição informada"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Traicao adicionar(@RequestBody Traicao traicao) {
		return traicaoService.adicionar(traicao);
	}
}
