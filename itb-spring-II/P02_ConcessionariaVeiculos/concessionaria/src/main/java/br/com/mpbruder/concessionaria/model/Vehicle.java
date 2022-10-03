package br.com.mpbruder.concessionaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}


