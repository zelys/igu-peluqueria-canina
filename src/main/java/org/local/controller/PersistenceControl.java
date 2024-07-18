package org.local.controller;

import org.local.models.Mascota;
import org.local.repository.MascotaRepository;

import java.util.List;

public class PersistenceControl {

    MascotaRepository mascotaRepository = new MascotaRepository();

    public PersistenceControl() {

    }

    public void save(Mascota mascota) {
        mascotaRepository.addMascota(mascota);
        mascotaRepository.close();
    }

    public List<Mascota> getDataList() {
        return mascotaRepository.findAllMascotas();
    }

    public Mascota getMascota(Long id) {
        return mascotaRepository.findMascota(id);
    }

    public void remove(Long row) {
        mascotaRepository.remove(row);
    }

    public void updateMascota(Mascota mascota) {
        mascotaRepository.update(mascota);
    }

    public void updateMascota(
            String namePet,
            String race,
            String color,
            Boolean allergic,
            Boolean attSpecial,
            String obs,
            String own,
            String phone
    ) {
    }
}
