package com.example.gestionbodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.Recepcion;

@Repository
public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {

}
