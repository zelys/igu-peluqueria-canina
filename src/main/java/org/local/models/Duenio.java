package org.local.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "duenios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreDuenio;
    private String telefono;

    @OneToMany
    private List<Mascota> mascotas;
}
