/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.ConexionDB.cn;
import static Logica.ConexionDB.ps;
import static Logica.ConexionDB.rs;
import static Logica.ConexionDB.st;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Job
 */
public class Dentista implements Serializable {
    
    private int idDentista;
    private int idDomicilio;
    private int idUsuario;
    private int idEspecialidad;
    private int telefono;
    private int año;
    private int mes;
    private int dia;
    private String nombre;
    private String apellidos;
    private String cedulaP;
    private String domicilio;
    private String usuario;
    private String especialidad;
    private int idHospital;
    private String hospitalDom;
    private String fechaN;
    private String estado;
    private String municipio;
    private String colonia;
    private String calle;
    private int numExt;
    private int numInt;

    /**
     * @return the idDentista
     */
    public int getIdDentista() {
        return idDentista;
    }

    /**
     * @param idDentista the idDentista to set
     */
    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    /**
     * @return the idDomicilio
     */
    public int getIdDomicilio() {
        return idDomicilio;
    }

    /**
     * @param idDomicilio the idDomicilio to set
     */
    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idEspecialidad
     */
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the cedulaP
     */
    public String getCedulaP() {
        return cedulaP;
    }

    /**
     * @param cedulaP the cedulaP to set
     */
    public void setCedulaP(String cedulaP) {
        this.cedulaP = cedulaP;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    

    /**
     * @return the idHospital
     */
    public int getIdHospital() {
        return idHospital;
    }

    /**
     * @param idHospital the idHospital to set
     */
    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    /**
     * @return the hospitalDom
     */
    public String getHospitalDom() {
        return hospitalDom;
    }

    /**
     * @param hospitalDom the hospitalDom to set
     */
    public void setHospitalDom(String hospitalDom) {
        this.hospitalDom = hospitalDom;
    }
    
    
    
    public ArrayList<Hospital> Vhospitales() throws SQLException{
        ArrayList<Hospital> Hospitales = new ArrayList();
        Hospital hospital = null;
         if(cn == null) {
            ConexionDB cndb = null;
            cndb.conectar();
        }
        String csp = "";
        String sql = "select distinct id_hos, Hospital from Ddentistas";
         st = cn.createStatement();
         rs = st.executeQuery(sql); 
         while(rs.next()){
             hospital = new Hospital();
             hospital.setIdHospital(rs.getInt(1));
             hospital.setHospitalDom(rs.getString(2));
             Hospitales.add(hospital);
         }
        return Hospitales;
    }
    
    public ArrayList<Dentista> Vespecialidades() throws SQLException{
        ArrayList<Dentista> Especialidades = new ArrayList();
        Dentista Especialidad = null;
         if(cn == null) {
            ConexionDB cndb = null;
            cndb.conectar();
        }
        String csp = "";
        String sql = "select * from cespecialidad";
         st = cn.createStatement();
         rs = st.executeQuery(sql); 
         while(rs.next()){
             Especialidad = new Dentista();
             Especialidad.setIdEspecialidad(rs.getInt(1));
             Especialidad.setEspecialidad(rs.getString(2));
             Especialidades.add(Especialidad);
         }
        return Especialidades;
    }
    
    // Este método sirve para darle un formato a los datos introducidos en las listas desplegables
    public String FormatoFecha(String año, int mes, int dia){
        String fecha = null;
        fecha = año + "-" + mes + "-" + dia;
        return fecha;
    }
    
    
    public ArrayList<Dentista> Bdentista(String cedulaP) throws SQLException{
        ArrayList<Dentista> dentistas = new ArrayList();
        Dentista dentista = null;
        
         if(cn == null) {
            ConexionDB cndb = null;
            cndb.conectar();
        }
        String csp = "";
        String sql = "select * from ddentistas where clp_den='" + cedulaP + "'";
         st = cn.createStatement();
         rs = st.executeQuery(sql); 
         while(rs.next()){
             dentista = new Dentista();
             dentista.setIdDentista(rs.getInt(1));
             dentista.setNombre(rs.getString(2));
             dentista.setApellidos(rs.getString(3));
             dentista.setCedulaP(rs.getString(4));
             dentista.setEspecialidad(rs.getString(5));
             dentista.setTelefono(rs.getInt(6));
             dentista.setFechaN(rs.getString(7));
             dentista.setEstado(rs.getString(8));
             dentista.setMunicipio(rs.getString(9));
             dentista.setColonia(rs.getString(10));
             dentista.setCalle(rs.getString(11));
             dentista.setNumExt(rs.getInt(12));
             dentista.setNumInt(rs.getInt(13));
             dentista.setIdHospital(rs.getInt(14));
             dentista.setHospitalDom(rs.getString(15));
             dentistas.add(dentista);
         }
        
        return dentistas;
    }
    
    
    public boolean BajaDen(String cedula) throws SQLException{
        boolean verifi=false;
        int r=0;
        if(cn == null) {
            ConexionDB cndb = null;
            cndb.conectar();
        }
        
        try{
        String sql = "DELETE FROM mDentista where clp_den='" + cedula + "'";
            // Mandamos el comando SQL al servidor
            ps = cn.prepareStatement(sql);
            r = ps.executeUpdate();
        }catch(SQLException ex){ex.printStackTrace();}
                
        if(r != 0) {
            verifi = true;
        }
        
        return verifi;
    }

    /**
     * @return the fechaN
     */
    public String getFechaN() {
        return fechaN;
    }

    /**
     * @param fechaN the fechaN to set
     */
    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numExt
     */
    public int getNumExt() {
        return numExt;
    }

    /**
     * @param numExt the numExt to set
     */
    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    /**
     * @return the numInt
     */
    public int getNumInt() {
        return numInt;
    }

    /**
     * @param numInt the numInt to set
     */
    public void setNumInt(int numInt) {
        this.numInt = numInt;
    }

}
