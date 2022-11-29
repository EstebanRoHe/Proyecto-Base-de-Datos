<%-- 
    Document   : duenos
    Created on : 22 jun. 2022, 16:42:55
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
        <link href="css/estiloDuenos.css" rel="stylesheet">
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


                <h1>Dueños</h1>
                <div class="primero">
                <%
                    ResultSet Dueno = Metodos.mostrar_DUENOS();
                %>

                <%while (Dueno.next()) {%>
                <div class="p">
                    <table>
                        <tr>
                            <td><label for="CEDULA">CEDULA : </label></td>
                            <td><label for="CEDULA"><%=Dueno.getString("CEDULA")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="NOMBRE"> NOMBRE : </label></td>
                            <td><label for="NOMBRE"> <%=Dueno.getString("NOMBRE")%> </td>
                        </tr>

                        <tr>
                            <td><label for="APE1">APE1 : </label></td>
                            <td><label for="APE1"><%=Dueno.getString("APE1")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="APE2">APE2 : </label></td>
                            <td><label for="APE2"><%=Dueno.getString("APE2")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="TELEFONO"> TELEFONO : </label></td>
                            <td><label for="TELEFONO"> <%=Dueno.getInt("TELEFONO")%> </td>
                        </tr>

                        <tr>
                            <td><label for="EMAIL">EMAIL : </label></td>
                            <td><label for="EMAIL"><%=Dueno.getString("EMAIL")%> </label></td>
                        </tr>

                        <tr>
                            <td><label for="TIPO">TIPO : </label></td>
                            <td><label for="TIPO"><%=Dueno.getString("TIPO")%></label></td>
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


