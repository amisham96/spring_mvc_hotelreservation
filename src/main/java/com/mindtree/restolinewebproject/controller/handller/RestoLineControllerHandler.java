package com.mindtree.restolinewebproject.controller.handller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.restolinewebproject.Exception.RestoLineWebProjectException;
import com.mindtree.restolinewebproject.dto.ErrorDTO;
import com.mindtree.restolinewebproject.dto.ResponseBodys;

@RestControllerAdvice
public class RestoLineControllerHandler {


	@ExceptionHandler(RestoLineWebProjectException.class)
	public ResponseEntity<?> errorHandler(Exception e) {
		return new ResponseEntity<ResponseBodys<Void>>(new ResponseBodys<Void>(null,
				new ErrorDTO(e.getMessage(), e.getCause()), "Error in Application", false),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		String errorMessaage = "";
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorMessaage += error.getDefaultMessage() + ", ";
		}

		return new ResponseEntity<ResponseBodys<Void>>(new ResponseBodys<Void>(null,
				new ErrorDTO(errorMessaage, ex.getCause()), "Error in Application", false), HttpStatus.BAD_REQUEST);

	}

}
