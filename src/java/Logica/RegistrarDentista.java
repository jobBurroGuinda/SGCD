/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.ConexionDB.cn;
import static Logica.ConexionDB.ps;
import static Logica.ConexionDB.st;
import java.sql.SQLException;

/**
 *
 * @author Job
 */
public class RegistrarDentista {
    private boolean verificador = false;
    
    public boolean RegistrarD(int IDusuario, String nomDentista, String apeDentista, String cedula, int telefono, String fechaN,
            String estado, String municipio, String colonia, String calle, int numExt, int numInt, int idEspecialidad, int idHospital){
        // No no se ha realizado la conexión con la base de datos la hacemos
        if(cn == null) {
            ConexionDB cndb = new ConexionDB();
            cndb.conectar();
        }
        
            // Las variables "r" son para verificar el resultado de cada una de las inserciones u operacines
        int r1=0, r2=0, r3=0, r4=0, r5=0, rST=0, rR=0, rC=0;
            // las "sql" servirán para cada uno de los comandos SQL que se enviarán al gestor
        String sql1=null, sql2=null, sql3=null, sql4=null, sql5=null, sqlST=null, sqlR=null, sqlC=null;
        
        
        // Iniciamos la transacción
        try{
            sqlST = "START TRANSACTION";
            ps = cn.prepareStatement(sqlST);
            rST= ps.executeUpdate();
        }catch(SQLException ex){System.out.println("sqlST");ex.printStackTrace();}
        
        try{
            sql1 = "insert into cEstado (nom_est) values (?)";
            ps = cn.prepareStatement(sql1);
            ps.setString(1, estado);
            r1 = ps.executeUpdate();
        }
        // Como podemos ver, si ocurriera algún error, se nos desplegará un mensaje en los comandos
        // indicandonos que el problema ocurrió aquí, es decir, en el sql1
        catch(SQLException ex){System.out.println("sql1");ex.printStackTrace();}
        
            if(r1 != 0){
                try{
                    // Si todo salió bien, entonces ahora pasamos a almacenar datos en una tabla
                    // con claves foráneas, para lo cual es necesario que el ordenador recuerde cuál fue el último ID que se almacenó
                    // que vendría siendo el de la tabla CMarca (la anterior inserción)
                  //Por lo cual, el siguiente comando SQL nos servirá para que el ordenador lo recuerde y pueda usarse 
                        // con ayuda de la variable @last
                  String sql = "SELECT @last := LAST_INSERT_ID()";
                      st = cn.createStatement();
                  st.executeQuery(sql);
                  }catch(SQLException ex){ex.printStackTrace();}
                
                try{
                sql2 = "insert into Cmunicipio (nom_mun, id_est) values (?,@last)";
                ps = cn.prepareStatement(sql2);
                ps.setString(1, municipio);
                r2 = ps.executeUpdate();
            }catch(SQLException ex){System.out.println("sql2");ex.printStackTrace();}
                
                
                if(r2 != 0){
                    try{
                    String sql = "SELECT @last := LAST_INSERT_ID()";
                        st = cn.createStatement();
                        st.executeQuery(sql);
                    }catch(SQLException ex){ex.printStackTrace();}
                    
                    try{
                    sql3 = "insert into Cdomicilio (col_dom, cll_dom, nex_dom, nin_dom, id_mun) values (?,?,?,?,@last)";
                    ps = cn.prepareStatement(sql3);
                    ps.setString(1, colonia);
                    ps.setString(2, calle);
                    ps.setInt(3, numExt);
                    ps.setInt(4, numInt);
                    r3 = ps.executeUpdate();
                }catch(SQLException ex){System.out.println("sql3");ex.printStackTrace();}
                    
                    
                    if(r3 != 0){
                        try{
                        String sql = "SELECT @last := LAST_INSERT_ID()";
                            st = cn.createStatement();
                            st.executeQuery(sql);
                        }catch(SQLException ex){ex.printStackTrace();}
                        
                        try{
                        sql4 = "insert into mDentista (nom_den, ape_den, clp_den, ntl_den, fna_den, id_usu, id_esp, id_hos, id_dom)"+
                                                    " values (?,?,?,?,?,?,?,?,@last)";
                        ps = cn.prepareStatement(sql4);
                        ps.setString(1, nomDentista);
                        ps.setString(2, apeDentista);
                        ps.setString(3, cedula);
                        ps.setInt(4, telefono);
                        ps.setString(5, fechaN);
                        ps.setInt(6, IDusuario);
                        ps.setInt(7, idEspecialidad);
                        ps.setInt(8, idHospital);
                        r4 = ps.executeUpdate();
                    }catch(SQLException ex){System.out.println("sql4");ex.printStackTrace();}
                        
                        // Verificamos que todos los datos se hayan almacenado correctamente
                            if(r1!=0 & r2!=0 & r3!=0 & r4!=0){
                                // Si todo se guardó correctamente..., guardamos permanentemente los cambios con el comando SQL "COMMIT"
                                try{
                                        sqlC = "COMMIT";
                                        ps = cn.prepareStatement(sqlC);
                                        rC= ps.executeUpdate();
                                    }catch(SQLException ex){System.out.println("sqlC");ex.printStackTrace();}
                                // Y le pasamos el valor "true" al verificador para indicar que el registro se llevó a cabo exitosamente
                                verificador = true;
                            }
                            // else del dentista
                            else{
                                                // Borramos todo lo que se haya almacenado
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
                                // Y le damos el valor false al verificador para indicar que el bien no se pudo registrar
                                verificador = false;
                            }
                        
                    }
                    // else del domicilio
                    else{
                                // Borramos todo lo que se haya almacenado
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
                        // Y le damos el valor false al verificador para indicar que el bien no se pudo registrar
                        verificador = false;
                    }
                }
                // else del municipio
                else{
                        // Borramos todo lo que se haya almacenado
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
                    // Y le damos el valor false al verificador para indicar que el bien no se pudo registrar
                    verificador = false;
                }
                
                
            }
            // Else del estado
            else{
                // Borramos todo lo que se haya almacenado
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
                // Y le damos el valor false al verificador para indicar que el bien no se pudo registrar
                verificador = false;
            }
        
        return verificador;
    }
    
    
    
    
    // Este método sirve para darle un formato a los datos introducidos en las listas desplegables
    public String FormatoFecha(int año, int mes, int dia){
        String fecha = null;
        fecha = año + "-" + mes + "-" + dia;
        return fecha;
    }
    
}
