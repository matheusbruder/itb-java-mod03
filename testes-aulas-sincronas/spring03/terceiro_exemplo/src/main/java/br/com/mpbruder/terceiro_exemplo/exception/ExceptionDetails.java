package br.com.mpbruder.terceiro_exemplo.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder // Gera possibilidade de criarmos objeto sem utilizar construtores convencionais
public class ExceptionDetails {

    private String titulo;
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;

}
