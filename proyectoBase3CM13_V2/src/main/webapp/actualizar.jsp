<%-- 
    Document   : actualizar
    Created on : 8 oct. 2021, 11:07:54
    Author     : edgargarcia
--%>

<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
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
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

            <%
                CategoriaDAO dao = new CategoriaDAO();
                CategoriaDTO dto = new CategoriaDTO();
                dto.getEntidad().setIdcategorria(Integer.parseInt(request.getParameter("id")));
                dto = dao.read(dto);
            %>

            <div class="mb-3"></div>
            <div class="card border-success">
                <div class="card-header">
                    <h1 class="text-primary text-center">Actualizar Categoria</h1>
                </div>
                <div class="card-body">
                    <form method="post" action="almacenarCambios.jsp">
                        <div class="mb-3">
                            <label class="form-label">Clave de la Categoria</label>
                            <input type="text" name="txtClave" id="txtClave" placeholder="Clave Categoria"
                                   required="required" maxlength="50" class="form-control" 
                                   value="<%= dto.getEntidad().getIdcategorria()%>"
                                   readonly="readonly"
                                   />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Nombre de la Categoria</label>
                            <input type="text" name="txtNombre" id="txtNombre" placeholder="Nombre Categoria"
                                   required="required" maxlength="50" class="form-control" 
                                   value="<%= dto.getEntidad().getNombrecategoria()%>"
                                   />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Descripcion de la Categoria</label>
                            <input type="text" name="txtDescripcion" id="txtDescripcion" placeholder="Descripcion Categoria"
                                   required="required" maxlength="50" class="form-control" 
                                   value="<%= dto.getEntidad().getDescripcioncategoria()%>"
                                   />
                        </div>
                        <button type="submit" class="btn btn-success">Actualizar Categoria</button>
                    </form>
                </div>
            </div>

        </div>

    </body>
</html>
