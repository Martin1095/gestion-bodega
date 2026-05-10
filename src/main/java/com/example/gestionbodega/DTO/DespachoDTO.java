package com.example.gestionbodega.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DespachoDTO {

    // ID del despacho
    private Integer id;

    // Fecha del despacho
    private LocalDate fecha;

    // Destino del envío
    private String destino;

    // Estado actual del despacho
    private String estado;

    // Cantidad despachada
    private Integer cantidad;
}
