package br.ce.sjanu.barriga.domain.exceptions;

public class ValidationException extends RuntimeException {
	private static final long serialVersionUID = -8212466394826225240L;

	public ValidationException(String message) {
		super(message);
	}
}
