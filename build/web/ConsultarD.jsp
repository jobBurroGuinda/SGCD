<%-- 
    Document   : ConsultarD
    Created on : 19/10/2015, 04:28:12 PM
    Author     : INFORMATICA1
--%>

<%@page import="Logica.Dentista"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta exitosa</title>
    </head>
    <body>
    <center>
        <h1>Consulta de dentistas</h1>
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
        <table border="1px">
            <% 
                List<Dentista> dentistas = (List) request.getAttribute("Dentistas");
            %>
            
            <tr>
                <td>
                    <b>ID del dentista:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getIdDentista());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Nombre(s):</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getNombre());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Apellidos:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getApellidos());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Cédula profesional:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getCedulaP());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Especialidad:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getEspecialidad());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Teléfono:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getTelefono());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Estado:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getEstado());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Municipio:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getMunicipio());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Colonia:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getColonia());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Calle:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getCalle());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Número exterior:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getNumExt());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Número interior:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getNumInt());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>ID del hospital:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getIdHospital());
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Hospital:</b>
                </td>
                <td>
                    <%
                        out.println(dentistas.get(0).getHospitalDom());
                    %>
                </td>
            </tr>
        </table>
    </center>
    </body>
</html>
