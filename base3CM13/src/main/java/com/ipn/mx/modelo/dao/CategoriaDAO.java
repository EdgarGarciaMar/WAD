/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author edgargarcia
 */
public class CategoriaDAO {
    private static final String SQL_INSERT="insert into Categoria (nombrecategoria, descripcioncategoria) values (?, ?)";
    private static final String SQL_UPDATE="update Categoria set nombrecategoria = ?, descripcioncategoria = ? where idcategorria = ?";
    private static final String SQL_DELETE="delete from Categoria where idcategorria = ?";
    private static final String SQL_READ="select idcategorria, nombrecategoria, descripcioncategoria from Categoria where idcategorria = ?";
    private static final String SQL_ALL="select idcategorria, nombrecategoria, descripcioncategoria from Categoria";

    private Connection conexion;

    private void conectar(){
    String user ="postgres";
    String pwd="1234";
    String url="jdbc:postgresql://localhost:5432/Base3CM13";
    String pgDriver="org.postgresql.Driver";
    try{
        Class.forName(pgDriver);
        conexion= DriverManager.getConnection(url,user,pwd);
    }
    catch (Exception e){
        e.printStackTrace();
    }
}
}

