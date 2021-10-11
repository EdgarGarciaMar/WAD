<%-- 
    Document   : index
    Created on : 27 sep. 2021, 08:09:02
    Author     : edgargarcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    </head>
    <body>
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
        <h1 align="center">Index de Proyecto base 3CM13_V2</h1>
        <ul>
            <li>Proyecto desarrollado con JSP's</li>
            <li>Crud de Categoría completo</li>
            <li>Crud de producto Completo</li>
        </ul>
    </body>
</html>
