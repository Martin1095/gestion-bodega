package com.example.gestionbodega.model;

import com.example.gestionbodega.model.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;


    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre no puede tener más de 50 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 4, max = 50, message = "El apellido no puede tener más de 50 caracteres")
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @NotBlank(message = "El RUT es obligatorio")
    @Size(max = 12, message = "El RUT no puede tener más de 10 caracteres")
    @Column(name = "rut", nullable = false, unique = true, length = 10) 
    private String rut;

    @NotBlank(message = "El correo es obligatorio")
    @Size(max = 60, message = "El correo no puede tener más de 60 caracteres")
    @Column(name = "correo", nullable = false, length = 60)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 9, max = 9, message = "El teléfono debe tener exactamente 9 caracteres")
    @Column(name = "telefono", nullable = false, length = 9)
    private int telefono;

    @OneToMany
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;



}
