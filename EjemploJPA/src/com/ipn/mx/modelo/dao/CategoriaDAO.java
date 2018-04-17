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
   
    public static void create(Categoria categoria){
        EntityManager em = 
            DBUtil.getEmFactory().
                    createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(categoria);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }    
    }
    public static void update(Categoria categoria){
        EntityManager em = 
            DBUtil.getEmFactory().
                    createEntityManager();
        EntityTransaction transaction =
                em.getTransaction();
        transaction.begin();
        try{
            em.merge(categoria);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }    
    }
    public static void delete(Categoria categoria){
        EntityManager em = 
            DBUtil.getEmFactory().
                    createEntityManager();
        EntityTransaction transaction =
                em.getTransaction();
        transaction.begin();
        try{
            categoria =(Categoria)
                    em.find(categoria.getClass(),
                            categoria.getIdCategoria());
            em.remove(categoria);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }    
    }
    public static Categoria read(Categoria categoria){
        EntityManager em = 
            DBUtil.getEmFactory().
                    createEntityManager();
        EntityTransaction transaction =
                em.getTransaction();
        transaction.begin();
        try{
            categoria =(Categoria)
                    em.find(categoria.getClass(),
                            categoria.getIdCategoria());
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            em.close();
        }    
        return categoria;
    }
    
    public static List<Categoria> readAll(){
        EntityManager em =DBUtil.
                getEmFactory().
                createEntityManager();
        EntityTransaction transaction = 
                em.getTransaction();
        transaction.begin();
        List<Categoria> resultados = new ArrayList<>();
        try{
            Query q = em.createQuery("select c from Categoria c");
            resultados = q.getResultList();
            transaction.commit();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }
           return resultados;
    }
    
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(4);
//        categoria.setNombre("Video Juegos");
//        categoria.setDescripcionCategoria("Zona Gamer");
       // create(categoria);
        //update(categoria);
      //  delete(categoria);
        //System.out.println(read(categoria));
        System.out.println(readAll());
    }
    
}
