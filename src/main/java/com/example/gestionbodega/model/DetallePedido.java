package com.example.gestionbodega.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_pedido;
    
    @Min(value = 1)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;


    @Min(value = 1)
    @Column(name = "precio_unitario", nullable = false)
    private double precio_unitario;

    @OneToMany
    @JoinColumn(name = "pedido")
    private List<Pedido> pedidos;

}
