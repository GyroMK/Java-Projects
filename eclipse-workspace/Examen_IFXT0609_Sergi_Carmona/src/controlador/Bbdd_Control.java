package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Personajes;

/**
 *
 * @author Rocio
 */
public class Bbdd_Control {

	public void insertaDatos(Personajes m) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/personajesDisney", "root", "");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into personajes (nombre, pelicula, primeraVez, pareja) "
					+ "values ('" + m.getNombre() + "', '" + m.getPelicula() + "', '" + m.getPrimeraVez() + "', '" + m.getPareja() + "')");
			conexion.close();
			System.out.println("Mascota guardado correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public Personajes consultaPorId(String id) {
    	Personajes personajeActual = new Personajes();
    	
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/personajesDisney", "root", "");
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("select * from personajes where pelicula=" + id);

            if (registro.next()) {
                personajeActual.setId(registro.getInt("id"));
                personajeActual.setNombre(registro.getString("nombre"));
                personajeActual.setPelicula(registro.getString("apellido"));
                personajeActual.setPrimeraVez(registro.getString("anime"));
                personajeActual.setPareja(registro.getString("tipo"));
            }
            conexion.close();
            
            return personajeActual;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public ArrayList<Personajes> consultaPersonajeConFiltro(Personajes m) {
        ArrayList<Personajes> arrlPersonajes = new ArrayList<>();
        ResultSet registro = null;

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/personajesDisney", "root", "");
            Statement consulta = conexion.createStatement();

            if (m.getPelicula() != "ERROR") {
            	System.out.println("select idPersonaje, nombre, pelicula, primeraVez, pareja "
                        + "from personajes where pelicula="
                        + m.getPelicula());
                registro = consulta.executeQuery("select idPersonaje, nombre, pelicula, primeraVez, pareja "
                        + "from personajes where pelicula='"
                        + m.getPelicula()+"'");
            }

            Personajes miPersonaje = null;
            while (registro.next()) {
                miPersonaje = new Personajes();
                miPersonaje.setId(Integer.parseInt(registro.getString("idPersonaje")));
                miPersonaje.setNombre(registro.getString("nombre"));
                miPersonaje.setPelicula(registro.getString("pelicula"));
                miPersonaje.setPrimeraVez(registro.getString("primeraVez"));
                miPersonaje.setPareja(registro.getString("pareja"));
                
                arrlPersonajes.add(miPersonaje);
            }

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrlPersonajes;
    }

    
}// class
