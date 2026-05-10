package com.example.gestionbodega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    // Buscar detalles de pedido por ID de pedido
    List<DetallePedido> findByIdPedido(Integer id_pedido);
}
