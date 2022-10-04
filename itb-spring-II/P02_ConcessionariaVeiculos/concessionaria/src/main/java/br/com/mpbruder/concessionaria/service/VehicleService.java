package br.com.mpbruder.concessionaria.service;

import br.com.mpbruder.concessionaria.VehicleDto;
import br.com.mpbruder.concessionaria.exception.NotFoundException;
import br.com.mpbruder.concessionaria.model.Vehicle;
import br.com.mpbruder.concessionaria.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    @Autowired // Injeção de dependência (framework gera o objeto)
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle createNewVehicle(Vehicle vehicle) {
        return vehicleRepository.saveVehicle(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<VehicleDto> vehicles = vehicleRepository.getAllVehicles();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("Lista de veículos vazia");
        }

        return vehicles;
    }

    @Override
    public List<VehicleDto> getAllVehiclesByManufacturingDate(Date since, Date to) {
        List<VehicleDto> vehicles = vehicleRepository.getAllVehicles().stream()
                .filter(v -> v.getManufacturingDate().after(since) && v.getManufacturingDate().before(to))
                .sorted(Comparator.comparing(VehicleDto::getManufacturingDate))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("Lista de veículos vazia");
        }

        return vehicles;
    }

    @Override
    public List<VehicleDto> getAllVehiclesByPrice(double since, double to) {
        List<VehicleDto> vehicles = vehicleRepository.getAllVehicles().stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .sorted(Comparator.comparing(VehicleDto::getPrice))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("Lista de veículos vazia");
        }

        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.getVehicleById(id);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("Veículo [" + id + "] não encontrado");
        }
        return vehicle.get();
    }
}
