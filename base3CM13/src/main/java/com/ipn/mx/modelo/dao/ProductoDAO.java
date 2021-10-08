/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ProductoDTO;
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
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into Producto (nombreProducto, descripcionProducto,precio,existencia,stockMinimo,claveCategoria) values (?, ?,?,?,?,?)";
    private static final String SQL_UPDATE = "update Producto set nombreProducto = ?, descripcionProducto = ?, precio = ?, existencia = ?, stockMinimo = ?, claveCategoria= ? where idProducto = ?";
    private static final String SQL_DELETE = "delete from Producto where idProducto = ?";
    private static final String SQL_READ = "select idProducto, nombreProducto, descripcionProducto ,precio,existencia, stockMinimo,claveCategoria from Producto where idProducto = ?";
    private static final String SQL_ALL = "select idProducto, nombreProducto, descripcionProducto ,precio,existencia, stockMinimo, claveCategoria from Producto";

    private Connection conexion;
//base local
//    private void conectar() {
//        String user = "postgres";
//        String pwd = "1234";
//        String url = "jdbc:postgresql://localhost:5432/Base3CM13";
//        String pgDriver = "org.postgresql.Driver";
//        try {
//            Class.forName(pgDriver);
//            conexion = DriverManager.getConnection(url, user, pwd);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private void conectar() {
        String user = "ybqzruvibzpgoe";
        String pwd = "2ddda5fb4e6fac08c526812dfb56a938ba2b073e53f3eec44b28e5b52693c596";
        String url = "jdbc:postgresql://ec2-34-205-14-168.compute-1.amazonaws.com:5432/dcfts8gj2hles0";
        String pgDriver = "org.postgresql.Driver";
        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setFloat(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getStockMinimo());
            ps.setInt(6, dto.getEntidad().getClaveCategoria());
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

    public void update(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setFloat(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getStockMinimo());
            ps.setInt(6, dto.getEntidad().getClaveCategoria());
            ps.setInt(7, dto.getEntidad().getIdProducto());
            ps.executeLargeUpdate();//ps.executeQuery();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            //ps.executeQuery();
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

    public List readALL() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_ALL);
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

    public ProductoDTO read(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (ProductoDTO) resultados.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return null;
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            ProductoDTO p = new ProductoDTO();
            p.getEntidad().setIdProducto(rs.getInt("idProducto"));
            p.getEntidad().setNombreProducto(rs.getString("nombreProducto"));
            p.getEntidad().setDescripcionProducto(rs.getString("descripcionProducto"));
            p.getEntidad().setPrecio(rs.getFloat("precio"));
            p.getEntidad().setExistencia(rs.getInt("existencia"));
            p.getEntidad().setStockMinimo(rs.getInt("stockMinimo"));
            p.getEntidad().setClaveCategoria(rs.getInt("claveCategoria"));
            resultados.add(p);
        }
        return resultados;
    }

    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setNombreProducto("pc");
        dto.getEntidad().setDescripcionProducto("pc de juegos");
        dto.getEntidad().setExistencia(100);
        dto.getEntidad().setPrecio(1000);
        dto.getEntidad().setStockMinimo(10);
        dto.getEntidad().setClaveCategoria(22);
        try {
            dao.create(dto);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
