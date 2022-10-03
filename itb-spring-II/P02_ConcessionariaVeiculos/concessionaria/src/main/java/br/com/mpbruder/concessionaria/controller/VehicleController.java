package br.com.mpbruder.concessionaria.controller;

import br.com.mpbruder.concessionaria.VehicleDto;
import br.com.mpbruder.concessionaria.model.Vehicle;
import br.com.mpbruder.concessionaria.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired // Injeção de dependência (framework gera o objeto)
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> createNewVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createNewVehicle(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicleDtoList = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicleDtoList, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByManufacturingDate(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date since,
                                                                              @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date to) {
        List<VehicleDto> vehicleDtoList = vehicleService.getAllVehiclesByManufacturingDate(since, to);
        return new ResponseEntity<>(vehicleDtoList, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByPrice(@RequestParam double since,
                                                                  @RequestParam double to) {
        List<VehicleDto> vehicleDtoList = vehicleService.getAllVehiclesByPrice(since, to);
        return new ResponseEntity<>(vehicleDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.FOUND);
    }

}
