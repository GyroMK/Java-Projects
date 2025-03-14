
package controlador;

import java.sql.SQLException;
import vista.Consola;

/**
 *
 * @author sergi.carmona
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Consola c = new Consola();
        c.Menu();
    }
}
