<%-- 
    Document   : lista_muertos
    Created on : 23-sep-2016, 10:38:04
    Author     : Jeanette Berenice Reyes Rivera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Muertos</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id del muerto</th>
                <th>Edad</th>
                <th>Servicio</th>
                <th>Fecha Ingreso</th>
                <th>Fecha Fallecido</th>
                <th>Resultado</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="muerto" 
                           items="${muertos}">
                    <tr>
                        <td>${muerto.idMuerto}</td>
                        <td>${muerto.edad}</td>
                        <td>${muerto.servicio}</td>
                        <td>${muerto.fechaIngreso}</td>
                        <td>${muerto.fechaFallecido}</td>
                        <td>${muerto.resultado}</td>
                        <td><a href="MuertoController?action=cambiar&idMuerto=${muerto.idMuerto}">Cambiar</a></td>
                        <td><a href="MuertoController?action=borrar&idMuerto=${muerto.idMuerto}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="MuertoController?action=agregar">
                Agregar muerto
            </a>
        </p>
    </body>
</html>

