package manejodebbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertandoDatos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca una descripción para el artículo: ");
        String descripcion = teclado.nextLine();
        System.out.print("Introduzca un precio para el artículo: ");
        float precio = teclado.nextFloat();
        //String nombre = "Gonzalo";
        try {										// Java Data Base Connection
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_articulos", "root", "");

            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("insert into articulos (descripcion, precio) values ('"
                    + descripcion + "'," + precio + ")");
            conexion.close();
            System.out.println("Artículo guardado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
