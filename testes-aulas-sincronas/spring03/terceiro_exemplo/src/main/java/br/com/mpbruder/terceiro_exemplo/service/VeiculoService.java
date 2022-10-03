package br.com.mpbruder.terceiro_exemplo.service;

import br.com.mpbruder.terceiro_exemplo.exception.NotFoundException;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import br.com.mpbruder.terceiro_exemplo.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class VeiculoService implements IVeiculo {

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Override
    public Veiculo getVeiculo(String placa) throws NotFoundException {
        Optional<Veiculo> veiculoOptional = veiculoRepo.getVeiculo(placa);
        if (veiculoOptional.isEmpty()) {
            throw new NotFoundException("Veículo não encontrado");
        }

        return veiculoOptional.get();
    }

    @Override
    public List<Veiculo> getAllVeiculo() throws NotFoundException {
        Optional<List<Veiculo>> optionalVeiculoList = veiculoRepo.getAllVeiculo();
        if (optionalVeiculoList.isEmpty()) {
            throw new NotFoundException("Lista de veículos vazia");
        }

        return optionalVeiculoList.get();
    }

    @Override
    public List<Veiculo> getAllOrderByValue() throws NotFoundException {
        Optional<List<Veiculo>> optionalVeiculoList = veiculoRepo.getAllVeiculo();
        if (optionalVeiculoList.isEmpty()) {
            throw new NotFoundException("Lista de veículos vazia");
        }

        return optionalVeiculoList.get().stream()
                .sorted(Comparator.comparing(Veiculo::getValor))
                .toList();
    }

    @Override
    public void addVeiculo(Veiculo veiculo) {
        veiculoRepo.addVeiculo(veiculo);
    }

    @Override
    public List<Veiculo> getVeiculoByModelo(String modelo) {
        Optional<List<Veiculo>> optionalVeiculoList = veiculoRepo.getAllVeiculo();
        if (optionalVeiculoList.isEmpty()) {
            throw new NotFoundException("Veículo não encontrado");
        }

        return optionalVeiculoList.get().stream()
                .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
                .toList();
    }
}
