<%-- 
    Document   : ListaDeProductos
    Created on : 10 oct. 2021, 11:00:42
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dto.ProductoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.modelo.dao.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de productos</title>
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
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>

            <div class="card border-primary">
                <div class="card-header">
                    <h1>Lista de Productos</h1>
                    <div class="card card-body text-primary">
                        <table>
                            <tr>
                                <th>Clave producto</th>


                                <th>Nombre Producto</th>

                                <th>Descripcion Producto</th>

                                <th>Precio</th>

                                <th>Existencia</th>

                                <th>Stock</th>

                                <th>Precio</th>

                                <th>Eliminar</th>

                                <th>Clave de la categoria</th>
                            </tr>

                            <%

                                ProductoDAO daop = new ProductoDAO();
                                List lista = daop.readALL();
                                for (int i = 0; i < lista.size(); i++) {
                                    ProductoDTO PRO = (ProductoDTO) lista.get(i);
                            %>

                            <tr>
                                <td>
                                    <a href="verDatosProducto.jsp?id=<%= PRO.getEntidad().getIdProducto()%>" class="btn btn-warning"><%= PRO.getEntidad().getIdProducto()%></a>
                                </td>
                                <td>
                                    <%=PRO.getEntidad().getNombreProducto()%>
                                </td>
                                <td>
                                    <%=PRO.getEntidad().getDescripcionProducto()%>
                                </td>
                                <td>
                                    <%=PRO.getEntidad().getPrecio()%>
                                </td>
                                <td>
                                    <%=PRO.getEntidad().getExistencia()%>
                                </td>
                                <td>
                                    <%=PRO.getEntidad().getStockMinimo()%>
                                </td>
                                <td>
                                    <%=PRO.getEntidad().getClaveCategoria()%>
                                </td>
                                <td>
                                    <a href="eliminarProducto.jsp?id=<%=PRO.getEntidad().getIdProducto()%>" class="btn btn-danger">Eliminar</a>
                                </td>
                                <td>
                                    <a href="actualizarProducto.jsp?id=<%=PRO.getEntidad().getIdProducto()%>" class="btn btn-success">Actualizar</a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                    <a href="nuevoProducto.jsp" class="btn btn-primary">Nuevo</a>
                </div>
            </div>
        </div>
    </body>
</html>
