package com.example.gestionbodega.DTO;

import lombok.Data;

@Data
public class ClienteDTO {

    public Integer id_cliente;
    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private int numero;

}
