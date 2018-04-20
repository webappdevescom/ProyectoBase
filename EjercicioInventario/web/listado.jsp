<%-- 
    Document   : listado
    Created on : 18/04/2018, 04:01:23 PM
    Author     : asuncionez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Id Categoria</th>
                <th>Nombre Categoria</th>
                <th>Descripción Categoria</th>
            </tr>
            <c:forEach var="categorias"
                       items="${listaDeCategorias}">
                <tr>
                    <td>
                        <c:out value="${categorias.idCategoria}"/>
                    </td>
                    <td>
                        <c:out value="${categorias.nombreCategoria}"/>
                    </td>
                    <td>
                        <c:out value="${categorias.descripcionCategoria}"/>
                    </td>
                    <td>
                        <a href="CategoriaServlet?accion=eliminar&id=${categorias.idCategoria}">
                            eliminar
                        </a>
                    </td>
                    <td>
                        <a href="CategoriaServlet?accion=actualizar&id=${categorias.idCategoria}">
                            actualizar
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
