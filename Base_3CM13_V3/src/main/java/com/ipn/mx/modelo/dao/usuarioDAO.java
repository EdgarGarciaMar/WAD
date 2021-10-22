/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author edgargarcia
 */
public class usuarioDAO {

    private static final String SQL_INSERT = "";
    public static final String SQL_UPDATE = "";
    public static final String SQL_DELETE = "";
    public static final String SQL_READ = "";
    public static final String SQL_ALL = "";

    private Connection conexion;

    public Connection conectar() {
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
        return conexion;
    }

}
