package br.com.v2bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClientNotFoundException extends ResponseStatusException{

	private static final long serialVersionUID = -1882772027566209342L;
	
	public ClientNotFoundException(HttpStatus err) {
		super(err);
	}
	
	public ClientNotFoundException(HttpStatus err, String message) {
		super(err, message);
	}

}
