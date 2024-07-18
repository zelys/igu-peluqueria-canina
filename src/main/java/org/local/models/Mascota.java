package org.local.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mascotas")
@NoArgsConstructor
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
    private String observacion;

    private LocalDate fechaRegistro = LocalDate.now();
    private LocalDate fechaModificacion = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Duenio duenio;

    public Mascota(String nombreMascota, String raza, String color, Boolean alergico,
                   Boolean atencionEspecial, String observacion, LocalDate fechaRegistro,
                   LocalDate fechaModificacion, Duenio duenio
    ) {
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEspecial = atencionEspecial;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.duenio = duenio;
    }

    public void setDuenio(String own, String phone) {
        this.duenio = new Duenio(own, phone);
    }
}
