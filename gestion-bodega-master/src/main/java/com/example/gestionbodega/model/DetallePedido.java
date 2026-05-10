package com.example.gestionbodega.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_pedido;
    
    @NotBlank(message = "La cantidad del producto es obligatoria")
    @Size(min = 1, message = "La cantidad del producto debe ser al menos 1")
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @NotBlank(message = "El precio unitario del producto es obligatorio")
    @Size(min = 1, message = "El precio unitario del producto debe ser mayor o igual a 1")
    @Column(name = "precio_unitario", nullable = false)
    private double precio_unitario;

}
