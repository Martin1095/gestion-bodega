package com.example.gestionbodega.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="despachos")

public class Despacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;

    private String estado;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="trabajador_id")
    private Trabajador trabajador;

}
