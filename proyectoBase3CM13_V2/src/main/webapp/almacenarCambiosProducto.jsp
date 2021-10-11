<%-- 
    Document   : almacenarCambiosProducto
    Created on : 11 oct. 2021, 15:32:30
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dto.ProductoDTO"%>
<%@page import="com.ipn.mx.modelo.dao.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Producto</title>
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
            dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("idxtx")));
            dao.update(dto);
            response.sendRedirect("ListaDeProductos.jsp");
        %>
    </body>
</html>
