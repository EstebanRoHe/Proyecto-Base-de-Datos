package Servelets;
 
import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminarD extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MetodosSQL metodo;
        metodo = new MetodosSQL();

        
       String txtCedula = request.getParameter("cedula");
       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");
          boolean usuarioRepetido = metodo.buscarDuenoRepetido(txtCedula);
        if (usuarioRepetido == true) {
            
            boolean registro = metodo.eliminarDuenos(txtCedula);
            if (registro == true) {
                out.println("alert('Dueño Eliminado')");
                out.println("location= 'index.jsp'");
            } else {
                out.println("alert('Error: Dueño no se Elimino')");
                out.println("location= 'index.jsp'");
            }
          

        } else {
            
                out.println("alert('Dueño No Se Encontro o No existe')");
                out.println("location= 'index.jsp'");
            

        }

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

    }

}
