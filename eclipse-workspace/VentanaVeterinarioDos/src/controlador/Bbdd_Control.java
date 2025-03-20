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
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into mascotas (nombre, tipoAnimal, edad, descripcionSintomas, vacunas) "
					+ "values ('" + m.getNombre() + "', '" + m.getTipoAnimal() + "', " + m.getEdad() + ", '"
					+ m.getDescripcionSintomas() + "','" + m.getVacunas() + "')");
			conexion.close();
			System.out.println("Mascota guardado correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

    public Waifus consultaPorId(String id) {
    	Waifus mascotaActual = new Waifus();
    	
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("select * from mascotas where idMascota=" + id);

            if (registro.next()) {
                mascotaActual.setIdMascota(registro.getInt("idMascota"));
                mascotaActual.setNombre(registro.getString("nombre"));
                mascotaActual.setDescripcionSintomas(registro.getString("descripcionSintomas"));
                mascotaActual.setEdad(registro.getInt("edad"));
                mascotaActual.setTipoAnimal(registro.getString("tipoAnimal"));
                mascotaActual.setVacunas(registro.getString("vacunas"));
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
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
            Statement consulta = conexion.createStatement();

            if (m.getIdMascota() != -1) {
                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
                        + "from mascotas where idMascota="
                        + m.getIdMascota());
            } else if (!m.getNombre().equals("ERROR")) {
                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
                        + "from mascotas where nombre='"
                        + m.getNombre() + "'");
            } else if (!m.getTipoAnimal().equals("ERROR")) {
                registro = consulta.executeQuery("select * from mascotas where tipoAnimal='" 
                        + m.getTipoAnimal() + "'");
            }

            Waifus mimascota = null;
            while (registro.next()) {
                mimascota = new Waifus();
                mimascota.setIdMascota(Integer.parseInt(registro.getString("idMascota")));
                mimascota.setNombre(registro.getString("nombre"));
                mimascota.setTipoAnimal(registro.getString("tipoAnimal"));
                mimascota.setEdad(Integer.parseInt(registro.getString("edad")));
                mimascota.setDescripcionSintomas(registro.getString("descripcionSintomas"));
                mimascota.setVacunas(registro.getString("vacunas"));
                
                arrlMascotas.add(mimascota);
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
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
            Statement consulta = conexion.createStatement();
            
            int valor = consulta.executeUpdate("update mascotas set nombre='"
                    + m.getNombre() + "', tipoAnimal='" + m.getTipoAnimal() + "', edad=" + m.getEdad() 
                    + ",descripcionSintomas='" + m.getDescripcionSintomas() + "', vacunas='" + m.getVacunas() 
                    + "' where idMascota=" + m.getIdMascota());

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
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();

			valor = consulta.executeUpdate("delete from mascotas where idMascota=" + m.getIdMascota());
			
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;

	}
}// class
