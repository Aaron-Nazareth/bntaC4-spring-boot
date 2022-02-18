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

    public void insertCar(Car car) {
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

    public Car getCarById(Integer id) {
        return checkCarIDExists(id);
    }

    public void deleteCar(Integer id) {
        checkCarIDExists(id);

        int result = carDAO.deleteCar(id);

        if (result != -1) {
            throw new IllegalStateException("Could not delete car...");
        }
    }

    public void updateCar(Integer id, Car update) {
        checkCarIDExists(id);

        int result = carDAO.updateCar(id, update);

        if (result != 0) {
            throw new IllegalStateException("Could not update car...");
        }
    }

    private Car checkCarIDExists(Integer id) {
        Car car = carDAO.selectCarById(id);
        if (car == null) {
            throw new CarNotFoundException("Car ID not found within our database");
        }
        return car;
    }
}
