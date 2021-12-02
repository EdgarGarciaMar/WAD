/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.actions;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.inject.Container;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edgargarcia
 */
public class categoriaActions extends ActionSupport {

    private Categoria categoria;
    private List<Categoria> categorias = new ArrayList<>();
    private final CategoriaDAO dao = new CategoriaDAO();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getNuevo() {
        return getText("categoria.boton.nuevo");
    }

    public String getEliminar() {
        return getText("categoria.boton.eliminar");
    }

    public String getActualizar() {
        return getText("categoria.boton.actualizar");
    }

    public String getGuardar() {
        return getText("categoria.boton.guardar");
    }

    public String getidCategoria() {
        return getText("gestionProducto.idCategoria");
    }

    public String getTitulo() {
        return getText("gestionProducto.titulo");
    }

    public String listaCategorias() {
        this.categorias = dao.readAll();
        return SUCCESS;
    }

    public String agregarCategoria() {
        categoria = new Categoria();
        return SUCCESS;
    }

    public String almacenarCategoria() {
        if (categoria.getIdCategoria() == null) {
            dao.create(categoria);
        } else {
            dao.update(categoria);
        }
        return SUCCESS;
    }

    public String eliminarCategoria() {
        categoria = dao.read(categoria);
        dao.delete(categoria);
        return SUCCESS;
    }

    public String actualizarCategoria() {
        categoria = dao.read(categoria);
        //dao.update(categoria);
        return SUCCESS;
    }
}
