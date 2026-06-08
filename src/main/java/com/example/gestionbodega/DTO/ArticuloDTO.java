package com.example.gestionbodega.DTO;

import lombok.Data;

@Data
public class ArticuloDTO {
    private Integer id_articulo;
    private String nombre;
    private String marca;
    private Integer stock;
    private Double precio;
}
