package com.example.gestionbodega.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.gestionbodega.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{

// Buscar artículos por marca
    List<Articulo> findByMarca(String marca);

}