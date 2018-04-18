/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.entidades.Producto;
import com.ipn.mx.utilerias.DBUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author asuncionez
 */
public class ProductoDAO {

    public void create(Producto producto) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void update(Producto producto) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        try {
            em.merge(producto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Producto producto) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        try {
            producto = (Producto) em.find(producto.getClass(),
                    producto.getIdProducto());

            em.remove(producto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public Producto read(Producto producto) {
        EntityManager em
                = DBUtil.getEmFactory().
                        createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        try {
            producto = (Producto) em.find(producto.getClass(),
                    producto.getIdProducto());
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return producto;
    }

    public List<Producto> readAll() {
        EntityManager em = DBUtil.
                getEmFactory().
                createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        List<Producto> resultados = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Producto.findAll");
            resultados = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return resultados;
    }

    public List<Producto> loadProductoPorCategoria(Categoria categoria) {
        EntityManager em = DBUtil.
                getEmFactory().
                createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        List<Producto> resultados = new ArrayList<>();
        try {
            categoria = em.find(Categoria.class, categoria.getIdCategoria());
            for (Producto producto : categoria.getProductoCollection()) {
                resultados.add(producto);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return resultados;

    }

    public Categoria readProductoAndShowCategoria(int idProducto) {
        EntityManager em = DBUtil.
                getEmFactory().
                createEntityManager();
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        List resultados = new ArrayList<>();
        Categoria c = null;
        try {
            Query q = em.createQuery("select p from Producto p where p.idProducto =:idProducto");
            q.setParameter("idProducto", idProducto);
            resultados = q.getResultList();
            Iterator it = resultados.iterator();
            while (it.hasNext()) {
                Producto p = (Producto) it.next();
                c = p.getIdCategoria();
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return c;
    }

}
