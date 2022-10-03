package br.com.mpbruder.concessionaria.service;

import br.com.mpbruder.concessionaria.VehicleDto;
import br.com.mpbruder.concessionaria.model.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleService {

    Vehicle createNewVehicle(Vehicle vehicle);

    List<VehicleDto> getAllVehicles();

    List<VehicleDto> getAllVehiclesByManufacturingDate(Date from, Date to);

    List<VehicleDto> getAllVehiclesByPrice(double from, double to);

    //Vehicle getVehicleById();
}
