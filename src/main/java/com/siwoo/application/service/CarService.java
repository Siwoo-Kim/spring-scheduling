package com.siwoo.application.service;

import com.siwoo.application.domain.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
    boolean isDone();

}
