package com.example.gestionbodega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbodega.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findById_pedido(Integer id_pedido);
}
