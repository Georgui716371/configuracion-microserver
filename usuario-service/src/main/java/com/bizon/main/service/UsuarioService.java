package com.bizon.main.service;

import com.bizon.main.ConfigFeing.CarFeingClient;
import com.bizon.main.ConfigFeing.MotoFeingClient;
import com.bizon.main.entity.Usuario;
import com.bizon.main.models.Car;
import com.bizon.main.models.Moto;
import com.bizon.main.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarFeingClient carFeingClient;

    @Autowired
    MotoFeingClient motoFeingClient;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){

        Usuario usuarioNew= usuarioRepository.save(usuario);
        return usuarioNew;
    }


    public List<Car> getCarsByUser(Long id){

        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byUser/"+id, List.class);
        return cars;
    }

    public List<Moto> getMotosByUser(Long id){

        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/byUser/"+id, List.class);
        return motos;
    }

    public Car saveCar (Long userId,Car car){
        car.setUserId(userId);
        Car carNew= carFeingClient.saveCar(car);
        return carNew;
    }

    public Moto saveMoto (Long userId,Moto moto){
        moto.setUserId(userId);
        Moto motoNew= motoFeingClient.saveMoto(moto);
        return motoNew;
    }







}
