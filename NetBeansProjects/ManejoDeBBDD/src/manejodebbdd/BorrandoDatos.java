package manejodebbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BorrandoDatos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el idArticulo a borrar: ");
        int idArticulo = teclado.nextInt();

        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_articulos", "root", "");
            Statement consulta = conexion.createStatement();

            int valor = consulta.executeUpdate("delete from articulos where idArticulo="
                    + idArticulo);

            if (valor == 1) {
                System.out.println("Artículo borrado correctamente");
            } else {
                System.out.println("No existe un artículo con dicho identificador");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
