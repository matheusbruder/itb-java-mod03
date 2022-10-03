package br.com.mpbruder.terceiro_exemplo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice // Responsável por interceptar e tratar as exceções lançadas
public class HandlerExceptions {

    @ExceptionHandler(NotFoundException.class) // Gerenciador de exceções da classe NotFoundException
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException nfe) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .titulo("Objeto não encontrado")
                .mensagem(nfe.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FilesException.class)
    public ResponseEntity<ExceptionDetails> handlerFilesException(FilesException rfe) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .titulo("Erro ao manipular arquivo")
                .mensagem(rfe.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

}
