package com.bizon.main.controller;

import com.bizon.main.entity.Moto;
import com.bizon.main.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> getAll(){
        List<Moto> moto = motoService.finAll();
        if (moto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(moto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Moto> getUserBy(@PathVariable Long id){
        Moto moto = motoService.findbyId(id);
        if (moto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moto> update(@PathVariable Long id, @RequestBody Moto moto){
        Moto motoUpdate = motoService.findbyId(id);
        if (motoUpdate==null) {
            return ResponseEntity.notFound().build();
        }
        moto.setId(id);
        moto.setMarca(moto.getMarca());
        moto.setModelo(moto.getModelo());
        moto.setUserId(moto.getUserId());
        motoUpdate = motoService.saveMoto(moto);
        return ResponseEntity.ok(motoUpdate);
    }



    @PostMapping
    public ResponseEntity<Moto> save(@RequestBody Moto usuario){
        Moto MotoNew = motoService.saveMoto(usuario);
        return ResponseEntity.ok(MotoNew);
    }

    @GetMapping("/byUser/{user_id}")
    public ResponseEntity<List<Moto>> getByUserId(@PathVariable("user_id") Long user_id) {
        List<Moto> motos = motoService.findByUser_Id(user_id);
        if(motos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(motos);
    }





}
