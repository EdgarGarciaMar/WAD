<%-- 
    Document   : verDatos
    Created on : 4 oct. 2021, 07:57:54
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Datos</title>
    </head>
    <body>
        <%
            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdcategorria(Integer.parseInt(request.getParameter("id")));
            dto=dao.read(dto);
            if(dto !=null){
            
            }
            else{
            
            }
        %>
    </body>
</html>
