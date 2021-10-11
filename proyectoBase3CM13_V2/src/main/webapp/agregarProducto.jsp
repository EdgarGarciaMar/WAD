<%-- 
    Document   : agregarProducto
    Created on : 11 oct. 2021, 15:10:52
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dto.ProductoDTO"%>
<%@page import="com.ipn.mx.modelo.dao.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Producto</title>
    </head>
    <body>
        <%
            ProductoDAO dao = new ProductoDAO();
            ProductoDTO dto = new ProductoDTO();

            dto.getEntidad().setNombreProducto(request.getParameter("txtNombreProducto"));
            dto.getEntidad().setDescripcionProducto(request.getParameter("txtDescripcionProducto"));
            dto.getEntidad().setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));
            dto.getEntidad().setPrecio(Float.valueOf(request.getParameter("txtPrecio")));
            dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimo")));
            dto.getEntidad().setClaveCategoria(Integer.parseInt(request.getParameter("txtClaveCategoria")));
            dao.create(dto);
            response.sendRedirect("ListaDeProductos.jsp");
        %>
    </body>
</html>
