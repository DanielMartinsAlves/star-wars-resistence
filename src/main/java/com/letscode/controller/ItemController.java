package com.letscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.entidade.Item;
import com.letscode.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	
	@ApiOperation(value = "Adiciona um item")
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "Item adicionado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Item adicionar(@RequestBody Item item) {
		return itemService.adicionar(item);
	}
	
}
