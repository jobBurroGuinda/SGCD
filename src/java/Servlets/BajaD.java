/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Dentista;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Job
 */
public class BajaD extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String cedula = request.getParameter("cedulaProfesional");
        
        try (PrintWriter out = response.getWriter()) {
            boolean verif = false;
            Dentista d = new Dentista();
            verif = d.BajaDen(cedula);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Baja de dentista</title>");            
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
                if(verif != false){
                    out.println("<h1>El dentista con cédula profesional: '" + cedula + "', se ha dado de baja exitosamente");
                }else{
                    out.println("<h1>El dentista con cédula profesional: '" + cedula + "', no se pudo dar baja, contácte al desarrollador de la  aplicación");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BajaD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BajaD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
