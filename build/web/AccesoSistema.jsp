<%-- 
    Document   : acceso  al  sistema
    Created on : 5/10/2012, 04:04:09 PM
    Author     : cpu1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pagina Acceso al Sistema</title>
</head>

<body>
<table width="100%" height="100%" border="0" >
  <tr>
    <th height="171" colspan="2" scope="col"><img src="Imagenes/hospital.jpg" width="936" height="243" /></th>
  </tr>
  <tr>
    <th width="22%" scope="row"><table width="100%" border="0">
      <tr>
        <th scope="col"><a href="QuienesSomos.jsp">Quienes somos <width="206" height="62" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="ubicacion.jsp">Ubicación <width="210" height="59" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="servicios.jsp">Servicios <width="206" height="60" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="DudasyComentarios.jsp">Dudas y comentarios <width="215" height="48" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="AccesoSistema.jsp">Acceso al sistema <width="215" height="53" /></a></th>
      </tr>
    </table></th>
      
<FONT FACE=TAHOMA COLOR=#000000> <CENTER> <H3> Ingrese tu Nombre de Usuario y Contraseña </H3> </CENTER> </FONT>

    <center>
    <td width="78%"><BLOCKQUOTE> <P ALIGN=CENTER>&nbsp; </P>
                <P ALIGN=CENTER>Ingresa tu Nombre de Usuario y Contraseña </P>
                <form action="LoginS" method="POST">
                Username:  <input type="text" name="username" /><br>
                Password:  <input type="password" name="password"/><br>
                <input type="submit" value="Enter"/> <input type="reset" value="CLEAR"/>
                </form>
      </td>
    </center>
  </tr>
</table>
</body>
</html>

