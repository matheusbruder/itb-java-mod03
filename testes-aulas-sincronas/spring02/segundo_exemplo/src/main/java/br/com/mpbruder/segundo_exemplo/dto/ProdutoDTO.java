package br.com.mpbruder.segundo_exemplo.dto;

import br.com.mpbruder.segundo_exemplo.model.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {

    private String nome;
    private double valor;

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
