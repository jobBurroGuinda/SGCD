<%-- 
    Document   : index
    Created on : 18-oct-2015, 1:09:37
    Author     : Job
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
    </head>
    <body>
         <form action='LoginS' method='POST'>
             <label>Nombre de usuario:</label>  <input type='text' name='username' required/><br>
             <label>Contraseña: </label> <input type='password' name='password' required/><br>
            <input type='submit' value='Entrar como administrador'/> <input type='submit' value='Registrar nuevo usuario dentista'/>
        </form>
    </body>
</html>
