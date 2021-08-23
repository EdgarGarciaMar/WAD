/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author edgargarcia
 */
public class Categoria implements Serializable{
    private int idcategorria;
    private String nombrecategoria;
    private String descripcioncategoria;
    
    public Categoria(){
        
    }

    public int getIdcategorria() {
        return idcategorria;
    }

    public void setIdcategorria(int idcategorria) {
        this.idcategorria = idcategorria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public String getDescripcioncategoria() {
        return descripcioncategoria;
    }

    public void setDescripcioncategoria(String descripcioncategoria) {
        this.descripcioncategoria = descripcioncategoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idcategorria= ").append(getIdcategorria()).append("\n");
        sb.append("nombrecategoria= ").append(getNombrecategoria()).append("\n");
        sb.append("descripcioncategoria= ").append(getDescripcioncategoria()).append("\n");
        return sb.toString();
    }
    
    
}
