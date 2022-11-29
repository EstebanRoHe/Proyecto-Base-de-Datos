package Servelets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarD extends HttpServlet {

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
        int txtTelefono = Integer.parseInt(request.getParameter("telefono"));
        String txtEmail = request.getParameter("email");
         String txtTipo = request.getParameter("tipo");
 
      
     
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");
  
           boolean usuarioRepetido = metodo.buscarDuenoRepetido(txtCedula);
        if (usuarioRepetido == true) {
           boolean registro = metodo.modificarDuenos(txtCedula,txtNombre,txtApe1,txtApe2,txtTelefono,txtEmail,txtTipo);
            if (registro == true) {
                out.println("alert('Dueno Modificado en forma exitosa')");
                out.println("location= 'index.jsp'");
            }else {
                out.println("alert('Error: Dueno no Modificado')");
                out.println("location= 'index.jsp'");
            }

        } else {

         
                out.println("alert('Error: Dueno no registrado')");
                out.println("location= 'index.jsp'");
            

        }

        

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

        
        
         
        
    }

}
