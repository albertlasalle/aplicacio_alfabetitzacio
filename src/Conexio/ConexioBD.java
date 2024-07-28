package Conexio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import IniciarSessio.Login;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Albert
 */
public class ConexioBD {

    private static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/aplicacio_alfabetitzacio";

    public static Statement stmt;

    public static boolean PrimeraPantalla = true;

    public static void main(String[] args) {

        Connection cn = Conexion();

        if (cn != null) {

            Login newframe = new Login();

            newframe.setVisible(true);

        } else {
            ErrorConexio newframe = new ErrorConexio();

            newframe.setVisible(true);

        }

    }

    public static Connection Conexion() {

        try {

            Class.forName(driver);

            con = (Connection) DriverManager.getConnection(url, user, pass);

            //System.out.println("Conexion establecida!");
        } catch (ClassNotFoundException | SQLException e) {

            //System.out.println("Error de conexion");
            con = null;
        }
        return con;

    }

}
