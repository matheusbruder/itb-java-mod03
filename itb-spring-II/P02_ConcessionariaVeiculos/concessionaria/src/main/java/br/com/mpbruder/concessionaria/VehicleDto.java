package br.com.mpbruder.concessionaria;

import br.com.mpbruder.concessionaria.model.Vehicle;
import lombok.Data;

import java.util.Date;

@Data
public class VehicleDto {
    private String brand;
    private String model;
    private Date manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

    public VehicleDto(Vehicle vehicle) {
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.manufacturingDate = vehicle.getManufacturingDate();
        this.numberOfKilometers = vehicle.getNumberOfKilometers();
        this.doors = vehicle.getDoors();
        this.price = vehicle.getPrice();
        this.currency = vehicle.getCurrency();
        this.countOfOwners = vehicle.getCountOfOwners();
    }
}
