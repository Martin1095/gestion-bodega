package com.example.gestionbodega.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
