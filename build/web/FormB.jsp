<%-- 
    Document   : FormB
    Created on : 19-oct-2015, 18:02:28
    Author     : Job
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja de dentistass</title>
    </head>
    <body>
        <h1>Baja de dentistas</h1>
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
            
            
                <form action="BajaD" method="post">
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
                            <input type="submit" value="Baja">
                        </td>
                    </tr>
                </table>
                </form>
            </center>
    </body>
</html>
