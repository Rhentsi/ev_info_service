package com.ev_info_service_backend.ev_info_service_backend.service;

import com.ev_info_service_backend.ev_info_service_backend.entity.Car;
import com.ev_info_service_backend.ev_info_service_backend.exceptions.CarNotFoundException;

import java.util.List;

public interface CarService {
    
    Car createCar (Car car);

    Car findCarById(Long id) throws CarNotFoundException;

    List<Car> findAllCars();

    Car updateCar(Long id, Car carDto) throws CarNotFoundException;

    void deleteCar(Long id) throws CarNotFoundException;

    List<Car> findByBrand(String brand);
}
