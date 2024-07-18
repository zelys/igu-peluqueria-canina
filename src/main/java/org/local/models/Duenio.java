package org.local.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "duenios")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreDuenio;
    private String telefono;

    public Duenio(String nombreDuenio, String telefono) {
        this.nombreDuenio = nombreDuenio;
        this.telefono = telefono;
    }
}
