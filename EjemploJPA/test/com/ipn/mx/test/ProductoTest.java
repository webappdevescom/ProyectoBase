/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.test;

import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.entidades.Producto;

/**
 *
 * @author asuncionez
 */
public class ProductoTest {

    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        Producto p = new Producto();
        Categoria c = new Categoria();
        //Insertar un Registro 
        p.setNombreProducto("Iphone");
        p.setDescripcionProducto("Telefono muy caro");
        p.setExistencia(100);
        p.setPrecioUnitario(15000);

        c.setIdCategoria(2);
        p.setIdCategoria(c);
        dao.create(p);

        //Actualizar Registro
        p.setIdProducto(10);
        c.setIdCategoria(2);
        p.setIdCategoria(c);
        p.setNombreProducto("Horno de microondas");
        p.setDescripcionProducto("para las maruchana");
        p.setExistencia(200);
        p.setPrecioUnitario(1000);
        dao.update(p);

        // Eliminar Registro
        p.setIdProducto(10);
        dao.delete(p);

        // Buscar Registro
        p.setIdProducto(4);
        System.out.println(dao.read(p));

        //Buscar todos
        System.out.println(dao.readAll());

        //loadProductoPorCategoria 
        c.setIdCategoria(2);
        System.out.println(dao.loadProductoPorCategoria(c));

        System.out.println(dao.readProductoAndShowCategoria(8));

    }
}
