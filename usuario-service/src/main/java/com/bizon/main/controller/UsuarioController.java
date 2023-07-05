package com.bizon.main.controller;

import com.bizon.main.entity.Usuario;
import com.bizon.main.models.Car;
import com.bizon.main.models.Moto;
import com.bizon.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = usuarioService.getAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserBy(@PathVariable Long id){
        Usuario usuario = usuarioService.getUserById(id);
        if (usuario==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }


    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario usuarioNew = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioUpdate = usuarioService.getUserById(id);
        if (usuarioUpdate==null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        usuario.setName(usuario.getName());
        usuario.setLastname(usuario.getLastname());
        usuario.setEmail(usuario.getEmail());
        usuarioUpdate = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioUpdate);
    }


    @GetMapping("/car/{user_id}")
    public ResponseEntity<List<Car>> getUserByCar(@PathVariable("user_id") Long user_id) {
        Usuario usuario = usuarioService.getUserById(user_id);
        if (usuario==null) {
            return ResponseEntity.notFound().build();
        }

        List<Car> cars=  usuarioService.getCarsByUser(user_id);
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/moto/{user_id}")
    public ResponseEntity<List<Moto>> getUserByMotos(@PathVariable("user_id") Long user_id) {
        Usuario usuario = usuarioService.getUserById(user_id);
        if (usuario==null) {
            return ResponseEntity.notFound().build();
        }

        List<Moto> cars=  usuarioService.getMotosByUser(user_id);
        return ResponseEntity.ok(cars);
    }



    @PostMapping("/saveCar/{user_id}")
    public ResponseEntity<Car> saveCar(@PathVariable("user_id") Long user_id, @RequestBody Car car) {
        Car carNew = usuarioService.saveCar(user_id, car);
        return ResponseEntity.ok(carNew);
    }

    @PostMapping("/saveMoto/{user_id}")
    public ResponseEntity<Moto> saveMoto(@PathVariable("user_id") Long user_id, @RequestBody Moto moto) {
        Moto motoNew = usuarioService.saveMoto(user_id, moto);
        return ResponseEntity.ok(motoNew);
    }

}
