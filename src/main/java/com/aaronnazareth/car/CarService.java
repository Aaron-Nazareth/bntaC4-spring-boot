package com.aaronnazareth.car;

import java.util.List;

public class CarService {

    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void registerNewCar(Car car) {
        if (car.getPrice() <= 0) {
            throw new IllegalStateException("Car price cannot be 0 or less");
        }

        int result = carDAO.insertCar(car);

        if (result != 1) {
            throw new IllegalStateException("Could not save car");
        }
    }

    public List<Car> getAllCars() {
        return carDAO.selectAllCars();
    }
}
