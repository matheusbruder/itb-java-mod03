package br.com.mpbruder.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(DuplicatedIdException.class)
    public ResponseEntity<ExceptionDetails> handlerDuplicatedIdException(DuplicatedIdException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .titulo("Objeto duplicado")
                .mensagem(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EmptyRepositoryException.class)
    public ResponseEntity<ExceptionDetails> handlerEmptyRepositoryException(EmptyRepositoryException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .titulo("Objeto inexistente")
                .mensagem(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .titulo("Objeto inexistente")
                .mensagem(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

}
