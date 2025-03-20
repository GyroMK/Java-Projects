package modelo;
/**
 *
 * @author gonzalo.detomas
 */
public class Waifus {
    
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String tipo;
    private String anime;
    private String fecha_nacimiento;
    
    public Waifus(){
        this.id=-1;
        this.nombre="ERROR";
        this.apellido="ERROR";
        this.edad=-1;
        this.tipo="ERROR";
        this.anime="ERROR";
        this.fecha_nacimiento="ERROR";
    }
    
    public Waifus(String nombre, String apellido, String tipo, int edad, String anime, String fecha_nacimiento){
        this.nombre=nombre;
        this.nombre=apellido;
        this.edad=edad;
        this.tipo=tipo;
        this.anime=anime;
        this.fecha_nacimiento=fecha_nacimiento;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
    
}