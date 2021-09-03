/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
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

    private static final String SQL_INSERT = "insert into Categoria (nombrecategoria, descripcioncategoria) values (?, ?)";
    private static final String SQL_UPDATE = "update Categoria set nombrecategoria = ?, descripcioncategoria = ? where idcategorria = ?";
    private static final String SQL_DELETE = "delete from Categoria where idcategorria = ?";
    private static final String SQL_READ = "select idcategorria, nombrecategoria, descripcioncategoria from Categoria where idcategorria = ?";
    private static final String SQL_ALL = "select idcategorria, nombrecategoria, descripcioncategoria from Categoria";

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
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
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
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
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
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdcategorria());
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

    public CategoriaDTO read(CategoriaDTO dto)throws SQLException{
        conectar();
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            ps=conexion.prepareStatement(SQL_READ);
            ps.setInt(1,dto.getEntidad().getIdcategorria());
            rs=ps.executeQuery();
            List resultados =obtenerResultados(rs);
            if(resultados.size()>0){
                return (CategoriaDTO) resultados.get(0);   
            }
            else{
                return null;
            }
        } finally {
            if(rs != null){
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

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while(rs.next()){
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdcategorria(rs.getInt("idCategorria"));
            dto.getEntidad().setNombrecategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcioncategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }
        return resultados;
    }
    
        public List readall ()throws SQLException{
        conectar();
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            ps=conexion.prepareStatement(SQL_ALL);//READ_ALL
            rs=ps.executeQuery();
            List resultados =obtenerResultados(rs);
            if(resultados.size()>0){
                return resultados;
            }
            else{
                return null;
            }
        } finally {
            if(rs != null){
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

        public static void main(String [] args){
            CategoriaDAO dao= new CategoriaDAO();
            
            CategoriaDTO dto= new CategoriaDTO();
            dto.getEntidad().setNombrecategoria("Electronicos");
            dto.getEntidad().setDescripcioncategoria("Video Juegos");
            try {
                dao.create(dto);
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
             
                
}
