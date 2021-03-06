package com.aaronnazareth.car;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(path = "cars")
    public void addCar(@RequestBody Car car) {
        carService.insertCar(car);
    }

    @GetMapping(path = "cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping(path = "cars/{id}")
    public Car getCarById(@PathVariable("id") Integer id)  {
        return carService.getCarById(id);
    }

    @DeleteMapping(path = "cars/{id}")
    public void deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
    }

    @PutMapping(path = "cars/{id}")
    public void updateCar(@PathVariable("id") Integer id, @RequestBody Car update) {
        carService.updateCar(id, update);
    }
}
