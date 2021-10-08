<%-- 
    Document   : nuevaCategoria
    Created on : 8 oct. 2021, 10:47:23
    Author     : edgargarcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Categoria</title>
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

            <div class="mb-3"></div>
            <div class="card border-success">
                <div class="card-header">
                    <h1 class="text-primary text-center">Datos de la Categoria</h1>
                </div>
                <div class="card-body">
                    <form method="post" action="agregarCategoria.jsp">
                        <div class="mb-3">
                            <label class="form-label">Nombre de la Categoria</label>
                            <input type="text" name="txtNombre" id="txtNombre"placeholder="Nombre Categoria"
                                   required="required" maxlength="50" class="form-control" />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Descripcion de la Categoria</label>
                            <input type="text" name="txtDescripcion" id="txtDescripcion"placeholder="Descripcion Categoria"
                                   required="required" maxlength="50" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-primary">Registrar Categoria</button>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
