package com.gadomska.springbootapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarApi {

    private CarManager carManager;

    @Autowired
    public CarApi(CarManager carManager){
        this.carManager = carManager;
    }

    // http://localhost:8080/sayHello?name=Sandra
    @GetMapping("/sayHello")
    public String main(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/getCars")
    public List<Car> getCars(){
        return carManager.getCarList();
    }

    @PostMapping("/addCar")
    public boolean addCar(@RequestBody Car car){
        return carManager.addCar(car);
    }
}
