package br.com.mpbruder.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private int id;
    private String titulo;
    private String nomeAutor;
    private Date publicacao;
}
