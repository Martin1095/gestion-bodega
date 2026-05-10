package com.example.gestionbodega.DTO;

import lombok.Data;

@Data
public class InventarioDTO {

    // ID del inventario
    private Integer id;

    // Nombre del artículo almacenado
    private String articulo;

    // Nombre de la bodega
    private String bodega;

    // Stock actual disponible
    private Integer stockActual;

    // Stock mínimo permitido
    private Integer stockMinimo;
}
