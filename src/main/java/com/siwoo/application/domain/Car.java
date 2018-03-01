package com.siwoo.application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Table(name = "car")
@Getter @Setter @ToString
public class Car {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String manufacturer;
    private LocalDate manufactureDate;
    private int age;
    @Version
    private int version;
}
