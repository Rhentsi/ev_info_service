package com.ev_info_service_backend.ev_info_service_backend.repository;

import com.ev_info_service_backend.ev_info_service_backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
}