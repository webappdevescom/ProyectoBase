<%-- 
    Document   : categoriaForm
    Created on : 18/04/2018, 04:16:50 PM
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
        <fieldset>
            <legend>Datos de las Categorias</legend>
            <form name="frmDatos" method="post"
                  action="CategoriaServlet">
                <table>
                    <tr>
                        <td>
                            id Categoria
                        </td>
                        <td>
                            <input type="text"
                                   name="txtIdCategoria"
                                   value="<c:out value="${categoria.idCategoria}"/>"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nombre Categoria
                        </td>
                        <td>
                            <input type="text"
                                   name="txtNombre"
                                   value="<c:out value="${categoria.nombreCategoria}"/>"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            descripción Categoria
                        </td>
                        <td>
                            <input type="text"
                                   name="txtDescripcion"
                                   value="<c:out value="${categoria.descripcionCategoria}"/>"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="accion"
                                   value="guardar"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" 
                                   name="btnEnviar"
                                   value="Enviar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
    </body>
</html>
