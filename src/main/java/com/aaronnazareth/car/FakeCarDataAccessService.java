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
        for (Car car : db) {    // Loop through cars in list
            if (car.getId().equals(id)) {   // If the car id within the list matches the one being passed through as
                // an argument, then we can return the car
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
        return 1;   // Return 1 as an indicator for a successful insert. Return is needed, value of 1 is our choice.
    }

    @Override
    public int deleteCar(Integer id) {
        db.remove(selectCarById(id));   // Use list remove method, which requires an object
        return -1;  // Return -1 as an indicator for a successful delete. Return is needed, value of -1 is our choice.
    }

    @Override
    public int updateCar(Integer id, Car update) {
        for (int i = 0; i < db.size(); i++) {   // Loop through list
            Car car = db.get(i);    // Make car object at each index position
            if (car.getId() == id) {    // Check if id from list matches with id being passed through as argument
                db.set(i, update);  // Use list set method, which requires an index position and a new element
            }
        }
        return 0;   // Return 0 as an indicator for a successful update. Return is needed, value of 0 is our choice.
    }
}
