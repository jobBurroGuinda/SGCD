<%-- 
    Document   : newjsp
    Created on : 5/10/2012, 04:15:17 PM
    Author     : cpu1
--%>

<%@page contentType="text/html; charset=iso-8859-1"
session="true" language="java" import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page session="true"%>

<%
    String usuario="";
    HttpSession sesionOK = request.getSession();
    if(sesionOK.getAttribute("usuario")==null){
%>
    <jsp:forward page="index.jsp">
        <jsp:param  name="error" value="Es necesario identificarse"/>
    </jsp:forward>
<%
    }
    else{
        usuario= (String)sesionOK.getAttribute("usuario");
    }
%>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sesión del administrador</h1>
        <br><b>Bienvenido:</b><%=usuario%>
        <br><br><b>Menú de Administración</b>

    <li><a href="CrearNuevoUsuario.jsp"> Crear nuevo usuario</a>
    <li><a href="opc.jsp"> Borrar un usuario</a>
    <li><a href="opc.jsp"> Cambiar clave</a>
    <br>
    <li><a href="CerrarSesion"> Cerrar Sesión</a>
    </body>
</html>
