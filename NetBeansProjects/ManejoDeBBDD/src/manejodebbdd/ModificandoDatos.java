package manejodebbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ModificandoDatos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el idArticulo a modificar: ");
        int idArticulo = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Introduzca la descripción a modificar: ");
        String descripcion = teclado.nextLine();
        System.out.print("Introduzca el precio a modificar: ");
        float precio = teclado.nextFloat();

        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_articulos", "root", "");
            Statement consulta = conexion.createStatement();
            // update articulos set descripcion="mando a distancia", 
            //						precio=23 where idArticulo=1
            int valor = consulta.executeUpdate("update articulos set descripcion ='"
                    + descripcion + "', precio=" + precio + " where idArticulo=" + idArticulo);

            // Comprobamos si está bien estructurada la sentencia
            /*System.out.println("update articulos set descripcion ='"
                    + descripcion + "', precio=" + precio + " where idArticulo=" + idArticulo);
            */
            if (valor == 1) {
                System.out.println("Artículo modificado correctamente");
            } else {
                System.out.println("No existe un artículo con dicho identificador");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
