package br.com.mpbruder.terceiro_exemplo.controller;

import br.com.mpbruder.terceiro_exemplo.exception.VehicleNotFoundException;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import br.com.mpbruder.terceiro_exemplo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired // Injeção de dependência (framework gera o objeto)
    private VeiculoService veiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        try {
            Veiculo veiculo = veiculoService.getVeiculo(placa);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {

        try {
            List<Veiculo> veiculoList = veiculoService.getAllVeiculo();
            return new ResponseEntity<>(veiculoList, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
