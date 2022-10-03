package br.com.mpbruder.terceiro_exemplo.service;

import br.com.mpbruder.terceiro_exemplo.exception.VehicleNotFoundException;
import br.com.mpbruder.terceiro_exemplo.model.Veiculo;
import br.com.mpbruder.terceiro_exemplo.repository.VeiculoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VeiculoService implements IVeiculo {

    private VeiculoRepo veiculoRepo;

    @Override
    public Veiculo getVeiculo(String placa) throws VehicleNotFoundException {
        Optional<Veiculo> veiculoOptional = veiculoRepo.getVeiculo(placa);
        if(veiculoOptional.isEmpty()) {
            throw new VehicleNotFoundException("Veículo não encontrado");
        }
        return veiculoOptional.get();
    }

    @Override
    public List<Veiculo> getAllVeiculo() {
        return null;
    }
}
