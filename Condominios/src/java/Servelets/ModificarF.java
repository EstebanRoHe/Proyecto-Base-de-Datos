package Servelets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarF extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MetodosSQL metodo;
        metodo = new MetodosSQL();

        int txtNumCasa = Integer.parseInt(request.getParameter("NumCasa"));
        String txtCedula = request.getParameter("cedula");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");

        boolean usuarioRepetido = metodo.buscarFiliaresRepetido(txtNumCasa);
        if (usuarioRepetido == true) {
            boolean registro = metodo.modificarFiliares(txtNumCasa,txtCedula);
            if (registro == true) {
                out.println("alert('Filiar Modificado en forma exitosa')");
                out.println("location= 'index.jsp'");
            } else {
                out.println("alert('Error: Filiar no Modificado')");
                out.println("location= 'index.jsp'");
            }

        } else {

            out.println("alert('Error: Filiar no registrado')");
            out.println("location= 'index.jsp'");
        }
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

    }

}
