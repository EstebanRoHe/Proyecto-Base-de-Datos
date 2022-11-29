package SQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE ";
    private static String usuario = "Condominio";
    private static String clave = "root123";
    private static Connection conexion;
    private static PreparedStatement sentencia;
    private static ResultSet resultado;

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error + e");
        }
        return conexion;
    }

   

}
