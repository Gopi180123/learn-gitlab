package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.user.UserNotFoundException;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		{
			ExceptionResponse exceptionResponse=new ExceptionResponse("jjk messsage testing", new Date(),"Details "+ex.getMessage()+request.getDescription(false));
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserExceptions(Exception ex, WebRequest request) throws Exception {
		{
			ExceptionResponse exceptionResponse=new ExceptionResponse("user messsage testing", new Date(),"Details "+ex.getMessage()+request.getDescription(false));
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		{
			ExceptionResponse exceptionResponse=new ExceptionResponse("user validation failed"+ex.getBindingResult(), new Date(),"Details "+ex.getMessage()+request.getDescription(false));
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
	}
}
