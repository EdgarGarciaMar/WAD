/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *
 * @author edgargarcia
 */
@Data
@AllArgsConstructor
public class CategoriaDTO  implements Serializable{
    private Categoria entidad;
    public CategoriaDTO(){
        entidad = new Categoria();
    }
    
}
