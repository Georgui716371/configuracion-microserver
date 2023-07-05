package com.bizon.main.service;

import com.bizon.main.entity.Moto;
import com.bizon.main.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> finAll(){
        return motoRepository.findAll();
    }

    public Moto findbyId (Long id){
        return motoRepository.findById(id).orElse(null);
    }

    public Moto saveMoto( Moto car){
        Moto newBike=motoRepository.save(car);
        return newBike;
    }



    public List<Moto> findByUser_Id(Long user_id){
        return motoRepository.findByUserId(user_id);
    }


}
