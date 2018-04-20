/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author asuncionez
 */
@Entity
@Table(name = "Producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precioUnitario;
    private int existencia;
    
    @JoinColumn(name = "idCategoria", 
            referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    /*
    @JoinColumn(name = "idCategoria" ==> hace referencia a 
        FOREIGN KEY (`idCategoria`) de la creacion de la tabla
       referencedColumnName = "idCategoria") ==> hace referencia a 
        REFERENCES `Categoria` (`idCategoria`)
    */
    private Categoria idCategoria;

    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idProducto").append(getIdProducto()).append("\n");
        sb.append("nombreProducto").append(getNombreProducto()).append("\n");
        sb.append("descripcionProducto").append(getDescripcionProducto()).append("\n");
        sb.append("precioUnitario").append(getPrecioUnitario()).append("\n");
        sb.append("existencia").append(getExistencia()).append("\n");
        sb.append("idCategoria").append(getIdCategoria().getIdCategoria()).append("\n");
        return sb.toString();
    }

  
    
    
}
