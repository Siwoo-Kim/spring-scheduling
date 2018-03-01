package com.siwoo.application.repository;

import com.siwoo.application.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long>{


}
