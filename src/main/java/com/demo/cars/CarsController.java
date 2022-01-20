package com.demo.cars;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CarsController {

    private List<Car> cars;
    private String status = "OK";
    private String flag = "READY";

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        //Generate fake static data
        cars = new ArrayList<Car>();
        cars.add(new Car(1,"Mercedes GLA","Daimler AG"));
        cars.add(new Car(2,"Mini John Cooper Works","BMW"));
        cars.add(new Car(3,"Bmw Z4","BMW"));
        cars.add(new Car(4,"Ferrari Roma","Ferrari"));
        cars.add(new Car(5,"Mercedes Maybach","Daimler"));
        cars.add(new Car(6,"Rolls Royce","Rolls-Royce Motor Cars"));

        return cars;
    }

    @GetMapping("/status")
    public String getStatus() {
        return status;
    }

}
