/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.ConexionDB;
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
public class NvoUsuarioD extends HttpServlet {

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
        String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            ConexionDB acn = new ConexionDB();
            boolean verificador = acn.NvoUsuarioDen(username, password);
        
        try (PrintWriter out = response.getWriter()) {
            
            int ultimoID = acn.UltimoIDr();
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<titleInicar sesión como administrador</title>");            
            out.println("</head>");
            out.println("<body>");
                if(verificador != false){
                    out.println("<h1>Iniciar sesión como administrador</h1>");
                    out.println("<form action='LoginS' method='POST'>");
                    out.println("<label>Nombre de usuario:</label>  <input type='text' name='username' required/><br>");
                    out.println("<label>Contraseña: </label> <input type='password' name='password' required/><br>");
                    out.println("<input type='submit' value='Entrar como administrador'/>");
                    out.println("</form><br><br>");
                    out.println("El ID del usuario dentista es: '" + ultimoID + "', posteriormente, al registrar al dentista se le solicitará este dato ");
                }
                else{
                    out.println("<h1>Iniciar sesión como administrador</h1>" + ultimoID);
                    out.println("<form action='LoginS' method='POST'>");
                    out.println("<label>Nombre de usuario:</label>  <input type='text' name='username' required/><br>");
                    out.println("<label>Contraseña: </label> <input type='password' name='password' required/><br>");
                    out.println("<input type='submit' value='Entrar como administrador'/><input type='submit' value='Registrar nuevo usuario dentista'/>");
                    out.println("</form><br><br>");
                    out.println("El nuevo usuario no se pudo registrar");
                }
            
            
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
            Logger.getLogger(NvoUsuarioD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NvoUsuarioD.class.getName()).log(Level.SEVERE, null, ex);
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
