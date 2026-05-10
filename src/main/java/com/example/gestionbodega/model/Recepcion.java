package com.example.gestionbodega.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    private Integer id;

    // Fecha de recepción
    @Column(nullable = false)
    private LocalDate fecha;

    // Nombre del proveedor
    @NotBlank
    @Column(nullable = false)
    private String proveedor;

    // Cantidad recibida
    @Min(value = 1)
    @Column(nullable = false)
    private Integer cantidad;

}
