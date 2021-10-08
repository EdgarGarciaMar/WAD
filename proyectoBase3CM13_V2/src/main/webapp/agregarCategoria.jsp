<%-- 
    Document   : agregarCategoria
    Created on : 8 oct. 2021, 11:02:18
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar categoria</title>
    </head>
    <body>
        <%
            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setNombrecategoria(request.getParameter("txtNombre"));
            dto.getEntidad().setDescripcioncategoria(request.getParameter("txtDescripcion"));
            dao.create(dto);
            response.sendRedirect("lista_de_categorias.jsp");
        %>
    </body>
</html>
