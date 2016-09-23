<%-- 
    Document   : muerto
    Created on : 23-sep-2016, 10:36:40
    Author     : Jeanette Berenice Reyes Rivera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muerto</title>
    </head>
    <body>
        <form action="MuertoController" method="post">
            <fieldset>
                <legend>Formulario del Muerto</legend>
                
                <div>
                <label for="idMuerto">Id Muerto:</label>
                <input type="text" name="idMuerto"
                       value="${muerto.idMuerto}"
                       readonly="readonly" 
                       placeholder="Id del muerto"/>
                </div>
                
                <div>
                <label for="edad">edad:</label>
                <input type="text" name="edad"
                       value="${muerto.edad}"
                       placeholder="Edad del muerto"/>
                </div>
                 
                <div>
                <label for="servicio">Servicio:</label>
                <input type="text" name="servicio"
                       value="${muerto.servicio}"
                       placeholder="Servicio"/>
                </div>
                
                <div>
                <label for="fechaIngreso">Fecha de ingreso:</label>
                <input type="text" name="fechaIngreso"
                       value="${muerto.fechaIngreso}"
                       placeholder="Fecha de ingreso"/>
                </div>
                       
                <div>
                <label for="fechaFallecido">Fecha de fallecido:</label>
                <input type="text" name="fechaFallecido"
                       value="${muerto.fechaFallecido}"
                       placeholder="Fecha de fallecido"/>
                </div>
                       
                <div>
                <label for="resultado">Resultado:</label>
                <input type="text" name="resultado"
                       value="${muerto.resultado}"
                       placeholder="Resultado"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
