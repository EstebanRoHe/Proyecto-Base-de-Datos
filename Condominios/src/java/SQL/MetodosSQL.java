package SQL;

import static SQL.ConexionBD.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

public class MetodosSQL {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    public boolean registrar(String CEDULA, String NOMBRE, String APE1, String APE2, int TELEFONO, String EMAIL, String TIPO) {
        boolean registro = false;
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DUENO (?,?,?,?,?,?,?)}");

            cstmt.setString(1, CEDULA);
            cstmt.setString(2, NOMBRE);
            cstmt.setString(3, APE1);
            cstmt.setString(4, APE2);
            cstmt.setInt(5, TELEFONO);
            cstmt.setString(6, EMAIL);
            cstmt.setString(7, TIPO);

            int inserta = cstmt.executeUpdate();
            if (inserta > 0) {
                registro = true;
                System.out.println("Se guadaron los datos");

            } else {
                registro = false;
                System.out.println("Información no guardada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + registro);

        return registro;

    }

    public boolean buscarDuenoRepetido(String CEDULA) {
        boolean usuarioRepetido = false;
        try {

            conexion = ConexionBD.conectar();

            String consulta = "SELECT CEDULA from CONDOMINIO.DUENOS where CEDULA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, CEDULA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRepetido = true;

            } else {

                usuarioRepetido = false;
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e);
            }

        }
        System.out.println("El valor del usuario repetido es:" + usuarioRepetido);
        return usuarioRepetido;
    }

    public int buscarDueno(String CEDULA) {
        int codigo = 0;
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT CEDULA from CONDOMINIO.DUENOS where CEDULA= ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, CEDULA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("CEDULA");
            } else {
                codigo = 0;
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        System.out.println("El nombre es : " + codigo);
        return codigo;
    }

    //--------------------------ELIMINAR DUENOS---------------------------------
    public boolean eliminarDuenos(String CEDULA) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DEL_DUENO (?)}");

            cstmt.setString(1, CEDULA);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se eliminaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no eliminada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    //--------------------------Modificar DUENOS---------------------------------
    public boolean modificarDuenos(String CEDULA, String NOMBRE, String APE1, String APE2, int TELEFONO, String EMAIL, String TIPO) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_UPD_DUENO (?,?,?,?,?,?,?)}");

            cstmt.setString(1, CEDULA);
            cstmt.setString(2, NOMBRE);
            cstmt.setString(3, APE1);
            cstmt.setString(4, APE2);
            cstmt.setInt(5, TELEFONO);
            cstmt.setString(6, EMAIL);
            cstmt.setString(7, TIPO);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se Modificaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no Modificada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    /*-------------------------Agregar FILIARES---------------------------------------*/
    public boolean registrarFiliares(int NUM_CASA, String CEDULA_DUENO) {
        boolean registro = false;
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_FILIARES (?,?)}");
            cstmt.setInt(1, NUM_CASA);
            cstmt.setString(2, CEDULA_DUENO);

            int inserta = cstmt.executeUpdate();
            if (inserta > 0) {
                registro = true;
                System.out.println("Se guadaron los datos");

            } else {
                registro = false;
                System.out.println("Información no guardada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + registro);

        return registro;

    }

    public boolean buscarFiliaresRepetido(int NUM_CASA) {
        boolean usuarioRepetido = false;
        try {

            conexion = ConexionBD.conectar();

            String consulta = "SELECT NUM_CASA from CONDOMINIO.FILIARES_CONDOMINIOS where NUM_CASA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, NUM_CASA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRepetido = true;

            } else {

                usuarioRepetido = false;
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e);
            }

        }
        System.out.println("El valor del usuario repetido es:" + usuarioRepetido);
        return usuarioRepetido;
    }

    public int buscarFiliares(int NUM_CASA) {
        int codigo = 0;
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT NUM_CASA from CONDOMINIO.FILIARES_CONDOMINIOS where NUM_CASA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, NUM_CASA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("NUM_CASA");
            } else {
                codigo = 0;
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        System.out.println("El nombre es : " + codigo);
        return codigo;
    }

    //--------------------------ELIMINAR Filiares---------------------------------
    public boolean eliminarFiliares(int NUM_CASA) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DEL_FILIARES (?)}");

            cstmt.setInt(1, NUM_CASA);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se eliminaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no eliminada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    //--------------------------Modificar Filiares---------------------------------
    public boolean modificarFiliares(int NUM_CASA, String CEDULA_DUENO) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_UPD_FILIARES (?,?)}");

            cstmt.setInt(1, NUM_CASA);
            cstmt.setString(2, CEDULA_DUENO);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se Modificaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no Modificada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    /*-------------------------Agregar CUOTAS---------------------------------------*/
    public boolean registrarCuotas(int ID_COUTA, int NUM_CASA, Float PRECIO, String TIPO) {
        boolean registro = false;
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_CUOTAS(?,?,?,?)}");
            cstmt.setInt(1, ID_COUTA);
            cstmt.setInt(2, NUM_CASA);
            cstmt.setFloat(3, PRECIO);
            cstmt.setString(4, TIPO);

            int inserta = cstmt.executeUpdate();
            if (inserta > 0) {
                registro = true;
                System.out.println("Se guadaron los datos");

            } else {
                registro = false;
                System.out.println("Información no guardada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + registro);

        return registro;

    }

    public boolean buscarCuotasRepetido(int ID_COUTA) {
        boolean usuarioRepetido = false;
        try {

            conexion = ConexionBD.conectar();

            String consulta = "SELECT ID_COUTA  from CONDOMINIO.CUOTAS_CONDOMINALES where ID_COUTA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, ID_COUTA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRepetido = true;

            } else {

                usuarioRepetido = false;
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e);
            }

        }
        System.out.println("El valor del usuario repetido es:" + usuarioRepetido);
        return usuarioRepetido;
    }

    public int buscarCuotas(int ID_COUTA) {
        int codigo = 0;
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT ID_COUTA from CONDOMINIO.CUOTAS_CONDOMINALES where ID_COUTA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, ID_COUTA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("ID_COUTA");
            } else {
                codigo = 0;
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        System.out.println("El ID_COUTA es : " + ID_COUTA);
        return codigo;
    }

    //--------------------------ELIMINAR CUOTAS---------------------------------
    public boolean eliminarCuotas(int ID_COUTA) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DEL_CUOTAS (?)}");

            cstmt.setInt(1, ID_COUTA);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se eliminaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no eliminada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    //--------------------------Modificar CUOTAS---------------------------------
    public boolean modificarCuotas(int ID_COUTA, int NUM_CASA, Float PRECIO, String TIPO) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_UPD_CUOTAS (?,?,?,?)}");

            cstmt.setInt(1, ID_COUTA);
            cstmt.setInt(2, NUM_CASA);
            cstmt.setFloat(3, PRECIO);
            cstmt.setString(4, TIPO);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se Modificaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no Modificada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    /*-------------------------Agregar ACCESOS---------------------------------------*/
    public boolean registrarAccesos(String CEDULA, String NOMBRE, String APE1, String APE2, int NUM_CASA, String DESCRIPCION, String FECHA) {
        boolean registro = false;
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_ACESSOS(?,?,?,?,?,?,?)}");
            cstmt.setString(1, CEDULA);
            cstmt.setString(2, NOMBRE);
            cstmt.setString(3, APE1);
            cstmt.setString(4, APE2);
            cstmt.setInt(5, NUM_CASA);
            cstmt.setString(6, DESCRIPCION);
            cstmt.setString(7, FECHA);

            int inserta = cstmt.executeUpdate();
            if (inserta > 0) {
                registro = true;
                System.out.println("Se guadaron los datos");

            } else {
                registro = false;
                System.out.println("Información no guardada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + registro);

        return registro;

    }

    public boolean buscarAccesosRepetido(String CEDULA) {
        boolean usuarioRepetido = false;
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT CEDULA from CONDOMINIO.ACCESOS where CEDULA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, CEDULA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRepetido = true;

            } else {

                usuarioRepetido = false;
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e);
            }

        }
        System.out.println("El valor del usuario repetido es:" + usuarioRepetido);
        return usuarioRepetido;
    }

    public int buscarAccesos(String CEDULA) {
        int codigo = 0;
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT CEDULA from CONDOMINIO.ACCESOS where CEDULA = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, CEDULA);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("CEDULA");
            } else {
                codigo = 0;
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        System.out.println("El ID_COUTA es : " + CEDULA);
        return codigo;
    }

    //--------------------------ELIMINAR ACCESOS---------------------------------
    public boolean eliminarAccesos(String CEDULA) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DEL_ACESSOS (?)}");

            cstmt.setString(1, CEDULA);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se eliminaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no eliminada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    //--------------------------Modificar ACCESOS---------------------------------
    public boolean modificarAccesos(String CEDULA, String NOMBRE, String APE1, String APE2, int NUM_CASA, String DESCRIPCION, String HORA) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();

            CallableStatement cstmt = conexion.prepareCall("{call SP_UPD_ACESSOS(?,?,?,?,?,?,?)}");
            cstmt.setString(1, CEDULA);
            cstmt.setString(2, NOMBRE);
            cstmt.setString(3, APE1);
            cstmt.setString(4, APE2);
            cstmt.setInt(5, NUM_CASA);
            cstmt.setString(6, DESCRIPCION);
            cstmt.setString(7, HORA);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se Modificaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no Modificada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    /*-------------------------Agregar Tipo_Dueno---------------------------------------*/
    public boolean registrarTIPO_DUENO(String TIPO, String DESCRIPCION) {
        boolean registro = false;
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_TP_DUENO(?,?)}");
            cstmt.setString(1, TIPO);
            cstmt.setString(2, DESCRIPCION);

            int inserta = cstmt.executeUpdate();
            if (inserta > 0) {
                registro = true;
                System.out.println("Se guadaron los datos");

            } else {
                registro = false;
                System.out.println("Información no guardada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + registro);

        return registro;

    }

    public boolean buscarTipo_DuenoRepetido(String TIPO) {
        boolean usuarioRepetido = false;
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT TIPO from CONDOMINIO.TIPO_DUENO where TIPO = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, TIPO);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRepetido = true;

            } else {

                usuarioRepetido = false;
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e);
            }

        }
        System.out.println("El valor del usuario repetido es:" + usuarioRepetido);
        return usuarioRepetido;
    }

    public int buscarTipo_Dueno(String TIPO) {
        int codigo = 0;
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT TIPO from  CONDOMINIO.TIPO_DUENO where TIPO = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, TIPO);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("TIPO");
            } else {
                codigo = 0;
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        System.out.println("El ID_COUTA es : " + TIPO);
        return codigo;
    }

    //--------------------------ELIMINAR Tipo_Dueno---------------------------------
    public boolean eliminarTipo_Dueno(String TIPO) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DEL_TP_DUENO(?)}");

            cstmt.setString(1, TIPO);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se eliminaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no eliminada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    //--------------------------Modificar Tipo_Dueno---------------------------------
    public boolean modificarTipo_Dueno(String TIPO, String DESCRIPCION) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();

            CallableStatement cstmt = conexion.prepareCall("{call SP_UPD_TP_DUENO(?,?)}");
            cstmt.setString(1, TIPO);
            cstmt.setString(2, DESCRIPCION);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se Modificaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no Modificada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    /*-------------------------Agregar Tipo_CUOTA---------------------------------------*/
    public boolean registrarTIPO_CUOTA(String TIPO, String DESCRIPCION) {
        boolean registro = false;
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_TP_CUOTA(?,?)}");
            cstmt.setString(1, TIPO);
            cstmt.setString(2, DESCRIPCION);

            int inserta = cstmt.executeUpdate();
            if (inserta > 0) {
                registro = true;
                System.out.println("Se guadaron los datos");

            } else {
                registro = false;
                System.out.println("Información no guardada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + registro);

        return registro;

    }

    public boolean buscarTipo_CUOTARepetido(String TIPO) {
        boolean usuarioRepetido = false;
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT TIPO from CONDOMINIO.TIPO_CUOTAS where TIPO = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, TIPO);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuarioRepetido = true;

            } else {

                usuarioRepetido = false;
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e);
            }

        }
        System.out.println("El valor del usuario repetido es:" + usuarioRepetido);
        return usuarioRepetido;
    }

    //--------------------------ELIMINAR Tipo_Dueno---------------------------------
    public boolean eliminarTipo_CUOTA(String TIPO) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_DEL_TP_CUOTA(?)}");
            cstmt.setString(1, TIPO);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se eliminaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no eliminada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    //--------------------------Modificar Tipo_Cuota---------------------------------
    public boolean modificarTipo_CUOTA(String TIPO, String DESCRIPCION) {
        boolean eliminarC = false;

        try {
            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{call SP_UPD_TP_CUOTA(?,?)}");
            cstmt.setString(1, TIPO);
            cstmt.setString(2, DESCRIPCION);

            int inserta = cstmt.executeUpdate();

            if (inserta > 0) {
                eliminarC = true;
                System.out.println("Se Modificaron los datos");

            } else {
                eliminarC = false;
                System.out.println("Información no Modificada");
            }
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " + eliminarC);

        return eliminarC;
    }

    /*------------Metodos de Select Id Duenos--------------------*/
    public ResultSet mostrar_DUENOS() {
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT * from CONDOMINIO.DUENOS";
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        return resultado;
    }

    /*------------Metodos de Select TIPO Id Duenos--------------------*/
    public ResultSet mostrar_TP_DUENOS() {
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT * from CONDOMINIO.TIPO_DUENO";
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        return resultado;
    }

    /*------------Metodos de Select Id FILIARES--------------------*/
    public ResultSet mostrar_FILIARES() {
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT * from CONDOMINIO.FILIARES_CONDOMINIOS";
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        return resultado;
    }

    /*------------Metodos de Select Id TIPO_CUOTAS--------------------*/
    public ResultSet mostrar_TPCUOTAS() {
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT * from CONDOMINIO.TIPO_CUOTAS";
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        return resultado;
    }

    /*------------Metodos de Select Id CUOTAS--------------------*/
    public ResultSet mostrar_CUOTAS() {
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT * from CONDOMINIO.CUOTAS_CONDOMINALES";
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error CUOTA: " + e);

        }
        return resultado;
    }

    /*------------Metodos de Select Id ACCESOS--------------------*/
    public ResultSet mostrar_visitantes() {
        try {

            conexion = ConexionBD.conectar();
            String consulta = "SELECT * from CONDOMINIO.ACCESOS";
            sentencia = conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        return resultado;
    }

    /*------------Metodos de mostrar cursor--------------------*/
    public ResultSet mostrar_cursor() {
        try {

            conexion = ConexionBD.conectar();
            CallableStatement cstmt = conexion.prepareCall("{ call SP_cursor() }");

            resultado = cstmt.executeQuery();
            ResultSet cursor = (ResultSet) cstmt;
            while (cursor.next()) {
                String texto = cursor.getString("v_CEDULA_DUENONivel1");
                texto += " | " + cursor.getString("v_TIPONivel2");
                System.out.println(texto);

            }
            cursor.close();
            cstmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        return resultado;
    }


    //-----------------------------
    public void desactivar_trigger() {
        
        try {

            conexion = ConexionBD.conectar();
              String consulta = "ALTER TRIGGER TR_DUENO_FILIARES DISABLE;";
              //sentencia = conexion.prepareStatement(consulta);
              conexion.createStatement().executeQuery(consulta);
              //sentencia.execute();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro " );

       
    }

}
