/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.utilerias.DBUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author asuncionez
 */
public class CategoriaDAO {

    public void create(Categoria categoria) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void update(Categoria categoria) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        try {
            transaction.begin();
            em.merge(categoria);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Categoria categoria) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        try {
            transaction.begin();
            categoria = (Categoria) em.find(categoria.getClass(),
                    categoria.getIdCategoria());
            em.remove(categoria);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public Categoria read(Categoria categoria) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        try {
            transaction.begin();
            categoria = (Categoria) em.find(categoria.getClass(),
                    categoria.getIdCategoria());
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return categoria;
    }

    public List<Categoria> readAll() {
        EntityManager em = DBUtil.
                getEmFactory().
                createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        List<Categoria> resultados = new ArrayList<>();
        try {
            transaction.begin();
            Query q = em.createQuery("select c from Categoria c");
            resultados = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return resultados;
    }
}
