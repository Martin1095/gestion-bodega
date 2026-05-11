package com.example.gestionbodega.DTO;

import java.time.LocalDate;
import lombok.Data;

@Data
public class RecepcionDTO {

    private Integer id;
    private LocalDate fecha;
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
