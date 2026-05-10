package com.example.gestionbodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

}