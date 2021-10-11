<%-- 
    Document   : nuevoProducto
    Created on : 11 oct. 2021, 15:04:12
    Author     : edgargarcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo producto</title>
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

            <div class="mb-3"></div>
            <div class="card border-success">
                <div class="card-header">
                    <h1 class="text-primary text-center">Datos del Producto</h1>
                </div>
                <div class="card-body">
                    <form method="post" action="agregarProducto.jsp">
                        <div class="mb-3">
                            <label for="txtNombreProducto" class="form-label">Nombre del producto</label>
                            <input type="text" id="txtNombreProducto" name="txtNombreProducto" placeholder="Nombre del producto"
                                   class="form-control" required="required" />
                        </div>
                        <div class="mb-3">
                            <label for="txtDescripcionProducto" class="form-label">Descripcion del producto</label>
                            <input type="text" id="txtDescripcionProducto" name="txtDescripcionProducto" placeholder="Descripcion del producto"
                                   class="form-control" required="required" />
                        </div>
                        <div class="mb-3">
                            <label for="txtPrecio" class="form-label">Precio del producto</label>
                            <input type="text" id="txtPrecio" name="txtPrecio" placeholder="$0.00"
                                   class="form-control" required="required" />
                        </div>
                        <div class="mb-3">
                            <label for="txtExistencia" class="form-label">Existencia del producto</label>
                            <input type="number" id="txtExistencia" step="1" min="1" max="100" name="txtExistencia" placeholder="Existencia"
                                   class="form-control" required="required" />
                        </div>
                        <div class="mb-3">
                            <label for="txtStockMinimo" class="form-label">Stock del producto</label>
                            <input type="number" id="txtStockMinimo" step="1" min="10" max="100" name="txtStockMinimo" placeholder="Stock del producto"
                                   class="form-control" required="required" />
                        </div>

                        <div class="mb-3">
                            <label for="txtClaveCategoria" class="form-label">Categoria del producto</label>
                            <input type="number" id="txtClaveCategoria" name="txtClaveCategoria" placeholder="Categoria del producto"
                                   class="form-control" required="required" />
                        </div>
                        <button type="submit" class="btn btn-primary">Registrar Producto</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
