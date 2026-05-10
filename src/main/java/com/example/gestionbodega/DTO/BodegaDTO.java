package com.example.gestionbodega.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BodegaDTO {

    private Integer id;
    private String nombre;
    private String direccion;

}
