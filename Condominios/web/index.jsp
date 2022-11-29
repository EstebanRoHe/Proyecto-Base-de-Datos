
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/estiloIndex.css" rel="stylesheet">
        <jsp:useBean id="Metodos" class="SQL.MetodosSQL" scope="page"></jsp:useBean>
        <jsp:useBean id="Conexion" class="SQL.ConexionBD" scope="page"></jsp:useBean>
            <title>Mantenimeinto</title>
            <style>
                body {
                    background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("ima/f2.jpg");
                    background-repeat: no-repeat;
                    background-attachment: fixed;
                }
            </style>

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



                <h1>TIPO DE DUEÑOS</h1>
                <div class="cero">

                    <div class="AregarTD">
                        <div class="formularioATD">

                            <form method="post" action="AgregarTD">
                                <h2>Agregar Tipo de Dueño</h2>
                                <table>

                                    <tr>
                                        <td><label for="tipo">Tipo de Dueño </label></td>
                                        <td><input type="text" id="tipo" name="tipo" required ></td>
                                    </tr>

                                    <td><label for="descripcion">Descripcion del Dueño: </label></td>
                                    <td><input type="text " id="descripcion " name="descripcion" required > </td>
                                    </tr>



                                </table>
                                <button type="submit" class="btnEnviar" >Agregar</button>    

                            </form>

                        </div>

                    </div>

                    <div class="eliminarTD">

                        <div class="formularioETD">
                            <form  method="post" action="EliminarTD">
                                <h2>Eliminar Tipo de Dueño</h2>
                                <table>

                                    <tr>
                                    <%
                                        ResultSet buscarTIDMLE = Metodos.mostrar_TP_DUENOS();
                                    %>
                                    <td><label for="tipo">Tipo de Dueño a Eliminar</label></td>
                                    <td><select name="tipo" id="tipo" required>
                                            <option value=""></option>
                                            <%
                                                while (buscarTIDMLE.next()) {
                                            %>
                                            <option value="<%=buscarTIDMLE.getString("TIPO")%>"><%=buscarTIDMLE.getString("TIPO")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>




                            </table>
                            <button type="submit" class="btnEnviar">Eliminar</button>
                        </form>
                    </div>

                </div>

                <div class="ModificarTD">
                    <div class="formularioMTD">

                        <form method="post" action="ModificarTD">
                            <h2>Modificar Tipo de Dueño</h2>
                            <table>
                                <tr>
                                    <%
                                        ResultSet buscarTIDML = Metodos.mostrar_TP_DUENOS();
                                    %>
                                    <td><label for="tipo">Tipo de Dueño a Modificar</label></td>
                                    <td><select name="tipo" id="tipo" required>
                                            <option value=""></option>
                                            <%
                                                while (buscarTIDML.next()) {
                                            %>
                                            <option value="<%=buscarTIDML.getString("TIPO")%>"><%=buscarTIDML.getString("DESCRIPCION")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                                <td><label for="descripcion">Descripcion del Dueño que desea Modificar: </label></td>
                                <td><input type="text " id="descripcion" name="descripcion" required > </td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar" >Modificar</button>    

                        </form>

                    </div>


                </div>

            </div>




            <h1>DUEÑOS</h1>
            <div class="primero">

                <div class="AregarD">
                    <div class="formularioAS">

                        <form method="post" action="Agregar">
                            <h2>Agregar Dueño</h2>
                            <table>

                                <tr>
                                    <td><label for="cedula">Cedula </label></td>
                                    <td><input type="number" id="cedula" name="cedula" required ></td>
                                </tr>

                                <td><label for="nombre">Nombre: </label></td>
                                <td><input type="text " id="nombre" name="nombre" required  > </td>
                                </tr>

                                <tr>
                                    <td><label for="ape1">Apellido1: </label></td>
                                    <td><input type="text" id="ape1" name="ape1" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="ape2">Apellido2: </label></td>
                                    <td><input type="text" id="ape2" name="ape2" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="telefono">Telefono: </label></td>
                                    <td><input type="number" id="telefono" name="telefono" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="email">Email: </label></td>
                                    <td><input type="email" id="email" name="email" required ></td>
                                </tr>



                                <tr>
                                    <%
                                        ResultSet buscarTID = Metodos.mostrar_TP_DUENOS();
                                    %>
                                    <td><label for="tipo">Seleccione el Tipo</label></td>
                                    <td><select name="tipo" id="tipo" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarTID.next()) {
                                            %>
                                            <option value="<%=buscarTID.getString("TIPO")%>"><%=buscarTID.getString("DESCRIPCION")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>



                            </table>
                            <button type="submit" class="btnEnviar" >Agregar</button>    

                        </form>

                    </div>

                </div>

                <div class="eliminarD">

                    <div class="formularioED">
                        <form  method="post" action="EliminarD">
                            <h2>Eliminar Dueños</h2>
                            <table>
                                <tr>
                                    <%
                                        ResultSet buscar = Metodos.mostrar_DUENOS();
                                    %>
                                    <td><label for="cedula">Seleccione Cedula Del Dueño a Eliminar</label></td>
                                    <td><select name="cedula" id="cedula" required >
                                            <option value=""></option>
                                            <%
                                                while (buscar.next()) {
                                            %>
                                            <option value="<%=buscar.getString("CEDULA")%>"><%=buscar.getString("CEDULA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar">Eliminar</button>
                        </form>
                    </div>

                </div>

                <div class="ModificarD">
                    <div class="formularioMAD">

                        <form method="post" action="ModificarD">
                            <h2>Modificar Dueño</h2>
                            <table>

                                <tr>
                                    <%
                                        ResultSet buscarDM = Metodos.mostrar_DUENOS();
                                    %>
                                    <td><label for="cedula">Seleccione Cedula Del Dueño a Modificar</label></td>
                                    <td><select name="cedula" id="cedula" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarDM.next()) {
                                            %>
                                            <option value="<%=buscarDM.getString("CEDULA")%>"><%=buscarDM.getString("CEDULA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                                <td><label for="nombre">Nombre: </label></td>
                                <td><input type="text " id="nombre" name="nombre" required > </td>
                                </tr>

                                <tr>
                                    <td><label for="ape1">Apellido1: </label></td>
                                    <td><input type="text" id="ape1" name="ape1" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="ape2">Apellido2: </label></td>
                                    <td><input type="text" id="ape2" name="ape2" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="telefono">Telefono: </label></td>
                                    <td><input type="number" id="telefono" name="telefono" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="email">Email: </label></td>
                                    <td><input type="email" id="email" name="email" required ></td>
                                </tr>


                                <tr>
                                    <%
                                        ResultSet buscarTIDM = Metodos.mostrar_TP_DUENOS();
                                    %>
                                    <td><label for="tipo">Seleccione el Tipo</label></td>
                                    <td><select name="tipo" id="tipo" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarTIDM.next()) {
                                            %>
                                            <option value="<%=buscarTIDM.getString("TIPO")%>"><%=buscarTIDM.getString("DESCRIPCION")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar" >Modificar</button>    

                        </form>

                    </div>


                </div>

            </div>



            <h1>FILIARES</h1>
            <div class="segundo">

                <div class="AregarF">
                    <div class="formularioAF">

                        <form method="post" action="AgregarF">
                            <h2>Agregar Filiares</h2>
                            <table>

                                <tr>
                                    <td><label for="NumCasa">Numero de la Casa </label></td>
                                    <td><input type="number" id="NumCasa" name="NumCasa" required ></td>
                                </tr>

                                <tr>
                                    <%
                                        ResultSet buscarDAF = Metodos.mostrar_DUENOS();
                                    %>
                                    <td><label for="cedula">Seleccione Cedula Del Dueño</label></td>
                                    <td><select name="cedula" id="cedula" required>
                                            <option value=""></option>
                                            <%
                                                while (buscarDAF.next()) {
                                            %>
                                            <option value="<%=buscarDAF.getString("CEDULA")%>"><%=buscarDAF.getString("CEDULA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>



                            </table>
                            <button type="submit" class="btnEnviar" >Agregar</button>    

                        </form>

                    </div>

                </div>

                <div class="eliminarF">

                    <div class="formularioEF">
                        <form  method="post" action="EliminarF">
                            <h2>Eliminar Filiares</h2>
                            <table>


                                <tr>
                                    <%
                                        ResultSet buscarFE = Metodos.mostrar_FILIARES();
                                    %>
                                    <td><label for="NumCasa">Seleccione el Numero de Casa a Eliminar</label></td>
                                    <td><select name="NumCasa" id="NumCasa" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarFE.next()) {
                                            %>
                                            <option value="<%=buscarFE.getInt("NUM_CASA")%>"><%=buscarFE.getInt("NUM_CASA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar">Eliminar</button>
                        </form>
                    </div>

                </div>

                <div class="ModificarF">
                    <div class="formularioMF">

                        <form method="post" action="ModificarF">
                            <h2>Modificar Filiares</h2>
                            <table>

                                <tr>
                                    <%
                                        ResultSet buscarFM = Metodos.mostrar_FILIARES();
                                    %>
                                    <td><label for="NumCasa">Seleccione el Numero de Casa a Modificar</label></td>
                                    <td><select name="NumCasa" id="NumCasa" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarFM.next()) {
                                            %>
                                            <option value="<%=buscarFM.getInt("NUM_CASA")%>"><%=buscarFM.getInt("NUM_CASA")%></option>
                                            <%
                                                }
                                            %>

                                        </select>
                                    </td>
                                </tr>   

                                <tr>
                                    <%
                                        ResultSet buscarFMD = Metodos.mostrar_DUENOS();
                                    %>
                                    <td><label for="cedula">Seleccione la Cedula Del Dueño</label></td>
                                    <td><select name="cedula" id="cedula" required>
                                            <option value=""></option>
                                            <%
                                                while (buscarFMD.next()) {
                                            %>
                                            <option value="<%=buscarFMD.getString("CEDULA")%>"><%=buscarFMD.getString("CEDULA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar" >Modificar</button>    

                        </form>

                    </div>


                </div>

            </div>




            <h1>TIPO DE CUOTAS</h1>
            <div class="entre_seg_ter">

                <div class="AregarTC">
                    <div class="formularioATC">

                        <form method="post" action="AgregarTC">
                            <h2>Agregar Tipo de Cuotas</h2>
                            <table>

                                <tr>
                                    <td><label for="tipo">Tipo de Cuotas </label></td>
                                    <td><input type="text" id="tipo" name="tipo" required ></td>
                                </tr>

                                <td><label for="descripcion">Descripcion de la Cuota </label></td>
                                <td><input type="text " id="descripcion " name="descripcion" required > </td>
                                </tr>



                            </table>
                            <button type="submit" class="btnEnviar" >Agregar</button>    

                        </form>

                    </div>

                </div>

                <div class="eliminarTC">

                    <div class="formularioETC">
                        <form  method="post" action="EliminarTC">
                            <h2>Eliminar Tipo de Cuota</h2>
                            <table>


                                <tr>
                                    <%
                                        ResultSet buscarTCE = Metodos.mostrar_TPCUOTAS();
                                    %>
                                    <td><label for="tipo">Tipo de Cuota a Eliminar</label></td>
                                    <td><select name="tipo" id="tipo" required>
                                            <option value=""></option>
                                            <%
                                                while (buscarTCE.next()) {
                                            %>
                                            <option value="<%=buscarTCE.getString("TIPO")%>"><%=buscarTCE.getString("TIPO")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar">Eliminar</button>
                        </form>
                    </div>

                </div>

                <div class="ModificarTC">
                    <div class="formularioMTC">

                        <form method="post" action="ModificarTC">
                            <h2>Modificar Tipo de Cuota</h2>
                            <table>

                                <tr>
                                    <%
                                        ResultSet buscarTCMl = Metodos.mostrar_TPCUOTAS();
                                    %>
                                    <td><label for="tipo">Tipo de Cuota a Modificar</label></td>
                                    <td><select name="tipo" id="tipo" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarTCMl.next()) {
                                            %>
                                            <option value="<%=buscarTCMl.getString("TIPO")%>"><%=buscarTCMl.getString("DESCRIPCION")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                                <td><label for="descripcion">Descripcion de la Cuota que desea Modificar </label></td>
                                <td><input type="text " id="descripcion" name="descripcion" required > </td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar" >Modificar</button>    

                        </form>

                    </div>


                </div>

            </div>



            <h1>CUOTAS</h1>
            <div class="tercero">

                <div class="AregarC">
                    <div class="formularioAC">

                        <form method="post" action="AgregarC">
                            <h2>Agregar Cuotas</h2>

                            <table>

                                <tr>
                                    <td><label for="id_cuotas">ID COUTA </label></td>
                                    <td><input type="number" id="id_cuotas" name="id_cuotas" required ></td>
                                </tr>



                                <tr>
                                    <%
                                        ResultSet agregarFC = Metodos.mostrar_FILIARES();
                                    %>
                                    <td><label for="NumCasa">Numero de Casa</label></td>
                                    <td><select name="NumCasa" id="NumCasa" required>
                                            <option value=""></option>
                                            <%
                                                while (agregarFC.next()) {
                                            %>
                                            <option value="<%=agregarFC.getInt("NUM_CASA")%>"><%=agregarFC.getInt("NUM_CASA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                                <tr>
                                    <td><label for="precio">Precio de la Couta</label></td>
                                    <td><input type="number" id="precio" name="precio" required ></td>
                                </tr>



                                <tr>
                                    <%
                                        ResultSet buscarTCAC = Metodos.mostrar_TPCUOTAS();
                                    %>
                                    <td><label for="tipo">Tipo de Cuota</label></td>
                                    <td><select name="tipo" id="tipo" required>
                                            <option value=""></option>
                                            <%
                                                while (buscarTCAC.next()) {
                                            %>
                                            <option value="<%=buscarTCAC.getString("TIPO")%>"><%=buscarTCAC.getString("DESCRIPCION")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>


                            </table>

                            <button type="submit" class="btnEnviar" >Agregar</button>    

                        </form>

                    </div>

                </div>

                <div class="eliminarC">

                    <div class="formularioC">
                        <form  method="post" action="EliminarC">
                            <h2>Eliminar Cuotas</h2>
                            <table>


                                <tr>
                                    <%
                                        ResultSet EliminarCEL = Metodos.mostrar_CUOTAS();
                                    %>
                                    <td><label for="id_cuota">ID de la Cuota a Eliminar</label></td>
                                    <td><select name="id_cuota" id="id_cuota" required>
                                            <option value=""></option>
                                            <%
                                                while (EliminarCEL.next()) {
                                            %>
                                            <option value="<%=EliminarCEL.getInt("ID_COUTA")%>"><%=EliminarCEL.getInt("ID_COUTA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar">Eliminar</button>
                        </form>
                    </div>

                </div>

                <div class="ModificarC">
                    <div class="formularioMC">

                        <form method="post" action="ModificarC">
                            <h2>Modificar Cuota</h2>
                            <table>


                                <tr>
                                    <%
                                        ResultSet ModificarCout = Metodos.mostrar_CUOTAS();
                                    %>
                                    <td><label for="id_cuotas">ID COUTA</label></td>
                                    <td><select name="id_cuotas" id="id_cuotas" >
                                            <option value=""></option>
                                            <%
                                                while (ModificarCout.next()) {
                                            %>
                                            <option value="<%=ModificarCout.getInt("ID_COUTA")%>"><%=ModificarCout.getInt("ID_COUTA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>



                                <tr>
                                    <%
                                        ResultSet ModificraFC = Metodos.mostrar_FILIARES();
                                    %>
                                    <td><label for="NumCasa">Numero de Casa</label></td>
                                    <td><select name="NumCasa" id="NumCasa" required >
                                            <option value=""></option>
                                            <%
                                                while (ModificraFC.next()) {
                                            %>
                                            <option value="<%=ModificraFC.getInt("NUM_CASA")%>"><%=ModificraFC.getInt("NUM_CASA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                                <tr>
                                    <td><label for="precio">Precio de la Couta</label></td>
                                    <td><input type="number" id="precio" name="precio" required ></td>
                                </tr>




                                <tr>
                                    <%
                                        ResultSet buscarTCACM = Metodos.mostrar_TPCUOTAS();
                                    %>
                                    <td><label for="tipo">Tipo de Cuota</label></td>
                                    <td><select name="tipo" id="tipo" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarTCACM.next()) {
                                            %>
                                            <option value="<%=buscarTCACM.getString("TIPO")%>"><%=buscarTCACM.getString("DESCRIPCION")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>


                            </table>
                            <button type="submit" class="btnEnviar" >Modificar</button>    

                        </form>

                    </div>


                </div>

            </div>


            <h1>ACCESOS</h1>
            <div class="cuarto">

                <div class="AregarA">
                    <div class="formularioAA">

                        <form method="post" action="AgregarA">
                            <h2>Agregar Accesos</h2>

                            <table>

                                <tr>
                                    <td><label for="cedula">Cedula </label></td>
                                    <td><input type="text" id="cedula" name="cedula" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="nombre">Nombre </label></td>
                                    <td><input type="text" id="nombre" name="nombre" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="ape1">Apellido 1</label></td>
                                    <td><input type="text" id="ape1" name="ape1" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="ape2">Apellido 2</label></td>
                                    <td><input type="text" id="ape2" name="ape2" required ></td>
                                </tr>


                                <tr>
                                    <%
                                        ResultSet buscarFAA = Metodos.mostrar_FILIARES();
                                    %>
                                    <td><label for="NumCasa">Seleccione el Numero de Casa </label></td>
                                    <td><select name="NumCasa" id="NumCasa" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarFAA.next()) {
                                            %>
                                            <option value="<%=buscarFAA.getInt("NUM_CASA")%>"><%=buscarFAA.getInt("NUM_CASA")%></option>
                                            <%
                                                }
                                            %>

                                        </select>
                                    </td>
                                </tr> 

                                <tr>
                                    <td><label for="descripcion">Descripcion</label></td>
                                    <td><input type="text" id="descripcion" name="descripcion" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="hora">Fecha</label></td>
                                    <<td><input type="date" name="hora" id="hora" value="2022-07-01" min="2022-06-01" max="2099-01-01" required ></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar" >Agregar</button>    

                        </form>

                    </div>

                </div>

                <div class="eliminarA">

                    <div class="formularioEA">
                        <form  method="post" action="EliminarA">
                            <h2>Eliminar Accesos</h2>
                            <table>


                                <tr>
                                    <%
                                        ResultSet eliminarAA = Metodos.mostrar_visitantes();
                                    %>
                                    <td><label for="NumCasa">Cedula del Acceso a Eliminar</label></td>
                                    <td><select name="NumCasa" id="NumCasa" required >
                                            <option value=""></option>
                                            <%
                                                while (eliminarAA.next()) {
                                            %>
                                            <option value="<%=eliminarAA.getString("CEDULA")%>"><%=eliminarAA.getString("CEDULA")%></option>
                                            <%
                                                }
                                            %>

                                        </select></td>
                                </tr>

                            </table>
                            <button type="submit" class="btnEnviar">Eliminar</button>
                        </form>
                    </div>

                </div>

                <div class="ModificarA">
                    <div class="formularioMA">

                        <form method="post" action="ModificarA">
                            <h2>Modificar Accesos</h2>
                            <table>

                                <tr>
                                    <%
                                        ResultSet buscarMOAA = Metodos.mostrar_visitantes();
                                    %>
                                    <td><label for="cedula">Seleccione la Cedula del Visitante</label></td>
                                    <td><select name="cedula" id="cedula" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarMOAA.next()) {
                                            %>
                                            <option value="<%=buscarMOAA.getString("CEDULA")%>"><%=buscarMOAA.getString("CEDULA")%></option>
                                            <%
                                                }
                                            %>

                                        </select>
                                    </td>
                                </tr> 

                                <tr>
                                    <td><label for="nombre">Nombre </label></td>
                                    <td><input type="text" id="nombre" name="nombre" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="ape1">Apellido 1</label></td>
                                    <td><input type="text" id="ape1" name="ape1" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="ape2">Apellido 2</label></td>
                                    <td><input type="text" id="ape2" name="ape2" required ></td>
                                </tr>


                                <tr>
                                    <%
                                        ResultSet buscarFA = Metodos.mostrar_FILIARES();
                                    %>
                                    <td><label for="NumCasa">Seleccione el Numero de Casa </label></td>
                                    <td><select name="NumCasa" id="NumCasa" required >
                                            <option value=""></option>
                                            <%
                                                while (buscarFA.next()) {
                                            %>
                                            <option value="<%=buscarFA.getInt("NUM_CASA")%>"><%=buscarFA.getInt("NUM_CASA")%></option>
                                            <%
                                                }
                                            %>

                                        </select>
                                    </td>
                                </tr> 

                                <tr>
                                    <td><label for="descripcion">Descripcion</label></td>
                                    <td><input type="text" id="descripcion" name="descripcion" required ></td>
                                </tr>

                                <tr>
                                    <td><label for="hora">Fecha</label></td>
                                    <td><input type="date" name="hora" id="hora" value="2022-07-01" min="2022-06-01" max="2099-01-01" required ></td>
                                </tr>

                            </table>

                            <button type="submit" class="btnEnviar" >Modificar</button>    

                        </form>

                    </div>


                </div>

            </div>




            <%-- Div del principal --%>
        </div>



    </body>

</html>
