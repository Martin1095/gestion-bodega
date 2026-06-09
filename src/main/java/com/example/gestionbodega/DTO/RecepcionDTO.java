package com.example.gestionbodega.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class RecepcionDTO {

    private Integer id;
    private Date fecha;
    private Integer cantidad;

    // Datos proveedor
    private Integer proveedorId;
    private String nombreProveedor;

    // Datos articulo
    private Integer articuloId;
    private String nombreArticulo;

    // Datos trabajador
    private Integer trabajadorId;
    private String nombreTrabajador;

}
