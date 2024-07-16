package org.local.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mascotas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreMascota;
    private String raza;
    private String color;
    private Boolean alergico;
    private Boolean atencionEspecial;
    private String observaciones;

    private LocalDate fechaRegistro = LocalDate.now();
    private LocalDate fechaModificacion = LocalDate.now();

    @ManyToOne
    private Duenio duenio;
}
