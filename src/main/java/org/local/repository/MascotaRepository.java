package org.local.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.local.models.Mascota;

public class MascotaRepository {

    private EntityManager em;
    private EntityManagerFactory eMF;

    public MascotaRepository() {
        this.eMF = Persistence.createEntityManagerFactory("peluCaninaPU");
        this.em = this.eMF.createEntityManager();
    }

    public MascotaRepository(String pu) {
        this.eMF = Persistence.createEntityManagerFactory(pu);
        this.em = this.eMF.createEntityManager();
    }

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

    public Mascota findMascota(Long id) {
        return this.em.find(Mascota.class, id);
    }

    public Mascota updateMascota(Mascota mascota) {
        this.em.getTransaction().begin();
        this.em.merge(mascota);
        this.em.getTransaction().commit();
        return mascota;
    }

    public void deleteMascota(Long id) {
        this.em.getTransaction().begin();
        Mascota mascota = this.em.find(Mascota.class, id);
        this.em.remove(mascota);
        this.em.getTransaction().commit();
    }

    public void close() {
        this.em.close();
        this.eMF.close();
    }
}
