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
@EqualsAndHashCode(of = "id")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreMascota;
    private String raza;
    private String color;
    @Column(columnDefinition = "TINYINT")
    private Boolean alergico;
    @Column(columnDefinition = "TINYINT")
    private Boolean atencionEspecial;
    @Column(columnDefinition = "TEXT")
    private String observaciones;

    private LocalDate fechaRegistro = LocalDate.now();
    private LocalDate fechaModificacion = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Duenio duenio;

    public void setAlergico(String alergico) {
        this.alergico = alergico.equalsIgnoreCase("SI");
    }

    public void setAtencionEspecial(String atencionEspecial) {
        this.atencionEspecial = atencionEspecial.equalsIgnoreCase("SI");
    }
}
