/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.ConexionDB;
import Logica.Dentista;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author INFORMATICA1
 */
public class BuscarD extends HttpServlet {

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
        
        List dentistas = new ArrayList();
            Dentista d = new Dentista();
            PrintWriter out = response.getWriter();
            
        try {
            dentistas = d.Bdentista(cedula);
            
            int tDentistas = dentistas.size();
            if(tDentistas != 0){
                request.setAttribute("Dentistas", dentistas);
                RequestDispatcher rd = request.getRequestDispatcher("ConsultarD.jsp");
                rd.forward(request, response);
            }
            else{
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
            out.println("<h1>No se encontró ningún registro coincidente con su búsqueda");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            }
            
        } catch(Exception e){
            out.println("Ocurrió un error");
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
            Logger.getLogger(BuscarD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BuscarD.class.getName()).log(Level.SEVERE, null, ex);
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
