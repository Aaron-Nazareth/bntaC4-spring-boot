package com.aaronnazareth.car;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fake")
public class FakeCarDataAccessService implements CarDAO {

    private List<Car> db;

    public FakeCarDataAccessService() {
        this.db = new ArrayList<>();
    }

    @Override
    public Car selectCarById(Integer id) {
        for (Car car : db) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> selectAllCars() {
        return db;
    }

    @Override
    public int insertCar(Car car) {
        db.add(car);
        return 1;
    }

    @Override
    public int deleteCar(Integer id) {
        return 0;
    }

    @Override
    public int updateCar(Integer id, Car update) {
        return 0;
    }
}
