<%-- 
    Document   : accesos
    Created on : 22 jun. 2022, 16:49:20
    Author     : Esteban
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/estiloAcceso.css" rel="stylesheet">
        <style>
            body{
                background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("ima/f11.jpg");
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
        </style>
        <title>listas</title>
        <jsp:useBean id="Metodos" class="SQL.MetodosSQL" scope="page"></jsp:useBean>
        </head>
        <body>
            <div class="principal"> 



                <div class="nav">
                    <nav class="barra_de_navegacion">
                        <ul class="m">
                            <li>
                                <a href="index.jsp">INICIO</a>
                            </li>
                            <li>
                                <a href="lista.jsp">TIPO DE DUEÑOS</a>
                            </li>
                            <li>
                                <a href="duenos.jsp">DUEÑOS</a>
                            </li>
                            <li>
                                <a href="filiares.jsp">FILIARES</a>
                            </li>
                            <li>
                                <a href="tipodecuotas.jsp">TIPO DE CUOTAS</a>
                            </li>
                            <li>
                                <a href="cuotas.jsp">CUOTAS</a>
                            </li>
                            <li>
                                <a href="accesos.jsp">ACCESOS</a>
                            </li>
                        </ul>
                    </nav>
                </div>


                <h1>Accesos</h1>
                <div class="primero">
                <%
                    ResultSet ACESSOS = Metodos.mostrar_visitantes();
                %> 
                <%while (ACESSOS.next()) {%>
                <div class="p">
                    <table>
                        <tr>
                            <td><label for="CEDULA">CEDULA  : </label></td>
                            <td><label for="CEDULA"><%=ACESSOS.getString("CEDULA")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="NOMBRE">NOMBRE : </label></td>
                            <td><label for="NOMBRE"> <%=ACESSOS.getString("NOMBRE")%></td>
                        </tr>

                        <tr>
                            <td><label for="APE1">APELLIDO 1 : </label></td>
                            <td><label for="APE1"><%=ACESSOS.getString("APE1")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="APE2">APELLIDO 2 : </label></td>
                            <td><label for="APE2"> <%=ACESSOS.getString("APE2")%></td>
                        </tr>

                        <tr>
                            <td><label for="NUM_CASA">NUMERO DE LA CASA : </label></td>
                            <td><label for="NUM_CASA"> <%=ACESSOS.getInt("NUM_CASA")%></td>
                        </tr>

                        <tr>
                            <td><label for="DESCRIPCION">DESCRIPCION : </label></td>
                            <td><label for="DESCRIPCION"><%=ACESSOS.getString("DESCRIPCION")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="FECHA">FECHA : </label></td>
                            <td><label for="FECHA"> <%=ACESSOS.getString("FECHA")%></td>
                        </tr>

                    </table>
                </div>
                <%
                    }
                %>
            </div>

        </div>
    </body>
</html>
