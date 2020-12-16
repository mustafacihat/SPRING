package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OrmconfigApplication {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmconfigApplication.class, args);
    }

    @PostConstruct
    public void dataInit(){
        Car car1 = new Car("BMW","M5");
        Car car2 = new Car("Kia","Sorento");
        Car car3 = new Car("Mercedes","S500");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
    }

}
