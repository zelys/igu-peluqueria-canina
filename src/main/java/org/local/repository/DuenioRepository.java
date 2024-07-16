package org.local.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.local.models.Duenio;

public class DuenioRepository {

    private EntityManager em;
    private EntityManagerFactory eMF;

    public DuenioRepository() {
        this.eMF = Persistence.createEntityManagerFactory("peluCaninaPU");
        this.em = this.eMF.createEntityManager();
    }

    public DuenioRepository(String pu) {
        this.eMF = Persistence.createEntityManagerFactory(pu);
        this.em = this.eMF.createEntityManager();
    }

    public void addDuenio(Duenio duenio) {
        EntityTransaction transaction = this.em.getTransaction();
        try {
            transaction.begin();
            this.em.persist(duenio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al añadir dueño", e);
        }
    }

    public Duenio findDuenio(Long id) {
        return this.em.find(Duenio.class, id);
    }

    public Duenio updateDuenio(Duenio duenio) {
        this.em.getTransaction().begin();
        this.em.merge(duenio);
        this.em.getTransaction().commit();
        return duenio;
    }

    public void deleteDuenio(Long id) {
        this.em.getTransaction().begin();
        Duenio duenio = this.em.find(Duenio.class, id);
        this.em.remove(duenio);
        this.em.getTransaction().commit();
    }

    public void close() {
        this.em.close();
        this.eMF.close();
    }
}
