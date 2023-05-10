/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.RegistrarDentista;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author INFORMATICA1
 */
public class NvoDentista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nomDentista = request.getParameter("nombre");
        String apeDentista = request.getParameter("apellidos");
        String cedula = request.getParameter("cedula");
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        String colonia = request.getParameter("colonia");
        String calle = request.getParameter("calle");
        String CidUsuario = request.getParameter("idUsuarioD");
        String Ctelefono = request.getParameter("telefono");
        String Cdia = request.getParameter("dia");
        String Cmes = request.getParameter("mes");
        String Caño = request.getParameter("year");
        String CnumExt = request.getParameter("numExt");
        String CnumInt = request.getParameter("numInt");
        String CidEspecialidad = request.getParameter("especialidad");
        String CidHospital = request.getParameter("hospital");
        
        int idUsuario = Integer.parseInt(request.getParameter(CidUsuario));
        int telefono = Integer.parseInt(request.getParameter(Ctelefono));
        int dia = Integer.parseInt(request.getParameter(Cdia));
        int mes = Integer.parseInt(request.getParameter(Cmes));
        int año = Integer.parseInt(request.getParameter(Caño));
        int numExt = Integer.parseInt(request.getParameter(CnumExt));
        int numInt = Integer.parseInt(request.getParameter(CnumInt));
        int idEspecialidad = Integer.parseInt(request.getParameter(CidEspecialidad));
        int idHospital = Integer.parseInt(request.getParameter(CidHospital));
       
        RegistrarDentista rd = new RegistrarDentista();
        
        String fechaN = rd.FormatoFecha(año, mes, dia);
        
        boolean vRegistro = rd.RegistrarD(idUsuario, nomDentista, apeDentista, cedula, telefono, fechaN, estado,
                                        municipio, colonia, calle, numExt, numInt, idEspecialidad, idHospital);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NvoDentista</title>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Baja de dentista</h1>");
                out.println("<center>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>");
                out.println("<a href='FormA'>   Altas</a>");
                out.println("</td>");
                out.println("<td>");
                out.println("<a href='FormC'>   Consultas</a>");
                out.println("</td>");
                out.println("<td>");
                out.println("<a href='FormM'>   Actualizaciones</a>");
                out.println("</td>");
                out.println("<td>");
                out.println("<a href='FormB'>   Bajas</a>");
                out.println("</td>");
                out.println("</th>");
                out.println("</tr>");
                out.println("</table>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<br/>");
                
                if(vRegistro != false){
                    out.println("<h2>");
                    out.println("El odontógolo " + nomDentista + " " + apeDentista + ", se ha registrado exitosamente en el sistema.");
                    out.println("</h2>");
                    out.println("<h3>");
                    out.println("Cédula profesional: " + cedula);
                    out.println("</h3>");
                }
                else{
                    out.println("<h2>");
                    out.println("No se pudo llevar a cabo el registro por causas desconocidas, contácte al desarrollador de la aplicación");
                    out.println("</h2>");
                }
                
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
