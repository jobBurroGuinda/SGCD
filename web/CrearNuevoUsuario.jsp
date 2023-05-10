<%-- 
    Document   : CrearNuevoUsuario
    Created on : 5/10/2012, 04:14:47 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Crear nuevo usuario</title>
    </head>
    <body>
        <h1>Listo para comenzar a crear usuarios!</h1>
    </body>
</html>