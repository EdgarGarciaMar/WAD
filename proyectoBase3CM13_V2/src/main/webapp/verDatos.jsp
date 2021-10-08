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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="tablas_de_multi.jsp">Tablas de multiplicar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="lista_de_categorias.jsp">Listado de categorias</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

            <div class="card border-primary">
                <div class="card-header">
                    <h1>Lista de Categorias</h1>
                </div>

                <%
                    CategoriaDAO dao = new CategoriaDAO();
                    CategoriaDTO dto = new CategoriaDTO();
                    dto.getEntidad().setIdcategorria(Integer.parseInt(request.getParameter("id")));
                    dto = dao.read(dto);
                    if (dto != null) {
                %>
                <div class="card-body text-primary">
                    <table class="table table-striped">
                        <tr>
                            <th>
                                Clave Categoria
                            </th>
                            <td>
                                <%= dto.getEntidad().getIdcategorria()%>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Nombre Categoria
                            </th>
                            <td>
                                <%= dto.getEntidad().getNombrecategoria()%>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Descripcion Categoria
                            </th>
                            <td>
                                <%= dto.getEntidad().getDescripcioncategoria()%>
                            </td>
                        </tr>
                    </table>
                    <%
                        } else {
                            out.println("sin valores a mostrar");
                        }
                    %>


                </div>
                <a href="lista_de_categorias.jsp" class="btn btn-warning">Regresar</a>
            </div>


        </div>

    </body>
</html>
