package com.example.gestionbodega.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RecepcionDTO {

    private Integer id;
    private LocalDate fecha;
    private String proveedor;
    private Integer cantidad;   

}
