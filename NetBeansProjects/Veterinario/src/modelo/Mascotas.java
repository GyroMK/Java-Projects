package modelo;
/**
 *
 * @author gonzalo.detomas
 */
public class Mascotas {
    
    private int idMascotas;
    private String nombre;
    private String tipoAnimal;
    private int edad;
    private String descripcionSintomas;
    private String vacunas;
    
    public Mascotas(){
        this.idMascotas=-1;
        this.nombre="ERROR";
        this.tipoAnimal="ERROR";
        this.edad=000000000;
        this.descripcionSintomas="ERROR";
        this.vacunas="ERROR";
    }
    
    public Mascotas(String nombre, String tipoAnimal, int edad, String descripcionSintomas, String vacunas){
        this.nombre=nombre;
        this.tipoAnimal=tipoAnimal;
        this.edad=edad;
        this.descripcionSintomas=descripcionSintomas;
        this.vacunas=vacunas;
    }

    public int getIdMascotas() {
        return idMascotas;
    }

    public void setIdMascotas(int idMascotas) {
        this.idMascotas = idMascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcionSintomas() {
        return descripcionSintomas;
    }

    public void setDescripcionSintomas(String descripcionSintomas) {
        this.descripcionSintomas = descripcionSintomas;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }
    
}//class
