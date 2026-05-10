package com.example.gestionbodega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    // Buscar pedidos por ID de pedido
    List<Pedido> findById_pedido(Integer id_pedido);
}
