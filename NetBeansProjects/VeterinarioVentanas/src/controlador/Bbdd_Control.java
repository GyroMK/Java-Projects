package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Mascotas;

/**
 *
 * @author Rocio
 */
public class Bbdd_Control {

	public void insertaDatos(Mascotas m) {
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

//    public void consultaGenerico() {
//
//        try {
//            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
//            Statement consulta = conexion.createStatement();
//            ResultSet registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad "
//                    + "from mascotas");
//
//            System.out.println("idMascota\t\tNombre\t\tTipo de animal\t\tEdad");
//            while (registro.next()) {
//                System.out.print("\t" + registro.getString("idMascota"));
//                System.out.print("\t\t" + registro.getString("nombre"));
//                System.out.print("\t\t" + registro.getString("tipoAnimal"));
//                System.out.println("\t\t" + registro.getInt("edad"));
//
//            }
//            conexion.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<Mascotas> consultaGeneral(Mascotas m) {
//        Consola c = new Consola();
//        ArrayList<Mascotas> arrlMascotas = new ArrayList<>();
//        
//
//        ResultSet registro = null;
//
//        try {
//            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
//            Statement consulta = conexion.createStatement();
//
//            if (m.getIdMascota() != -1) {
//
//                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
//                        + "from mascotas where idMascota="
//                        + m.getIdMascota());
//            } else if (!m.getNombre().equals("ERROR")) {
//                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
//                        + "from mascotas where nombre='"
//                        + m.getNombre() + "'");
//            } else if (!m.getTipoAnimal().equals("ERROR")) {
//                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
//                        + "from mascotas where tipoAnimal='" 
//                        + m.getTipoAnimal() + "'");
//            }
//
//            Mascotas mimascota = null;
//            while (registro.next()) {
//                mimascota = new Mascotas();
//                mimascota.setIdMascota(Integer.parseInt(registro.getString("idMascota")));
//                mimascota.setNombre(registro.getString("nombre"));
//                mimascota.setTipoAnimal(registro.getString("tipoAnimal"));
//                mimascota.setEdad(Integer.parseInt(registro.getString("edad")));
//                mimascota.setDescripcionSintomas(registro.getString("descripcionSintomas"));
//                mimascota.setVacunas(registro.getString("vacunas"));
//                
//                c.muestraDatos(mimascota);
//                arrlMascotas.add(mimascota);
//                System.out.println(" dentro " + arrlMascotas.size());
//            }
//            
//            System.out.println(" hay " + arrlMascotas.size());
//
//            conexion.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return arrlMascotas;
//    }
//
//    public void modificaDatos(Mascotas m) {
//        
//        Connection conexion;
//        try {
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
//            Statement consulta = conexion.createStatement();
//            
//            
//
//            int valor = consulta.executeUpdate("update mascotas set nombre ='"
//                    + m.getNombre() + "', tipoAnimal='" + m.getTipoAnimal() + "', edad=" + m.getEdad() + ",descripcionSintomas='" + m.getDescripcionSintomas() + "', vacunas='" + m.getVacunas() + "' where idMascota=" + m.getIdMascota());
//
//            if (valor == 1) {
//                System.out.println("Mascota modificada correctamente");
//            } else {
//                System.out.println("No existe una mascota con dicho identificador");
//            }
//            conexion.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
	public int borraDatos(Mascotas m) {
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
