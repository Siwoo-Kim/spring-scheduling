package com.siwoo.application.config;

import com.siwoo.application.domain.Car;
import com.siwoo.application.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Slf4j
@Service
public class DBInitializer {

    @Autowired CarRepository carRepository;

    @PostConstruct
    public void initDB(){
        log.info("Starting database initialization...");
        Car car = new Car();
        car.setLicensePlate("GRAVITY-0405");
        car.setManufacturer("Ford");
        car.setManufactureDate(LocalDate.of(2006,9,12));
        carRepository.save(car);

        car = new Car();
        car.setLicensePlate("CLARITY-0432");
        car.setManufacturer("Toyota");
        car.setManufactureDate(LocalDate.of(2003,9,9));
        carRepository.save(car);

        car = new Car();
        car.setLicensePlate("ROSIE-04202");
        car.setManufacturer("Toyota");
        car.setManufactureDate(LocalDate.of(2017,4,16));
        carRepository.save(car);

        log.info("Database initialization finished");
    }
}
