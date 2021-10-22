/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author edgargarcia
 */
@Data
@NoArgsConstructor
public class usuario implements Serializable{
    private int idusuario;
    private String Nombre;
    private String Apellidop;
    private String Apellidom;
    private String email;
    private String nombreUsuario;
    private String claveUusuario;
    private String tipoUsuario;
    
}
