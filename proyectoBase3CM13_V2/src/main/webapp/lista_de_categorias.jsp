<%-- 
    Document   : lista_de_categorias
    Created on : 4 oct. 2021, 07:17:22
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de categorias</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
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
                                <li class="nav-item">
                                    <a class="nav-link" href="ListaDeProductos.jsp">Listado de Productos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="nuevaCategoria.jsp">Nueva Categoria</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="nuevoProducto.jsp">Nuevo Producto</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>

            <div class="card border-primary">
                <div class="card-header">
                    <h1>Lista de categorias</h1>
                    <div class="card card-body text-primary">
                        <table>
                            <tr>
                                <th>Clave categoria</th>


                                <th>Nombre categoria</th>

                                <th>Descripcion categoria</th>

                                <th>Eliminar</th>

                                <th>Actualizar</th>
                            </tr>

                            <%
                                CategoriaDAO dao = new CategoriaDAO();
                                List lista = dao.readall();
                                for (int i = 0; i < lista.size(); i++) {
                                    CategoriaDTO cat = (CategoriaDTO) lista.get(i);
                            %>

                            <tr>
                                <td>
                                    <a href="verDatos.jsp?id=<%= cat.getEntidad().getIdcategorria()%>" class="btn btn-warning"><%= cat.getEntidad().getIdcategorria()%></a>
                                </td>
                                <td>
                                    <%=cat.getEntidad().getNombrecategoria()%>
                                </td>
                                <td>
                                    <%=cat.getEntidad().getDescripcioncategoria()%>
                                </td>
                                <td>
                                    <a href="eliminar.jsp?id=<%=cat.getEntidad().getIdcategorria()%>" class="btn btn-danger">Eliminar</a>
                                </td>
                                <td>
                                    <a href="actualizar.jsp?id=<%=cat.getEntidad().getIdcategorria()%>" class="btn btn-success">Actualizar</a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                    <a href="nuevaCategoria.jsp" class="btn btn-primary">Nuevo</a>
                </div>
            </div>
        </div>
    </body>
</html>

