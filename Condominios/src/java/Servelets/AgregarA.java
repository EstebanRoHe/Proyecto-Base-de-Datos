package Servelets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgregarA extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MetodosSQL metodo;
        metodo = new MetodosSQL();
        
        String txtCedula= request.getParameter("cedula");
        String txtNombre = request.getParameter("nombre");
        String txtApe1 = request.getParameter("ape1");
        String txtApe2 = request.getParameter("ape2");
        int txtNum_casa= Integer.parseInt(request.getParameter("NumCasa"));
        String txtDescripcion = request.getParameter("descripcion");
        String txtHora = request.getParameter("hora");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");
  
           boolean usuarioRepetido = metodo.buscarAccesosRepetido(txtCedula);
        if (usuarioRepetido == true) {
            out.println("alert('Acceso" + txtCedula + "  registrado  anteriormente')");
            out.println("location= 'index.jsp'");
        } else {
            boolean registro = metodo.registrarAccesos(txtCedula,txtNombre,txtApe1,txtApe2,txtNum_casa,txtDescripcion,txtHora);
            if (registro == true) {
                out.println("alert('Acceso registrado en forma exitosa')");
                out.println("location= 'index.jsp'");
            } else {
                out.println("alert('Error: Acceso no registrado')");
                out.println("location= 'index.jsp'");
            }
        }
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

    }
}
