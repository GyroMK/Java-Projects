package modelo;
/**
 *
 * @author gonzalo.detomas
 */
public class Personajes {
    
    private int id;
    private String nombre;
    private String pelicula;
    private String primeraVez;
    private String pareja;
    
    public Personajes(){
        this.id=-1;
        this.nombre="ERROR";
        this.pelicula="ERROR";
        this.primeraVez="ERROR";
        this.pareja="ERROR";
    }
    
    public Personajes(String nombre, String pelicula, String primeraVez, String pareja){
        this.nombre=nombre;
        this.pelicula=pelicula;
        this.primeraVez=primeraVez;
        this.pareja=pareja;
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

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public String getPrimeraVez() {
		return primeraVez;
	}

	public void setPrimeraVez(String primeraVez) {
		this.primeraVez = primeraVez;
	}

	public String getPareja() {
		return pareja;
	}

	public void setPareja(String pareja) {
		this.pareja = pareja;
	}

}