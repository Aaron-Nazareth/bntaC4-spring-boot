package com.aaronnazareth.car;

public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void addCar(Car car) {}
}
