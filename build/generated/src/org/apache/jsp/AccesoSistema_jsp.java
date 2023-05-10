package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AccesoSistema_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>Pagina Acceso al Sistema</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<table width=\"100%\" height=\"100%\" border=\"0\" >\n");
      out.write("  <tr>\n");
      out.write("    <th height=\"171\" colspan=\"2\" scope=\"col\"><img src=\"Imagenes/hospital.jpg\" width=\"936\" height=\"243\" /></th>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <th width=\"22%\" scope=\"row\"><table width=\"100%\" border=\"0\">\n");
      out.write("      <tr>\n");
      out.write("        <th scope=\"col\"><a href=\"QuienesSomos.jsp\">Quienes somos <width=\"206\" height=\"62\" /></a></th>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <th scope=\"row\"><a href=\"ubicacion.jsp\">Ubicación <width=\"210\" height=\"59\" /></a></th>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <th scope=\"row\"><a href=\"servicios.jsp\">Servicios <width=\"206\" height=\"60\" /></a></th>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <th scope=\"row\"><a href=\"DudasyComentarios.jsp\">Dudas y comentarios <width=\"215\" height=\"48\" /></a></th>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <th scope=\"row\"><a href=\"AccesoSistema.jsp\">Acceso al sistema <width=\"215\" height=\"53\" /></a></th>\n");
      out.write("      </tr>\n");
      out.write("    </table></th>\n");
      out.write("\t<BR>\n");
      out.write("<BR>\n");
      out.write("\n");
      out.write("<FONT FACE=TAHOMA COLOR=#000000> <CENTER> <H3> Ingres tu Nombre de Usuario y Contraseña </H3> </CENTER> </FONT>\n");
      out.write("<BR>\n");
      out.write("<BR>\n");
      out.write("<BR>\n");
      out.write("    <td width=\"78%\"><BLOCKQUOTE> <P ALIGN=CENTER>&nbsp; </P>\n");
      out.write("        <P ALIGN=CENTER>Ingresa tu Nombre de Usuario y Contrase&ntilde;a </P>\n");
      out.write("        <P ALIGN=CENTER>&nbsp;</P>\n");
      out.write("        <P ALIGN=CENTER>USUARIO:\n");
      out.write("          <INPUT NAME=\"NOMBRE\" TYPE=\"TEXT\"  SIZE=\"22\" MAXLENGTH=\"20\">\n");
      out.write("        </P>\n");
      out.write("    </BLOCKQUOTE>\n");
      out.write("      <div align=\"center\"><BR>\n");
      out.write("        <BR>\n");
      out.write("CONTRASEÑA:\n");
      out.write("<INPUT NAME=\"CONTRA\" TYPE=\"PASSWORD\"  SIZE=\"24\" MAXLENGTH=\"10\">\n");
      out.write("<BR>\n");
      out.write("<BR>\n");
      out.write("<BR>\n");
      out.write("      </div>\n");
      out.write("      <P ALIGN=CENTER>  <INPUT NAME=\"BOTON\" TYPE=\"SUBMIT\" VALUE=\"Ingresar\">\n");
      out.write("\n");
      out.write("<BR>\n");
      out.write("      <P ALIGN=left><BR>\n");
      out.write("      </td>\n");
      out.write("  </tr>\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
