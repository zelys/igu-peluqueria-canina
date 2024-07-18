package org.local.repository;

import jakarta.persistence.*;
import org.local.models.Mascota;

import java.util.List;

public class MascotaRepository {

    private EntityManager em;
    private EntityManagerFactory eMF;
    private String pu = "peluCaninaPU";

    public MascotaRepository() {
        this.eMF = Persistence.createEntityManagerFactory(pu);
        this.em = this.eMF.createEntityManager();
    }

    // CREAR UN NUEVO REGISTRO
    public void addMascota(Mascota mascota) {
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            this.em.persist(mascota);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al añadir mascota", e);
        }
    }

    // ACTUALIZAR REGISTRO
    public void update(Mascota mascota) {
        this.em.getTransaction().begin();
        this.em.merge(mascota);
        this.em.getTransaction().commit();
    }

    // ELIMINAR REGISTRO
    public void remove(Long id) {
        this.em.getTransaction().begin();
        Mascota mascota = this.em.find(Mascota.class, id);
        this.em.remove(mascota);
        this.em.getTransaction().commit();
    }

    // TRAER TODOS LOS REGISTROS
    public List<Mascota> findAllMascotas() {
        return this.em.createQuery("from Mascota", Mascota.class).getResultList();
    }

    // TRAER REGISTRO ESPECIFICO
    public Mascota findMascota(Long id) {
        return this.em.find(Mascota.class, id);
    }

    public void close() {
        this.em.close();
        this.eMF.close();
    }
}
