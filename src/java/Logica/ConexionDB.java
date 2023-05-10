/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Job
 */
public class ConexionDB {
    // Se inicializan las variables para conexión
    static Connection cn = null;
    static Statement st = null;
    static PreparedStatement ps = null;    
    static ResultSet rs = null;
    
    // Se inicializan las variables para el acceso a la DB
        // Indicamos el nombre del servidor de la base de datos
    private static String servidor = "localhost";
        // Introducimos el nombre de la DB
    private static String nombreBD =  "sgcd";
        // Escribimos el nombre de usuario de MySQL que vamos a usar
    private static String usuario = "root";
        // Introducimos la contraseña del usuario de MySQL
    static String contraseña = "t1nocota+";
    
    private boolean verificador = false;
    
    
    // El siguiente método servirá para realizar la conexión
    public void conectar(){
        try{
            // Especificamos el Driver a utilizar, en este caso será el JDBC de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // Agregamos el Driver, el nombre del servidor, el puerto y el nombre de la base de datos en el URL o ruta 
            String url = "jdbc:mysql://" + servidor + ":3306/" + nombreBD;
            // Le pasamos el URL, el nombre de usuario y contraseña de MySQL para realizar la conexión
            cn = DriverManager.getConnection(url, usuario, contraseña);
            
        }
        // Este error se presentaría si la aplicación no cuenta con la librería de MySQL que contiene el Driver
        catch(ClassNotFoundException ex){System.out.println("Se produjo un error de la url SQL");}
        catch(SQLException ex){String msg = "";// Esta excepción se produciría en caso de que alguno de los datos del gestor o le la DB sea incorrecto
            // El error 1049 significa que la base de datos especificada no existe
            if(ex.getErrorCode() == 1049)
            {
                msg = "La base de datos: "+nombreBD+" no existe";
            }
            // El error 1044 significa que el usuario especificado no existe
            else if(ex.getErrorCode() == 1044)
            {
                msg = "El usuario: "+usuario+" no existe";
            }
            // El error 1045 indica que la contraseña es incorrecta
            else if(ex.getErrorCode() == 1045)
            {
                msg = "Contraseña SQL incorrecta";
            }
            // Por último, el error cero significa que el servidor de base de datos está inactivo
            // Esto se podría presentar si no tenemos correctamente instalado a MySQL
            else if(ex.getErrorCode() == 0)
            {
                msg = "La coneccion con la base de datos no se puede realizar\nParece que el servidor de base de datos no esta activo";
            }
            // En caso de que se haya presentado alguno de estos errores con el gestor
            // se desplegará un mensaje con informando la situación
            JOptionPane.showMessageDialog(null, ex.getMessage(), msg, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public boolean Login(String username, String password) throws SQLException{
        // Si no se ha realizado la conexión con la base de datos la iniciamos
        if(cn == null) {
            conectar();
        }
     String csp = "";
     // Especificamos el comando SQL de la consulta
     // La tabla "vusuarios", en realidad es una vista o view que sirve para desplegar únicamente el nombre de usuario
     // y contraseña
     String sql = "select * from musuario where nom_usu='" + username + "' and psw_usu=password('" + password + "')";
         st = cn.createStatement();
         // Mandamos el comando al gestor
         rs = st.executeQuery(sql); 
         // Si el nombre de usuario y contraseña son correctos proseguimos con lo siguiente, de lo contrario 
                // el verificador tomará el valor de false, lo que indicará que alguno de los dos datos o los dos son incorrectos
         // Si todo salió bien buscamos todo lo que haya en la tabla...
         while(rs.next()){
             // ..., especificamente en el campo "id_prv" para asegurarnos si el usuario tiene algún privilegio
             // y "guardamos" lo que encontremos en la variable "csp"
             csp=rs.getString("id_prv");
         }
         // Verificamos que el usuario introducido sea el administrador, ya que por ahora sólo él puede acceder
            // si es así...
         if(csp.equals("1")){
                // El verificador tomará el valor de "true" para indicar que todos los datos son correctos y el usuario puede entrar
             verificador = true;
         }
         // De lo contrario..., si el nombre de usuario introducido no coincide con el registrado en la base de datos
         else{
             // El verificador tomará el valor de "false" para indicar que el nombre de usuario y/o contraseña es incorrecta y el usuario no puede entrar
             verificador = false;
         }
         // Devolvemos el valor del verificador
         return verificador;
    }
    
    
    public boolean NvoUsuarioDen(String username, String passw){
        if(cn == null) {
            conectar();
        }
        int r = 0, rST=0, rR, rC;
        String sql = null, sqlST, sqlR, sqlC=null;
        
        try{
            sqlST = "START TRANSACTION";
            ps = cn.prepareStatement(sqlST);
            rST= ps.executeUpdate();
        }catch(SQLException ex){System.out.println("sqlST");ex.printStackTrace();}
        
        try{
            sql = "insert into MUsuario (nom_usu, psw_usu, id_prv) values (?,password(?),3)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, passw);
            r = ps.executeUpdate();
        }catch(SQLException ex){System.out.println("sql1");ex.printStackTrace();}
        
        if(r != 0){
    // Si todo se guardó correctamente..., los cambios se hacen permanentes
                            try{
                                    sqlC = "COMMIT";
                                    ps = cn.prepareStatement(sqlC);
                                    rC= ps.executeUpdate();
                                }catch(SQLException ex){System.out.println("sqlC");ex.printStackTrace();}
                    verificador = true;
        }
        // De lo contrario...
        else{
                        try{
                                sqlR = "ROLLBACK";
                                ps = cn.prepareStatement(sqlR);
                                rR= ps.executeUpdate();
                            }catch(SQLException ex){System.out.println("sqlR");ex.printStackTrace();}
                        try{
                                    sqlC = "COMMIT";
                                    ps = cn.prepareStatement(sqlC);
                                    rC= ps.executeUpdate();
                                }catch(SQLException ex){System.out.println("sqlC");ex.printStackTrace();}
                    verificador = false;
        }     
        
        return verificador;
    }
    
    
    public int UltimoIDr() throws SQLException{
        int id=0;
         // Si no se ha realizado la conexión con la base de datos la iniciamos
        if(cn == null) {
            conectar();
        }
     String csp = "";
     String sql = "SELECT @last := LAST_INSERT_ID() AS ultimoID";
         st = cn.createStatement();
         // Mandamos el comando al gestor
         rs = st.executeQuery(sql); 
     while(rs.next()){
             // ..., especificamente en el campo "id_prv" para asegurarnos si el usuario tiene algún privilegio
             // y "guardamos" lo que encontremos en la variable "csp"
             csp=rs.getString("ultimoID");
         }
         // Verificamos que el usuario introducido sea el administrador, ya que por ahora sólo él puede acceder
            // si es así...
         if(!csp.equals("0")){
                // El verificador tomará el valor de "true" para indicar que todos los datos son correctos y el usuario puede entrar
             id = Integer.parseInt(csp);
         }
         else{
             id = 0;
         }
     
        
        
        return id;
    }
    
    
}
