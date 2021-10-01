/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web.producto;

import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgargarcia
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion.equals("listaDeProductos")) {
            listaDeProductos(request, response);
        } else {
            if (accion.equals("nuevo")) {
                nuevoProducto(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarProducto(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarProducto(request, response);
                    } else {
                        if (accion.equals("ver")) {
                            verProducto(request, response);
                        } else {
                            if (accion.equals("guarar")) {
                                almacenarProducto(request, response);
                            }
                        }
                    }
                }
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listaDeProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Productos</title>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body class='bg-info'>");
            out.println("<div class ='container'>");

            out.println("            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n"
                    + "                <div class=\"container-fluid\">\n"
                    + "                    <a class=\"navbar-brand\" href=\"#\">Menu</a>\n"
                    + "                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "                        <span class=\"navbar-toggler-icon\"></span>\n"
                    + "                    </button>\n"
                    + "                    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n"
                    + "                        <ul class=\"navbar-nav\">\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link active\" aria-current=\"page\" href=\"index.html\">Home</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"TablasDeMultiplicar\">Tablas de Multiplicar</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"MostrarDatosCategoria\">Listado de Categorías</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n"
                    + "                            </li>\n"
                    + "                        </ul>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </nav>");

            out.println("<table class='table table-striped'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<td>Clave Producto</td>");
            out.println("<td>Nombre</td>");
            out.println("<td>Descripcion Producto</td>");
            out.println("<td>Precio</td>");
            out.println("<td>Existencias</td>");
            out.println("<td>Stock</td>");
            out.println("<td>Categoria</td>");
            out.println("<td>Eliminar</td>");
            out.println("<td>Actualizar</td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            ProductoDAO dao = new ProductoDAO();
            List lista;
            try {
                lista = dao.readALL();
                for (int i = 0; i < lista.size(); i++) {
                    ProductoDTO dto = (ProductoDTO) lista.get(i);
                    out.println("<tr>");
                    out.println("<td><a href='ProductoController?accion=ver&id=" + dto.getEntidad().getIdProducto() + "' class = 'btn btn-warning'>" + dto.getEntidad().getIdProducto() + "</a></td>");
                    out.println("<td>" + dto.getEntidad().getNombreProducto() + "</td>");
                    out.println("<td>" + dto.getEntidad().getDescripcionProducto() + "</td>");
                    out.println("<td>" + dto.getEntidad().getPrecio() + "</td>");
                    out.println("<td>" + dto.getEntidad().getExistencia() + "</td>");
                    out.println("<td>" + dto.getEntidad().getStockMinimo() + "</td>");
                    out.println("<td>" + dto.getEntidad().getClaveCategoria() + "</td>");
                    out.println("<td><a href='ProductoController?accion=eliminar&id=" + dto.getEntidad().getIdProducto() + "' class='btn btn-danger'>Eliminar</a></td>");
                    out.println("<td><a href='ProductoController?accion=actualizar&id=" + dto.getEntidad().getIdProducto() + "' class='btn btn-success'>Actualizar</a></td>");
                    out.println("</tr>");
                }
            } catch (SQLException ex) {
                lista = new ArrayList();
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("<br>");
            
            out.println("<a href='productoForm.html' class='btn btn-primary'>Agregar Producto</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher rd = request.getRequestDispatcher("productoForm.html");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();

        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        String msg = "";
        response.setContentType("text/html;charset=UTF-8");
        try {
            dao.delete(dto);
            msg = "Registro eliminado";
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<div>");
            out.println(msg);
            out.println("<br />");
            out.println("<a href='ProductoController?accion=listaDeProductos' class='btn btn-success'>Lista de productos</a>");
            out.println("</div>");
            out.println("");
        }
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Producto</title>");
            out.println("</head>");
            out.println("<body class='bg-info'>");
            out.println("<h1>Servlet ProductoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void verProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("<title>Ver Producto</title>");
            out.println("</head>");
            out.println("<body class='bg-info'>");
            out.println("<div class=\"container\">");
            out.println("<h1>Productos</h1><br>");
            ProductoDAO dao = new ProductoDAO();
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));

            try {
                dto = dao.read(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (dto != null) {
                out.println("<table class ='table table-striped'>");
                out.println("<tr><th>Clave del producto <td>" + dto.getEntidad().getIdProducto() + "</td></th></tr>");
                out.println("<tr><th>Nombre del producto <td>" + dto.getEntidad().getNombreProducto() + "</td></th></tr>");
                out.println("<tr><th>Descripcion del producto <td>" + dto.getEntidad().getDescripcionProducto() + "</td></th></tr>");
                out.println("<tr><th>Precio del producto <td>" + dto.getEntidad().getPrecio() + "</td></th></tr>");
                out.println("<tr><th>Existencia del producto <td>" + dto.getEntidad().getExistencia() + "</td></th></tr>");
                out.println("<tr><th>Stock <td>" + dto.getEntidad().getStockMinimo() + "</td></th></tr>");
                out.println("<tr><th>Categoria <td>" + dto.getEntidad().getClaveCategoria() + "</td></th></tr>");
                out.println("</table>");
                out.println("<a href='ProductoController?accion=listaDeProductos' class='btn btn-success'>Listado de Productos</a>");
                out.println("</div>");
            } else {
                out.println("<div class='container'>");
                out.println("<p>Vacio</p>");
                out.println("<a href='ProductoController?accion=listaDeProductos' class='btn btn-primary'>Listado de Productos</a>");
                out.println("</div>");
            }

            out.println("</body>");
            out.println("</html>");
        }

    }

    private void almacenarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Estatus Producto</title>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body class='bg-info'>");
            out.println("<h1 align='center'>Producto</h1><br>");
            ProductoDAO dao = new ProductoDAO();
            ProductoDTO dto = new ProductoDTO();

            dto.getEntidad().setNombreProducto(request.getParameter("txtNombreProducto"));
            dto.getEntidad().setDescripcionProducto(request.getParameter("txtDescripcionProducto"));
            dto.getEntidad().setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));
            dto.getEntidad().setPrecio(Float.valueOf(request.getParameter("txtPrecio")));
            dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimo")));
            dto.getEntidad().setClaveCategoria(Integer.parseInt(request.getParameter("txtClaveCategoria")));


            try {
                dao.create(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<br>");
            out.println("<a align=\"center\" href='ProductoController?accion=listaDeProductos' class='btn btn-primary'>Lista de Productos</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
