/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.graficaDTO;
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
public class graficaDAO {

    private Connection conexion;
    private static final String SQL_GRAFICAR = "select nombrecategoria, count(*) as cantidad from categoria inner join producto on categoria.idcategorria = producto.clavecategoria group by categoria.nombrecategoria;";

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

    public List graficarproductosporcategoria() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(SQL_GRAFICAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                graficaDTO dto = new graficaDTO();
                dto.setNombreCategoria(rs.getString("nombrecategoria"));
                dto.setCantidad(rs.getInt("cantidad"));
                lista.add(dto);

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
        return lista;
    }

    public static void main(String[] args) {
        graficaDAO dao = new graficaDAO();
        
        try {
            System.out.println(dao.graficarproductosporcategoria());
        } catch (SQLException ex) {
            Logger.getLogger(graficaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
