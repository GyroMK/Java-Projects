package manejodebbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConsultandoDatos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el idArticulo a buscar: ");
        int idArticulo = teclado.nextInt();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_articulos", "root", "");
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("select descripcion, precio "
                    + "from articulos where idArticulo="
                    + idArticulo);
            if (registro.next()) {			// Nombre del campo de la tabla (descripcion)
                String nom = registro.getString("descripcion");
                System.out.println("Descripción: " + nom);
                System.out.println("Precio: " + registro.getString("precio"));
            } else {
                System.out.println("idArticulo no encontrado :(");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
