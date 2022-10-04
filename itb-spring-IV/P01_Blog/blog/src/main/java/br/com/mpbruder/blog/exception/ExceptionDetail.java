package br.com.mpbruder.blog.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetail {
    private String titulo;
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
