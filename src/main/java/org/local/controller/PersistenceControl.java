package org.local.controller;

import org.local.models.Mascota;
import org.local.repository.MascotaRepository;

import java.util.List;

public class PersistenceControl {

    MascotaRepository mascotaRepository = new MascotaRepository();

    public void save(Mascota mascota) {
        mascotaRepository.addMascota(mascota);
        mascotaRepository.close();
    }

    public List<Mascota> listMascotas() {
        return mascotaRepository.findAllMascotas();
    }

    public Mascota findById(Long id) {
        return mascotaRepository.findById(id);
    }

    public void remove(Long id) {
        mascotaRepository.remove(id);
    }

    public void updateMascota(Mascota mascota) {
        mascotaRepository.update(mascota);
    }

}
