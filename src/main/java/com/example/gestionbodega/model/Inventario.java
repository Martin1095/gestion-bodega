package com.example.gestionbodega.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="inventarios")

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_inventario;

    @Min(0)
    private Integer stockActual;

    @Min(1)
    private Integer stockMinimo;

    private String ubicacion;

    @ManyToOne
    @JoinColumn(name="bodega_id")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name="articulo_id")
    private Articulo articulo;

}
