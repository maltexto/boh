package dev.maltexto.boh.dao;

import java.util.List;

import dev.maltexto.boh.entity.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class FornecedorDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fornecedoresCRUD");

    public Fornecedor save(Fornecedor fornecedor) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecedor);
            entityManager.getTransaction().commit();
        }

        return fornecedor;
    }

    public Fornecedor findOneByCnpj(String cnpj) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager
                    .createQuery("from Fornecedor where cnpj = :cnpj", Fornecedor.class)
                    .setParameter("cnpj", cnpj)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Tratar caso o fornecedor não seja encontrado
        }
    }

    public Fornecedor findById(Long id) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.find(Fornecedor.class, id);
        }
    }

    public List<Fornecedor> findAll() {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.createQuery("from Fornecedor", Fornecedor.class)
                    .getResultList();
        }
    }

    public Fornecedor delete(Fornecedor fornecedor) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(fornecedor) ? fornecedor : entityManager.merge(fornecedor));
            entityManager.getTransaction().commit();
        }

        return fornecedor;
    }

    public Fornecedor update(Fornecedor fornecedor) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();

            Fornecedor fornecedorExistente = findById(fornecedor.getId());

            fornecedorExistente.setNome(fornecedor.getNome());
            fornecedorExistente.setCpnj(fornecedor.getCpnj());
            fornecedorExistente.setEmail(fornecedor.getEmail());
            fornecedorExistente.setComentario(fornecedor.getComentario());

            entityManager.getTransaction().commit();
        }

        return fornecedor;
    }
}