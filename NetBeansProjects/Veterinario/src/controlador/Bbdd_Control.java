package controlador;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Mascotas;
import vista.Consola;

/**
 *
 * @author gonzalo.detomas
 */
public class Bbdd_Control {

    public void insertaDartos(Mascotas mascota) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("insert into mascotas(nombre, tipoAnimal, edad, descripcionSintomas, vacunas) "
                    + "values ('" + mascota.getNombre() + "', '"
                    + mascota.getTipoAnimal() + "', "
                    + mascota.getEdad() + ", '"
                    + mascota.getDescripcionSintomas() + "','"
                    + mascota.getVacunas() + "')");
            conexion.close();
            System.out.println("Mascota guardada correctamente!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaGenerico() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
            Statement consulta = conexion.createStatement();
            ResultSet registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad "
                    + "from mascotas");

            System.out.println("idMascota\tNombre\t\tTipo de Animal\tEdad");
            while (registro.next()) {
                System.out.print("\t" + registro.getString("idMascota"));
                System.out.print("\t" + registro.getString("nombre"));
                System.out.print("\t\t" + registro.getString("tipoAnimal"));
                System.out.println("\t\t" + registro.getString("edad"));
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Mascotas> consultaMascota(Mascotas m) {
        Consola c = new Consola();
        ArrayList<Mascotas> arrlmascotas = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/DB_VETERINARIO", "root", "");
            Statement consulta = conexion.createStatement();

            ResultSet registro = null;

            if (m.getIdMascotas() != -1) {
                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
                        + "from mascotas where idMascota="
                        + m.getIdMascotas());
            } else if (!m.getNombre().equals("ERROR")) { // Preguntamos por la descripci�n
                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
                        + "from mascotas where nombre='"
                        + m.getNombre() + "'");
            } else if (!m.getTipoAnimal().equals("ERROR")) {
                registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
                        + "from mascotas where tipoAnimal='"
                        + m.getTipoAnimal() + "'");
            }
            Mascotas mm = null;
            // Recorremos, registro por registro (fila por fila) el resultado la select anterior
            while (registro.next()) {
                mm = new Mascotas();    // Creamos un objeto mascota por cada fila (cada mm)
                mm.setIdMascotas(Integer.parseInt(registro.getString("idMascota")));
                mm.setNombre(registro.getString("nombre"));
                mm.setTipoAnimal(registro.getString("tipoAnimal"));
                mm.setEdad(Integer.parseInt(registro.getString("edad")));
                mm.setDescripcionSintomas(registro.getString("descripcionSintomas"));
                mm.setVacunas(registro.getString("vacunas"));

                // Guardamos el contenido del registro (fila o mm) dentro del ArrayList
                arrlmascotas.add(mm);
            }
            // Mostramos los datos del ArrayList
            for (Mascotas mascotaActual : arrlmascotas) {
                muestraMascota(mascotaActual);
            }
            return arrlmascotas;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void muestraMascota(Mascotas miMascota) {
        System.out.println("=======================");
        System.out.println("El id de la mascota es: " + miMascota.getIdMascotas());
        System.out.println("Nombre: " + miMascota.getNombre());
        System.out.println("Tipo animal: " + miMascota.getTipoAnimal());
        System.out.println("Edad: " + miMascota.getEdad());
        System.out.println("Descripci�n de los s�ntomas: " + miMascota.getDescripcionSintomas());
        System.out.println("Vacunas: " + miMascota.getVacunas());
    }

    public void modificarDatos() {
        Consola c = new Consola();

        int idMasc = c.pideNum("Introduzca el idMascota a modificar: ");
        String nombreAnimal = c.pideCadena("Introduzca el nombre de animal a modificar: ");
        String tipoAnimal = c.pideCadena("Introduzca el tipo de animal a modificar: ");
        int edad = c.pideNum("Introduzca la edad a modificar: ");
        String sintomas = c.pideCadena("Introduzca los sintomas del animal a modificar: ");
        String vacunas = c.pideCadena("Introduzca las vacunas del animal a modificar: ");

        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/DB_VETERINARIO", "root", "");
            Statement consulta = conexion.createStatement();

            int valor = consulta.executeUpdate("update mascotas set nombre ='" + nombreAnimal + "', tipoAnimal='"
                    + tipoAnimal + "', edad=" + edad + ",descripcionSintomas='"
                    + sintomas + "', vacunas=" + vacunas + " where idMascota=" + idMasc);
            if (valor == 1) {
                c.muestraCadena("Art�culo modificado correctamente");
            } else {
                c.muestraCadena("No existe un art�culo con dicho identificador");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borraDatos() {

        Consola c = new Consola();
        int idMascota = c.pideNum("Introduzca el idMascota a borrar: ");
        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/DB_VETERINARIO", "root", "");
            Statement consulta = conexion.createStatement();
            int valor = consulta.executeUpdate("delete from mascotas where idMascota="
                    + idMascota);
            if (valor == 1) {
                c.muestraCadena("Art��culo borrado correctamente");
            } else {
                c.muestraCadena("No existe un arti�culo con dicho identificador");
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarDatosConPrepareStatement() {
        Consola c = new Consola();

        int idMasc = c.pideNum("Introduzca el idMascota a modificar: ");
        String nombreAnimal = c.pideCadena("Introduzca el nombre de animal a modificar: ");
        String tipoAnimal = c.pideCadena("Introduzca el tipo de animal a modificar: ");
        int edad = c.pideNum("Introduzca la edad a modificar: ");
        String sintomas = c.pideCadena("Introduzca los sintomas del animal a modificar: ");
        String vacunas = c.pideCadena("Introduzca las vacunas del animal a modificar: ");
        
        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/DB_VETERINARIO", "root", "");
            String consultaBD = "update mascotas set nombre =?, tipoAnimal=?, edad=? ,descripcionSintomas=?, vacunas=? where idMascota=?";
            PreparedStatement consultapre = conexion.prepareStatement(consultaBD);           
           
            consultapre.setString(1, nombreAnimal);
            consultapre.setString(2, tipoAnimal);
            consultapre.setInt(3, edad);
            consultapre.setString(4, sintomas);
            consultapre.setString(5, vacunas);
            consultapre.setInt(6, idMasc);
            int rs = consultapre.executeUpdate();
            
            if(rs==1){
                c.muestraCadena(nombreAnimal+" modificado con �xito.");
            }else{
                 c.muestraCadena("Error al modificar: "+nombreAnimal);
            }
            
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
