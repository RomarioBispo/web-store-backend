package br.com.codevelopment.common.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongodb.MongoWriteException;

import br.com.codevelopment.common.domain.model.error.ErrorMessage;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { UserNotFoundException.class})
  protected ResponseEntity<ErrorMessage> userNotFoundHandler(RuntimeException ex, WebRequest request) {
	  ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), "Record not found", ex.getMessage(), request.getContextPath());
	  return new ResponseEntity<>(errorMessage, NOT_FOUND);
  }
  
  @ExceptionHandler(value = { DuplicateKeyException.class, MongoWriteException.class})
  protected ResponseEntity<ErrorMessage> duplicateUserException(RuntimeException ex, WebRequest request) {
	  ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), "Record already exists", ex.getMessage(), request.getContextPath());
	  return new ResponseEntity<>(errorMessage, BAD_REQUEST);
  }
}
