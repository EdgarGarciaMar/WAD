/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgargarcia
 */
public class CategoriaDAO {

//    private static final String SQL_INSERT = "{call spinsertar(?,?)}";
//    private static final String SQL_INSERT = "insert sp_insertar(?,?)";
//    private static final String SQL_UPDATE = "";
//    private static final String SQL_DELETE = "";
//    private static final String SQL_READ = "";
//    private static final String SQL_ALL = "";
    /**
     * CREATE OR REPLACE PROCEDURE public.spinsertarcategoria(nombre character
     * varying, descripcion character varying) LANGUAGE sql AS $procedure$
     * insert into Categoria (nombreCategoria, descripcionCategoria) values
     * (nombre, descripcion); $procedure$ ; CREATE OR REPLACE PROCEDURE
     * public.spactualizarcategoria(nombre character varying, descripcion
     * character varying, id integer) LANGUAGE sql AS $procedure$ update
     * Categoria set nombreCategoria = nombre, descripcionCategoria =
     * descripcion where idCategoria = id; $procedure$ ; CREATE OR REPLACE
     * FUNCTION seleccionarCategoria(in id int) RETURNS TABLE(idcategoria
     * integer, nombrecategoria character varying, descripcioncategoria
     * character varying) LANGUAGE sql AS $function$ SELECT * FROM Categoria
     * where idCategoria = id; $function$
     *
     * create or replace procedure spEliminarCategoria (in id int) language sql
     * as $$ delete from Categoria where idCategoria= id; $$
     *
     */
    private static final String SQL_INSERT = "call spInsertarCategoria(?, ?)";
    public static final String SQL_UPDATE = "call spActualizarCategoria(?,?,?)";
    public static final String SQL_DELETE = "call spEliminarCategoria(?)";
    public static final String SQL_READ = "select * from seleccionarCategoria(?)";
    public static final String SQL_ALL = "select * from seleccionaTodoCategoria()";

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

    public void create(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombrecategoria());
            ps.setString(2, dto.getEntidad().getDescripcioncategoria());
            ps.executeLargeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombrecategoria());
            ps.setString(2, dto.getEntidad().getDescripcioncategoria());
            ps.setInt(3, dto.getEntidad().getIdcategorria());
            ps.executeLargeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdcategorria());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public CategoriaDTO read(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdcategorria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CategoriaDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdcategorria(rs.getInt("idcategorria"));
            dto.getEntidad().setNombrecategoria(rs.getString("nombrecategoria"));
            dto.getEntidad().setDescripcioncategoria(rs.getString("descripcioncategoria"));
            resultados.add(dto);
        }
        return resultados;
    }

    public List readall() throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_ALL);//READ_ALL
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();

        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdcategorria(1);
        //dto.getEntidad().setNombrecategoria("Electronicos");
        //dto.getEntidad().setDescripcioncategoria("Video Juegos");
        try {
            //dao.create(dto);
            //dao.create(dto);
            //dao.update(dto);
            System.out.println(dao.readall());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
