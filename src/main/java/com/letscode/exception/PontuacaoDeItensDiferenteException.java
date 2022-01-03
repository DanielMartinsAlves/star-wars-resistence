package com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PontuacaoDeItensDiferenteException extends Exception {
	private static final long serialVersionUID = 1L;	
	
	public PontuacaoDeItensDiferenteException(String errorMessage) {
	        super(errorMessage);
	}
}
