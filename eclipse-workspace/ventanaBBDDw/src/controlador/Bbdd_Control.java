package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Waifus;

/**
 *
 * @author Rocio
 */
public class Bbdd_Control {

	public void insertaDatos(Waifus m) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into waifus (nombre, apellido, tipo, edad, anime, fecha_nacimiento) "
					+ "values ('" + m.getNombre() + "', '" + m.getApellido() + "', '" + m.getTipo() + "', " + m.getEdad() + ", '"
					+ m.getAnime() + "','" + m.getFecha_nacimiento() + "')");
			conexion.close();
			System.out.println("Mascota guardado correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public Waifus consultaPorId(String id) {
    	Waifus mascotaActual = new Waifus();
    	
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("select * from waifus where id=" + id);

            if (registro.next()) {
                mascotaActual.setId(registro.getInt("id"));
                mascotaActual.setNombre(registro.getString("nombre"));
                mascotaActual.setApellido(registro.getString("apellido"));
                mascotaActual.setAnime(registro.getString("anime"));
                mascotaActual.setEdad(registro.getInt("edad"));
                mascotaActual.setTipo(registro.getString("tipo"));
                mascotaActual.setFecha_nacimiento(registro.getString("fecha_nacimiento"));
            }
            conexion.close();
            
            return mascotaActual;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public ArrayList<Waifus> consultaMascotasConFiltro(Waifus m) {
        ArrayList<Waifus> arrlMascotas = new ArrayList<>();
        ResultSet registro = null;

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
            Statement consulta = conexion.createStatement();

            if (m.getId() != -1) {
                registro = consulta.executeQuery("select id, nombre, apellido, edad, tipo, anime, fecha_nacimiento "
                        + "from waifus where id="
                        + m.getId());
            } else if (!m.getNombre().equals("ERROR")) {
                registro = consulta.executeQuery("select id, nombre, apellido, edad, tipo, anime, fecha_nacimiento "
                        + "from waifus where nombre='"
                        + m.getNombre() + "'");
            } else if (!m.getTipo().equals("ERROR")) {
                registro = consulta.executeQuery("select * from waifus where tipo='" 
                        + m.getTipo() + "'");
            }

            Waifus miWaifu = null;
            while (registro.next()) {
                miWaifu = new Waifus();
                miWaifu.setId(Integer.parseInt(registro.getString("id")));
                miWaifu.setNombre(registro.getString("nombre"));
                miWaifu.setApellido(registro.getString("apellido"));
                miWaifu.setEdad(Integer.parseInt(registro.getString("edad")));
                miWaifu.setTipo(registro.getString("tipo"));
                miWaifu.setAnime(registro.getString("anime"));
                miWaifu.setFecha_nacimiento(registro.getString("fecha_nacimiento"));
                
                arrlMascotas.add(miWaifu);
            }

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrlMascotas;
    }

    public void modificaDatos(Waifus m) {
        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
            Statement consulta = conexion.createStatement();
            
            int valor = consulta.executeUpdate("update waifus set nombre='"
                    + m.getNombre() + "', apellido='"+m.getApellido()+"', tipo='" + m.getTipo() + "', edad=" + m.getEdad() 
                    + ", anime='" + m.getAnime() + "', fecha_nacimiento='" + m.getFecha_nacimiento() 
                    + "' where id=" + m.getId());

            if (valor == 1) {
                System.out.println("Mascota modificada correctamente");
            } else {
                System.out.println("No existe una mascota con dicho identificador");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public int borraDatos(Waifus m) {
		int valor = 0;
		Connection conexion;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();

			valor = consulta.executeUpdate("delete from waifus where id=" + m.getId());
			
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;

	}
}// class
