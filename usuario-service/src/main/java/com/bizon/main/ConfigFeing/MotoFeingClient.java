package com.bizon.main.ConfigFeing;


import com.bizon.main.models.Car;
import com.bizon.main.models.Moto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "moto-service", url = "http://localhost:8003/moto")
public interface MotoFeingClient {

    @RequestMapping(method = RequestMethod.POST, value = "")
    Moto saveMoto(@RequestBody Moto car);

}
