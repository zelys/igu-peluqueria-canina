package org.local.controller;

import org.local.models.Mascota;

import java.util.List;

public class Controller {

    PersistenceControl control = new PersistenceControl();

    // CREAR REGISTRO MASCOTA
    public void saveMascota(String namePet, String race, String color, Boolean allergic, Boolean attSpecial, String obs, String own, String phone) {
        Mascota mascota = new Mascota();
        mascota.setNombreMascota(namePet);
        mascota.setRaza(race);
        mascota.setColor(color);
        mascota.setAlergico(allergic);
        mascota.setAtencionEspecial(attSpecial);
        mascota.setObservacion(obs);
        mascota.setDuenio(own, phone);
        control.save(mascota);
    }

    // TRAER MASCOTA SEGÚN ID
    public Mascota findMascotaById(Long id) {
        return control.findById(id);
    }

    // ACTUALIZAR MASCOTA
    public void updateMascota(Mascota mascota, String namePet, String race, String color, Boolean allergic, Boolean attSpecial, String obs, String own, String phone) {
        mascota.setNombreMascota(namePet);
        mascota.setRaza(race);
        mascota.setColor(color);
        mascota.setAlergico(allergic);
        mascota.setAtencionEspecial(attSpecial);
        mascota.setObservacion(obs);
        mascota.setDuenio(own, phone);
        control.updateMascota(mascota);
    }

    // ELIMINAR MASCOTA
    public void deleteMascota(Long rowId) {
        control.remove(rowId);
    }

    // LISTA DE MASCOTAS
    public List<Mascota> listMascotas() {
        return control.listMascotas();
    }
}
