package com.ev_info_service_backend.ev_info_service_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    //Model for the Car data structure that is displayed by the frontend
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String brand;

    private String name;

    private double price;

    private double batteryCapacity;

    private int range;

    private double efficiency;

    private double acceleration;

    private int topSpeed;

    private CarSegment segment;

    private BodyType bodyType;

    private int safety;

    private String image;
    
}
