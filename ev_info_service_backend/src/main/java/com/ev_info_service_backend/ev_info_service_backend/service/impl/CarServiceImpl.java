package com.ev_info_service_backend.ev_info_service_backend.service.impl;

import com.ev_info_service_backend.ev_info_service_backend.entity.Car;
import com.ev_info_service_backend.ev_info_service_backend.exceptions.CarNotFoundException;
import com.ev_info_service_backend.ev_info_service_backend.repository.CarRepository;
import com.ev_info_service_backend.ev_info_service_backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Implementation of CRUD operations for the car data structure

@Service
public class CarServiceImpl implements CarService {
    
    @Autowired
    private CarRepository carRepository;
    
    //Create a new car
    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }
    
    

    //Find a car by id
    @Override
    public Car findCarById(Long id) throws CarNotFoundException {
        return carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("Car with id " + id + " does not exist!")
        );
    }

    //Collect a list of all cars
    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    
    //Update a car by id
    @Override
    public Car updateCar(Long id, Car updatedCar) throws CarNotFoundException {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("Car with id " + id + " does not exist!")
        );

        car.setBrand(updatedCar.getBrand());
        car.setName(updatedCar.getName());
        car.setPrice(updatedCar.getPrice());
        car.setBatteryCapacity(updatedCar.getBatteryCapacity());
        car.setRange(updatedCar.getRange());
        car.setEfficiency(updatedCar.getEfficiency());
        car.setAcceleration(updatedCar.getAcceleration());
        car.setTopSpeed(updatedCar.getTopSpeed());
        car.setSegment(updatedCar.getSegment());
        car.setBodyType(updatedCar.getBodyType());
        car.setSafety(updatedCar.getSafety());
        car.setImage(updatedCar.getImage());

        return carRepository.save(car);
    }

    
    //Delete a car by id
    @Override
    public void deleteCar(Long id) throws CarNotFoundException {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("Car with id " + id + " does not exist!")
        );
        carRepository.deleteById(id);
    }

    
    //Find a car by brand
    @Override
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
}
