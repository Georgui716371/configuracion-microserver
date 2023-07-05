package com.example.main.service;

import com.example.main.entity.Car;
import com.example.main.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;

    public List<Car> finAll(){
        return carRepository.findAll();
    }

    public Car findbyId (Long id){
        return carRepository.findById(id).orElse(null);
    }

    public Car saveCar( Car car){
        Car newCar=carRepository.save(car);
        return newCar;
    }


    public List<Car> findByUser_Id(Long user_id){
        return carRepository.findByUserId(user_id);
    }






}
