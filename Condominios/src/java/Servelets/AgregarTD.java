package Servelets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgregarTD extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MetodosSQL metodo;
        metodo = new MetodosSQL();
    
        
        String txtTipo = request.getParameter("tipo");
        String txtDescripcion = request.getParameter("descripcion");
 
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");
  
           boolean usuarioRepetido = metodo.buscarTipo_DuenoRepetido(txtTipo);
        if (usuarioRepetido == true) {
            out.println("alert('Tipo de Dueño" +txtTipo + "  registrado  anteriormente')");
            out.println("location= 'index.jsp'");

        } else {

            boolean registro = metodo.registrarTIPO_DUENO(txtTipo,txtDescripcion);
            if (registro == true) {
                out.println("alert('Tipo de Dueño registrado en forma exitosa')");
                out.println("location= 'index.jsp'");
            } else {
                out.println("alert('Error: Tipo de Dueño no registrado')");
                out.println("location= 'index.jsp'");
            }

        }

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
}
