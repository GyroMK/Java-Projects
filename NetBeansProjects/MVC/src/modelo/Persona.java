package modelo;

/**
 *
 * @author gonzalo.detomas
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private int edad;
    private float altura;
    private boolean casado;
    
    public Persona(){
        this.nombre = "David";
        this.apellido = "Leal";
        this.nacionalidad = "española";
        this.edad = 27;
        this.altura = 1.87f;
        this.casado = true;
    }
    
    public Persona(String nombre, String apellido, String nacionalidad, int edad, float altura, boolean casado) {
        this.nombre = "David";
        this.apellido = "Leal";
        this.nacionalidad = "española";
        this.edad = 27;
        this.altura = 1.87f;
        this.casado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }
    
    
}
