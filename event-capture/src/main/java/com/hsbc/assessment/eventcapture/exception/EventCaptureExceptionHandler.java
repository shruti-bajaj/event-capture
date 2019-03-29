package com.hsbc.assessment.eventcapture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EventCaptureExceptionHandler extends
		ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handleUserNotFoundException(Exception ex, WebRequest request) {
		String errorDetails = "Something went wrong.";
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
