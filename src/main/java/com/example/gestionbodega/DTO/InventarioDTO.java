package com.example.gestionbodega.DTO;

import lombok.Data;

@Data
public class InventarioDTO {

    private Integer id_inventario;
    private Integer stockActual;
    private Integer stockMinimo;
    private String ubicacion;

    // Datos bodega
    private Integer bodegaId;
    private String nombreBodega;
    
    // Datos articulo
    private Integer articuloId;
    private String nombreArticulo;
}
