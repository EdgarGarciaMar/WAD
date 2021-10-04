<%-- 
    Document   : eliminar
    Created on : 4 oct. 2021, 07:49:40
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar</title>
    </head>
    <body>
        <%
            CategoriaDAO dao= new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdcategorria(Integer.parseInt(request.getParameter("id")));
            dao.delete(dto);
        %>
    </body>
</html>
