package com.ev_info_service_backend.ev_info_service_backend.controller;

import com.ev_info_service_backend.ev_info_service_backend.entity.Car;
import com.ev_info_service_backend.ev_info_service_backend.exceptions.CarNotFoundException;
import com.ev_info_service_backend.ev_info_service_backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Endpoint for CRUD operations on cars

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    
    //Route that fetches all cars
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAllCars();

        return ResponseEntity.ok(cars);
    }

    //Route that gets a single car by id that is passed in the URL
    @GetMapping("{id}")
    public ResponseEntity<Car> getCar(@PathVariable("id") Long id) throws CarNotFoundException {
        Car car = carService.findCarById(id);

        return ResponseEntity.ok(car);
    }

    //Route to create a new car
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = carService.createCar(car);
        return new ResponseEntity<Car>(newCar, HttpStatus.CREATED);
    }

    //Route to update a car by id
    @PutMapping("{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car car) throws CarNotFoundException {
        Car updatedCar = carService.updateCar(id, car);

        return ResponseEntity.ok(updatedCar);
    }

    //Route to delete a car by id
    @DeleteMapping("{id}")
    public String deleteCar(@PathVariable("id") Long id) throws CarNotFoundException {
        carService.deleteCar(id);

        return "Car with id " + id + " has been successfully deleted!";
    }

    @GetMapping("/filter/{brand}")
    public ResponseEntity<List<Car>> getByBrand(@PathVariable("brand") String brand) {
        List<Car> cars = carService.findByBrand(brand);

        return ResponseEntity.ok(cars);
    }
}
