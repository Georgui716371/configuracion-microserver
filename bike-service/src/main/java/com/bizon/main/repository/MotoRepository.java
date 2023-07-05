package com.bizon.main.repository;

import com.bizon.main.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository <Moto, Long>{
    List<Moto> findByUserId(Long userId);

}
