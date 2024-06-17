package com.example.realestatego.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
			map.put(fieldName, msg);
		});
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		// Handle resource not found exception and return a custom message
		HttpHeaders headers = new HttpHeaders();
		headers.add("Description", "Trying to get Resources");
		String msg = String.format("%s not found with %s: '%s'", ex.getResourceName(), ex.getFieldName(),
				ex.getFieldValue());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)

	public ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {

		// Handle resource already exists exception and return a custom message
		HttpHeaders headers = new HttpHeaders();
		headers.add("Description", "Trying to get User");
		return ResponseEntity.status(HttpStatus.IM_USED).headers(headers).body(ex.getMessage());

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String errorMessage = ex.getMessage();

        // Check if the error message indicates a duplicate entry violation for contact number
        if (errorMessage.contains("Duplicate entry") && errorMessage.contains("for key 'UK_h9yxaoeuc4t89qbjbxh18ik7x'")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Cannot insert data. Contact number already exists.");
        }
        else if (errorMessage.contains("Duplicate entry") && errorMessage.contains("for key 'UK_r43af9ap4edm43mmtq01oddj6'")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Cannot insert data. Username already exists. Please provide a different username.");
        }

        // For other data integrity violations, return a generic error message
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data integrity violation: " + errorMessage);
    }

}
