package br.com.mpbruder.terceiro_exemplo.controller;

import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import br.com.mpbruder.terceiro_exemplo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired // Injeção de dependência (framework gera o objeto)
    private VeiculoService veiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.getVeiculo(placa);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        List<Veiculo> veiculoList = veiculoService.getAllVeiculo();
        return new ResponseEntity<>(veiculoList, HttpStatus.OK);
    }

    @GetMapping("/all/byvalue")
    public ResponseEntity<List<Veiculo>> getAllOrderByValue() {
        List<Veiculo> veiculoList = veiculoService.getAllOrderByValue();
        return new ResponseEntity<>(veiculoList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addVeiculo(@RequestBody Veiculo veiculo) {
        veiculoService.addVeiculo(veiculo);
    }

    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<List<Veiculo>> getVeiculoByModelo(@PathVariable String modelo) {
        List<Veiculo> veiculoList = veiculoService.getVeiculoByModelo(modelo);
        return new ResponseEntity<>(veiculoList, HttpStatus.FOUND);
    }

}
