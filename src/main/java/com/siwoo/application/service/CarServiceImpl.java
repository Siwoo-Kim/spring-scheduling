package com.siwoo.application.service;

import com.siwoo.application.domain.Car;
import com.siwoo.application.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service("carService") @Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    @Autowired CarRepository carRepository;
    private boolean done = false;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override @Transactional(readOnly = false)
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Async
    @Scheduled(cron = "1/6 * * * * *")
    @Override @Transactional(readOnly = false)
    public void updateCarAgeJob() {
        List<Car> cars = carRepository.findAll();
        LocalDate currentDate = LocalDate.now();

        cars.forEach(car -> {
            Long remain = ChronoUnit.YEARS.between(car.getManufactureDate(),currentDate);
            car.setAge(remain.intValue());
            carRepository.save(car);

        });
        cars.stream().map(Car::toString).forEach(log::warn);
        log.info("Updating age successful");
        done = true;
    }

    @Override
    public boolean isDone() {
        return done;
    }
}
