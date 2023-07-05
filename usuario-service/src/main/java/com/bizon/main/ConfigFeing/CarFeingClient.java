package com.bizon.main.ConfigFeing;

import com.bizon.main.models.Car;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "car-service", url = "http://localhost:8002/car")
public interface CarFeingClient {

    @RequestMapping(method = RequestMethod.POST, value = "")
    Car saveCar(@RequestBody Car car);

}
