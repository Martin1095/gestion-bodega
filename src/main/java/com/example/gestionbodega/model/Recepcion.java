package com.example.gestionbodega.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recepciones")
public class Recepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_recepcion;

    // Fecha de recepción
    @Column(nullable = false)
    private Date fecha;


    // Cantidad recibida
    @Min(value = 1)
    @Column(nullable = false)
    private Integer cantidad;

    // Relacion con proveedor
    // Muchas recepciones pueden pertenecer a un proveedor
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    // Relacion con articulo
    // Muchas recepciones pueden pertenecer a un articulo
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    // Relacion con trabajador
    // El trabajador registra la recepcion
    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

}
