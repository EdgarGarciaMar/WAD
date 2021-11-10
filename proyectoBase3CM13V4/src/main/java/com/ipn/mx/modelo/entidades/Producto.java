/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author edgargarcia
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="Producto")
public class Producto  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private  String nombreProducto;
    private  String descripcionPorducto;
    private String precioProducto;
    private int existenciaProducto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Categoria idCategoria;
    /*
    idCategoria int,
    foreing key ( idCategoria) references Categoria (idCategoria).....
    */
    
}
