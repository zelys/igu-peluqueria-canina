package org.local.controller;

import org.local.models.Mascota;
import org.local.repository.MascotaRepository;

import java.util.List;

public class PersistenceControl {

    static MascotaRepository mascotaRepository = new MascotaRepository();

    public void save(Mascota mascota) {
        mascotaRepository.addMascota(mascota);
        mascotaRepository.close();
    }

    public List<Mascota> getDatos() {
        return mascotaRepository.findAllMascotas();
    }

    public void remove(Long row) {
        mascotaRepository.deleteMascota(row);
    }
}
