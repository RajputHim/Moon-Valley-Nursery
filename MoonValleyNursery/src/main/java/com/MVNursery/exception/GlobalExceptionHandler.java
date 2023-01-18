package com.MVNursery.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PlanterException.class)
	public ResponseEntity<MyErrorDetails> planterExceptionHandler(PlanterException pe, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<MyErrorDetails> planterExceptionHandler(OrdersException pe, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genericExceptionHandler(Exception ge, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ge.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myexpHandler4(NoHandlerFoundException ne, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ne.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails("Validation Error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
