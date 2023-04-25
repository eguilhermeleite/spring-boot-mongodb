package com.spring.mongodb.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;

@RestControllerAdvice
public class ResourceExceptionHandler {

	// recurso nao encontrado
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(NullPointerException ex, HttpServletRequest request) {

		Instant moment = Instant.now();
		String message = ex.getMessage();
		String path = request.getRequestURI();

		APIError apiError = new APIError(moment, HttpStatus.NOT_FOUND.value(), message, path);

		return ResponseEntity.status(apiError.getStatus()).body(apiError);

	}// recurso nao encontrado

	@Getter
	// classe para recurso nao encontrado e regra do bd
	private static class APIError {

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
		private Instant moment;
		private int status;
		private String message;
		private String path;

		public APIError() {
		}

		public APIError(Instant moment, int status, String message, String path) {
			this.moment = moment;
			this.status = status;
			this.message = message;
			this.path = path;
		}// fim do construtor

	}// classe para recurso nao encontrado e regra do bd

}
