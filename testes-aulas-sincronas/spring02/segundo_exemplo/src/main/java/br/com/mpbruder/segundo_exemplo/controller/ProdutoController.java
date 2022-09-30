package br.com.mpbruder.segundo_exemplo.controller;

import br.com.mpbruder.segundo_exemplo.dto.ProdutoDTO;
import br.com.mpbruder.segundo_exemplo.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        produtos.add(new Produto(1, "Produto 1", 10.0));
        produtos.add(new Produto(2, "Produto 2", 20.0));
        produtos.add(new Produto(3, "Produto 3", 30.0));
        produtos.add(new Produto(4, "Produto 4", 40.0));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable int id) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProdutoDTO produtoDTO = new ProdutoDTO(produto.get());
        return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> newProduto(@RequestBody Produto produto) {
        produto.setId(produtos.size() + 1);
        produtos.add(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable int id) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        produtos.remove(produto.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        // return new ResponseEntity<>(produtos, HttpStatus.OK);
        return ResponseEntity.ok(produtos);
    }
}
