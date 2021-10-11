<%-- 
    Document   : eliminarProducto
    Created on : 11 oct. 2021, 14:36:12
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dao.ProductoDAO"%>
<%@page import="com.ipn.mx.modelo.dto.ProductoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar producto</title>
    </head>
    <body>
        <%
            ProductoDAO dao = new ProductoDAO();
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
            dao.delete(dto);
            response.sendRedirect("ListaDeProductos.jsp");
        %>
    </body>
</html>
