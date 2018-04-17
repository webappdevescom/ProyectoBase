/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asuncionez
 */
public class DBUtil {
    private static final 
            EntityManagerFactory EMF
            = Persistence.
                    createEntityManagerFactory("EjemploJPAPU");
    
    public static EntityManagerFactory getEmFactory(){
        return EMF;
    }
}






