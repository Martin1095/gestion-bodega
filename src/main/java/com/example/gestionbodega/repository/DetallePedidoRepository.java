package com.example.gestionbodega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    // Buscar detalles de pedido por ID de pedido usando una consulta explícita
    @Query("SELECT d FROM DetallePedido d WHERE d.pedido.id_pedido = :id_pedido")
    List<DetallePedido> findByIdPedido(@Param("id_pedido") Integer id_pedido);
}