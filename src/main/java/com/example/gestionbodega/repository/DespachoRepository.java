package com.example.gestionbodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestionbodega.model.Despacho;

public interface DespachoRepository extends JpaRepository<Despacho,Integer>{
}