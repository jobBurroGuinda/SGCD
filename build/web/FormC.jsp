<%-- 
    Document   : Consultas
    Created on : 19/10/2015, 03:43:31 PM
    Author     : INFORMATICA1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta  de dentistas</title>
    </head>
    <body>
        <h1>Consulta de dentistas</h1>
        <center>
            <table>
                <tr>
                    <td>
                        <a href='FormA.jsp'>   Altas</a>
                    </td>
                    <td>
                            <a href='FormC'>   Consultas</a>
                    </td>
                    <td>
                                <a href='FormM'>   Actualizaciones</a>
                    </td>
                    <td>
                                <a href='FormB'>   Bajas</a>
                    </td>
                </tr>
            </table>
            
            
            <br/><br/><br/><br>
            
            
                <form action="BuscarD" method="post">
                <table>
                    <tr>
                        <td>
                            <label>Cédula profesional: </label>
                        </td>
                        <td>
                            <input type="text" name="cedulaProfesional" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            
                        </td>
                        <td>
                            <input type="submit" value="Buscar">
                        </td>
                    </tr>
                </table>
                </form>
            </center>
            
    </body>
</html>
