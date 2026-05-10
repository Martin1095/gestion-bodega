package com.example.gestionbodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestionbodega.model.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega,Integer>{
}