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
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into Producto (nombreProducto, descripcionProducto,precio,existencia,claveCategoria) values (?, ?,?,?,?)";
    private static final String SQL_UPDATE = "update Producto set nombreProducto = ?, descripcionProducto = ?, precio = ?, existencia = ?, claveCategoria= ? where idProducto = ?";
    private static final String SQL_DELETE = "delete from Producto where idProducto = ?";
    private static final String SQL_READ = "select idProducto, nombreProducto, descripcionProducto ,precio,existencia,claveCategoria from Producto where idProducto = ?";
    private static final String SQL_ALL = "select idProducto, nombreProducto, descripcionProducto from Producto";

    private Connection conexion;

    private void conectar() {
        String user = "postgres";
        String pwd = "1234";
        String url = "jdbc:postgresql://localhost:5432/Base3CM13";
        String pgDriver = "org.postgresql.Driver";
        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
