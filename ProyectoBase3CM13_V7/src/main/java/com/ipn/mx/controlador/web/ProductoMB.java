/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.ipn.mx.controlador.web;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.entidades.Producto;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author edgargarcia
 */
@ManagedBean(name = "productoMB")
@SessionScoped
public class ProductoMB extends BaseBean implements Serializable {

    private final ProductoDAO dao = new ProductoDAO();
    private final CategoriaDAO catDAO = new CategoriaDAO();

    private Producto dto;
    private List<Producto> listaProducto;
    private List<Categoria> listaCategoria;

    /**
     * Creates a new instance of ProductoMB
     */
    public ProductoMB() {
    }

    public Producto getDto() {
        return dto;
    }

    public void setDto(Producto dto) {
        this.dto = dto;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    @PostConstruct
    public void init() {
        listaCategoria = new ArrayList();
        listaProducto = new ArrayList();
        listaCategoria = catDAO.readAll();
        listaProducto = dao.readAll();
    }

    public String preparedAdd() {
        dto = new Producto();
        setAccion(ACC_CREAR);
        return "/producto/productoForm?faces-redirect=true";
    }

    public String preparedUpdate() {
        setAccion(ACC_ACTUALIZAR);
        return "/producto/productoForm?faces-redirect=true";
    }
    
    public String preparedIndex(){
        init();
        return "/producto/listadoProductos?faces-redirect=true";
    }
    
    public Boolean validate(){
        boolean valido =true;
        //if(dto.getNombreProducto() == null)//checar validaciones
        return valido;
    }
    
    public String add(){
        Boolean Valido = validate();
        if(Valido){
            dao.create(dto);
            if(Valido){
                return preparedIndex();
            }
            else{
                return preparedAdd();
            }
        }
        else{
            return preparedAdd();
        }
    }
    
       public String update(){
        Boolean Valido = validate();
        if(Valido){
            dao.update(dto);
            if(Valido){
                return preparedIndex();
            }
            else{
                return preparedUpdate();
            }
        }
        else{
            return preparedUpdate();
        }
    }
       
       public String delete(){
           dao.delete(dto);
           return preparedIndex();
       }
       
       public void seleccionarProducto(ActionEvent event){
           String claveSel = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("claveSel");
           dto = new Producto();
           dto.setIdProducto(Integer.parseInt(claveSel));
           try {
               dto= dao.read(dto);
           } catch (Exception e) {
               e.printStackTrace();
           }
       
       }
}
