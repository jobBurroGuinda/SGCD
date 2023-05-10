<%-- 
    Document   : DudasyComentarios
    Created on : 5/10/2012, 04:01:54 PM
    Author     : cpu1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Página Dudas y Comentarios</title>
<style type="text/css">
<!--
.Estilo1 {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 24px;
}
.Estilo2 {font-size: 14px}
.Estilo3 {font-family: Arial, Helvetica, sans-serif; font-weight: bold; font-size: 14px; }
.Estilo4 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<table width="100%" height="100%" border="0" >
  <tr>
    <th height="171" colspan="2" scope="col"><img src="imagenes/logo.JPG" width="936" height="243" /></th>
  </tr>
  <tr>
    <th width="22%" scope="row"><table width="100%" border="0">
      <tr>
        <th scope="col"><a href="QuinesSomos.jsp><img src="imagenes/quienes  somos.JPG" width="196" height="54" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="ubicacion.jsp"><img src="imagenes/ubicacion.JPG" width="198" height="53" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="servicios.jsp"><img src="imagenes/servicios.JPG" width="194" height="54" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="DudasyComentarios.jsp"><img src="imagenes/dudas y comentarios.JPG" width="199" height="48" /></a></th>
      </tr>
      <tr>
        <th scope="row"><a href="AccesoSistema.jsp"><img src="imagenes/acceso  al sistema.JPG" width="215" height="53" /></a></th>
      </tr>
    </table></th>
	<BR>
	<BR>
	Enviarnos sus Comentarios y/o Cualquier Duda
    <td width=<form id="form1" name="form1" method="post" action="contacto.php">
<label></label>
<p align="center" class="Estilo1">     Envianos sus Comentarios y/o Cualquier Duda</p>
<p align="center" class="Estilo1 Estilo2">Correo Electronico</p>
<p align="center" class="Estilo1">
  <input type="text" name="nombre" id="nombre" />
</p>
<p align="center" class="Estilo3">Comentarios </p>
<p align="center" class="Estilo1">
  <textarea name="Comentario" rows="5" id="Comentario">






</textarea>




  </label>
  </p>
<p align="center" class="Estilo1">
    <input name="enviar" type="submit" value="Enviar Datos" />
    </form>
    <input name="Borrar Datos" type="submit" id="Borrar Datos" value="Borrar Datos" />
</p></td>
  </tr>
</table>
<p align="left"><span class="Estilo4"><a href="index.html"><img src="imagenes/inicio.gif" width="136" height="102" /></a></span></p>
</body>
</html>
