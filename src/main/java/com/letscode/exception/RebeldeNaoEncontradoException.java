package com.letscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RebeldeNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public RebeldeNaoEncontradoException(String errorMessage) {
        super(errorMessage);
	}
}
