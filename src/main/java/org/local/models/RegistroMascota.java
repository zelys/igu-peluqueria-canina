package org.local.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistroMascota {
    private String nombreMascota;
    private String raza;
    private String color;
    private Boolean alergico;
    private Boolean atencionEspecial;
    private String nombreDuenio;
    private String telefono;
    private String observaciones;


    public void setAlergico(String alergico) {
        this.alergico = alergico.equalsIgnoreCase("SI");
    }

    public void setAtencionEspecial(String atencionEspecial) {
        this.atencionEspecial = atencionEspecial.equalsIgnoreCase("SI");
    }

}
