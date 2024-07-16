package org.local.controller;

import org.local.models.Duenio;
import org.local.models.Mascota;
import org.local.models.RegistroMascota;
import org.local.repository.DuenioRepository;
import org.local.repository.MascotaRepository;

public class PersistenceControl {

    MascotaRepository mascotaRepository = new MascotaRepository();
    DuenioRepository duenioRepository = new DuenioRepository();


    public void save(RegistroMascota registroMascota) {

        Duenio duenio = new Duenio();
        duenio.setNombreDuenio(registroMascota.getNombreDuenio());
        duenio.setTelefono(registroMascota.getTelefono());

        Mascota mascota = new Mascota();
        mascota.setNombreMascota(registroMascota.getNombreMascota());
        mascota.setRaza(registroMascota.getRaza());
        mascota.setColor(registroMascota.getColor());
        mascota.setAlergico(registroMascota.getAlergico());
        mascota.setAtencionEspecial(registroMascota.getAtencionEspecial());
        mascota.setObservaciones(registroMascota.getObservaciones());
        mascota.setDuenio(duenio);

        duenioRepository.addDuenio(duenio);
        mascotaRepository.addMascota(mascota);
        mascotaRepository.close();
        duenioRepository.close();
    }
}
