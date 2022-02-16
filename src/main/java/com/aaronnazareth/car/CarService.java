package com.aaronnazareth.car;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarDAO carDAO;

    public CarService(@Qualifier("fake") CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void registerNewCar(Car car) {
        // business logic. check if reg number is valid and not take
        if (car.getPrice() <= 0) {
            throw new IllegalStateException("Car price cannot be 0 or less");
        }
        int result = carDAO.insertCar(car);

        if (result != 1) {
            throw new IllegalStateException("Could not save car...");
        }
    }

    public List<Car> getCars() {
        return carDAO.selectAllCars();
    }

    public Car getCarById(Integer carId) {
        return checkCarIDExists(carId);
    }

    private Car checkCarIDExists(Integer carId) {
        Car car = carDAO.selectCarById(carId);
        if (car == null) {
            throw new IllegalStateException("Car ID not found within our database");
        }
        return car;
    }
}
