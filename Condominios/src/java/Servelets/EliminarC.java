package Servelets;
 
import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminarC extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MetodosSQL metodo;
        metodo = new MetodosSQL();

        
       int txtId_cuota = Integer.parseInt(request.getParameter("id_cuota"));
       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");
          boolean usuarioRepetido = metodo.buscarCuotasRepetido(txtId_cuota);
        if (usuarioRepetido == true) {
            
            boolean registro = metodo.eliminarCuotas(txtId_cuota);
            if (registro == true) {
                out.println("alert('Cuota Eliminado')");
                out.println("location= 'index.jsp'");
            } else {
                out.println("alert('Error: Cuota no se Elimino')");
                out.println("location= 'index.jsp'");
            }
          

        } else {
            
                out.println("alert('Cuota No Se Encontro o No existe')");
                out.println("location= 'index.jsp'");
            

        }

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

    }

}
