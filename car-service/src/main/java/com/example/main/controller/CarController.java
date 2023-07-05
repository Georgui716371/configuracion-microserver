package com.example.main.controller;

import com.example.main.entity.Car;
import com.example.main.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> car = carService.finAll();
        if (car.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getUserBy(@PathVariable Long id){
        Car car = carService.findbyId(id);
        if (car==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car){
        Car carUpdate = carService.findbyId(id);
        if (carUpdate==null) {
            return ResponseEntity.notFound().build();
        }
        car.setId(id);
        car.setMarca(car.getMarca());
        car.setModelo(car.getModelo());
        car.setUserId(car.getUserId());
        carUpdate = carService.saveCar(car);
        return ResponseEntity.ok(carUpdate);
    }



    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car usuario){
        Car carNew = carService.saveCar(usuario);
        return ResponseEntity.ok(carNew);
    }

    @GetMapping("/byUser/{user_id}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("user_id") Long user_id) {
        List<Car> cars = carService.findByUser_Id(user_id);
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }



}
