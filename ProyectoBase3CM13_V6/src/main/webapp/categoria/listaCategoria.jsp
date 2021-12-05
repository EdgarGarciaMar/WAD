<%-- 
    Document   : listaCategoria
    Created on : 29 nov. 2021, 07:53:12
    Author     : edgargarcia
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <s:property value="titulo"/>
        </title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link " aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-lin active" href="./categoria/listaCategoria.jsp">Lista de Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Pricing</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="card">
            <div class="card-header">
                <s:property value="titulo"/>
            </div>
            <div class="card-body table-responsive">
                <h4 class="card-title">
                    <a href="<s:url action="agregarCategoria"/>" class="btn btn-outline-success">
                        <s:property value="nuevo"/>
                    </a>
                </h4>
                <table class="table-stripped">
                    <tr>
                        <td>
                            <s:property value="idCategoria"/>
                        </td>
                        <td>
                            Nombre de la categoría
                        </td>
                        <td>
                            Descripción de la categoría
                        </td>
                        <td>
                            Eliminar
                        </td>
                        <td>
                            Actualizar
                        </td>
                    </tr>
                    <s:iterator value="categorias">
                        <tr>
                            <td>
                                <s:property value="idCategoria"/>
                            </td>
                            <td>
                                <s:property value="nombreCategoria"/>
                            </td>
                            <td>
                                <s:property value="descripcionCategoria"/>
                            </td>
                            <td>
                                <s:url action="eliminarCategoria" var="dto">
                                    <s:param name="categoria.idCategoria" value="%{idCategoria}"/>
                                </s:url>
                                <s:a href="%{dto}" class="btn btn-outline-danger">
                                    <s:property value="eliminar"/>
                                </s:a>
                            </td>
                            <td>
                                <s:url action="actualizarCategoria" var="dto">
                                    <s:param name="categoria.idCategoria" value="%{idCategoria}"/>
                                </s:url>
                                <s:a href="%{dto}" class="btn btn-outline-info">
                                    <s:property value="actualizar"/>
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>

            </div>
        </div>
    </body>
</html>
