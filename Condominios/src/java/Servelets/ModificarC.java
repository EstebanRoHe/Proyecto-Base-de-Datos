package Servelets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarC extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MetodosSQL metodo;
        metodo = new MetodosSQL();
        int txtId_cuotas = Integer.parseInt(request.getParameter("id_cuotas"));
        int txtNumCasa = Integer.parseInt(request.getParameter("NumCasa"));
        float txtprecio = Float.parseFloat(request.getParameter("precio"));
        String txtTipo = request.getParameter("tipo");
        
 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");
  
           boolean usuarioRepetido = metodo.buscarCuotasRepetido(txtId_cuotas);
        if (usuarioRepetido == true) {
           boolean registro = metodo.modificarCuotas(txtId_cuotas,txtNumCasa,txtprecio,txtTipo);
            if (registro == true) {
                out.println("alert('Cuota Modificado en forma exitosa')");
                out.println("location= 'index.jsp'");
            }else {
                out.println("alert('Error: Cuota no Modificado')");
                out.println("location= 'index.jsp'");
            }

        } else {
   
                out.println("alert('Error: Cuota no registrado')");
                out.println("location= 'index.jsp'");

        }

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    
    }

}