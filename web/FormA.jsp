<%-- 
    Document   : FormA
    Created on : 19/10/2015, 02:58:36 PM
    Author     : INFORMATICA1
--%>

<%@page import="Logica.Hospital"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Dentista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de nuevos dentistas</h1>
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
            <form action='NvoDentista' method='POST'>
            <table>
                <tr>
                    <td>
                        <label>ID del usuario dentista:</label>
                    </td>
                    <td>
                        <input type='number' name='idUsuarioD' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Nombre:</label>
                    </td>
                    <td>
                        <input type='text' name='nombre' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Apellidos:</label>
                    </td>
                    <td>
                        <input type='text' name='apellidos' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Cédula profesional:</label>
                    </td>
                    <td>
                        <input type='text' name='cedula' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Teléfono:</label>
                    </td>
                    <td>
                        <input type='tel' name='telefono' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>fecha de nacimiento:</label>");
                    </td>
                    <td>
                        <select name='dia'>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='7'>7</option>
                            <option value='8'>8</option>
                            <option value='9'>9</option>
                            <option value='10'>10</option>
                            <option value='11'>11</option>
                            <option value='12'>12</option>
                            <option value='13'>13</option>
                            <option value='14'>14</option>
                            <option value='15'>15</option>
                            <option value='16'>16</option>
                            <option value='17'>17</option>
                            <option value='18'>18</option>
                            <option value='19'>19</option>
                            <option value='20'>20</option>
                            <option value='21'>21</option>
                            <option value='22'>22</option>
                            <option value='23'>23</option>
                            <option value='24'>24</option>
                            <option value='25'>25</option>
                            <option value='26'>26</option>
                            <option value='27'>27</option>
                            <option value='28'>28</option>
                            <option value='29'>29</option>
                            <option value='30'>30</option>
                            <option value='31'>31</option>
                        </select>
                        <select name='mes'>
                            <option value='1'>Enero</option>
                            <option value='2'>Febrero</option>
                            <option value='3'>Marzo</option>
                            <option value='4'>Abril</option>
                            <option value='5'>Mayo</option>
                            <option value='6'>Junio</option>
                            <option value='7'>Julio</option>
                            <option value='8'>Agosto</option>
                            <option value='9'>Septiembre</option>
                            <option value='10'>Octubre</option>
                            <option value='11'>Noviembre</option>
                            <option value='12'>Diciembre</option>
                        </select>
                        <input type='number' min='1920' max='2000' name='year' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Estado:</label>
                    </td>
                    <td>
                        <input type='text' name='estado' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Municipio:</label>
                    </td>
                    <td>
                        <input type='text' name='municipio' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Colonia:</label>
                    </td>
                    <td>
                        <input type='text' name='colonia' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Calle:</label>
                    </td>
                    <td>
                        <input type='text' name='calle' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Num. Exterior:</label>
                    </td>
                    <td>
                        <input type='number' name='numExt' required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Num. Interior:</label>
                    </td>
                    <td>
                        <input type='number' name='numInt' />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Especialidad:</label>
                    </td>
                    <td>
                        <select name='especialidad'>
                            <%
                                List<Dentista> especialidades = new ArrayList();
                                Dentista d = new Dentista();
                                especialidades = d.Vespecialidades();
                                int Nespecialidades = especialidades.size();
                                    for(int i=0 ; i<Nespecialidades ; i++){
                                        out.println("<option value='" + especialidades.get(i).getIdEspecialidad()+"'>" + especialidades.get(i).getEspecialidad() + "</option>");
                                    }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Hospital:</label>
                    </td>
                    <td>
                        <select name='hospital'>
                            <%
                                List<Hospital> hospitales = new ArrayList();
                                hospitales = d.Vhospitales();
                                int Nhospitales = hospitales.size();
                                    for(int i=0 ; i<Nhospitales ; i++){
                                        out.println("<option value='" + hospitales.get(i).getIdHospital()+"'>" + hospitales.get(i).getHospitalDom() + "</option>");
                                    }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                    <td>
                        <br>
                        <input type='submit' value='Registrar'>
                    </td>
                </tr>
                
            </table>
            </form>     
        </center>
    </body>
</html>
