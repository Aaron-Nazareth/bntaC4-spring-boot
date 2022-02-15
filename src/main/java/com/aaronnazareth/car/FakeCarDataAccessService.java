package com.aaronnazareth.car;

import java.util.ArrayList;
import java.util.List;

public class FakeCarDataAccessService implements CarDAO{

    private List<Car> cars;

    public FakeCarDataAccessService() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car selectCarById(Integer id) {
        return null;
    }

    @Override
    public List<Car> selectAllCars() {
        return cars;
    }

    @Override
    public int insertCar(Car car) {
        cars.add(car);
        return 1;
    }

    @Override
    public int deleteCar(Car car) {
        cars.remove(car);
        return -1;
    }

    @Override
    public int updateCar(Integer id, Car update) {
        return 0;
    }
}
