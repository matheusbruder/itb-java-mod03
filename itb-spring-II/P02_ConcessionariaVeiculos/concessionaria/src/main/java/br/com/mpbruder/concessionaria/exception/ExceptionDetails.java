package br.com.mpbruder.concessionaria.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String titulo;
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
