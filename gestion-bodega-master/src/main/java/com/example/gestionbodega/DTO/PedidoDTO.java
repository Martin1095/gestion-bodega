package com.example.gestionbodega.DTO;

import lombok.Data;

@Data
public class PedidoDTO {

    private Integer id_pedido;
    private String fecha_entrega;
    private String direccion_entrega;
    private String estado_pedido;
    private Integer id_cliente;

}
